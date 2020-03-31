package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.DBConn;

public class SearchDao {
	Connection conn;
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	public SearchDao() {
		conn = DBConn.getConn();
	}
	
	protected String search(String findStr) {
		String data = null;
		System.out.println(findStr);
		
		try {
			sql = "select rCode, rname, rplace from rooms "
				+ " where rname like ? or rplace like ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + findStr + "%");
			ps.setString(2, "%" + findStr + "%");
			
			rs = ps.executeQuery();
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			while(rs.next()) {
				String code = rs.getInt("rCode") + ""; // String으로 변환
				String str = String.format("{'rCode':'%s', 'rName':'%s', 'rPlace':'%s'},",
											code, rs.getString("rName"), rs.getString("rPlace"));
				sb.append(str);
			}
			
			data = sb.toString();
			data = data.replaceAll("\'", "\"");
			if(data.length()>1) { // 데이터가 있을 경우에만 실행
				data = data.substring(0, data.length()-1); // 마지막 콤마 제거	
			}
			data += "]";
		} catch (SQLException e) {
			System.out.println("findStr 검색 중 오류 발생!");
			e.printStackTrace();
		}
	
		return data;
	}

	protected String rsSearch(String rCode, String checkIn, String checkOut) {
		String data = null;
		
		try {
			sql = "select roomCode from ( " + 
					"    select checkin , checkout, roomCode " + 
					"    from reserve " + 
					"    where rCode=? " + 
					" ) " + 
					" where ? >= to_char(checkIn, 'rrrr-mm-dd') and to_char(checkOut, 'rrrr-mm-dd') > ? " + 
					" or ? > to_char(checkIn, 'rrrr-mm-dd') and to_char(checkOut, 'rrrr-mm-dd') >= ? " + 
					" group by roomcode ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, rCode);
			ps.setString(2, checkIn);
			ps.setString(3, checkIn);
			ps.setString(4, checkOut);
			ps.setString(5, checkOut);
			
			rs = ps.executeQuery();
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			while(rs.next()) {
				String code = rs.getInt("roomCode") + ""; // String으로 변환
				String str = String.format("{'roomCode':'%s'},", code);
				sb.append(str);
			}
			
			data = sb.toString();
			data = data.replaceAll("\'", "\"");
			if(data.length()>1) { // 데이터가 있을 경우에만 실행
				data = data.substring(0, data.length()-1); // 마지막 콤마 제거	
			}
			data += "]";
		} catch (SQLException e) {
			System.out.println("예약 현황 select 중 오류 발생!");
			e.printStackTrace();
		}
		
		return data;
	}
}
