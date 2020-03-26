package com.user.review.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.user.mypage.contoroller.DBConn;

public class RvDao {
	Connection conn;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public RvDao() {
		conn = DBConn.getConn();
	}
	
	public void rvWrite(int rCode, String eMail, String rContent, int star) {
		PreparedStatement pstmt = null;
		ResultSet set = null;
		int cnt = 0;
		int sum = 0;
		double re = 0;
		String query = "insert into review values(seq_review_rno.nextval,1, ?, ?, sysdate,(select nvl(max(rGroup)+1,1)from review a),0,0,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eMail);
			pstmt.setString(2, rContent);
			pstmt.setInt(3, star);
			re = pstmt.executeUpdate();
			
			query="select count(stars) cnt, sum(stars) sum from review";
			pstmt = conn.prepareStatement(query);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				cnt = set.getInt("cnt");
				sum = set.getInt("sum");
			}
			System.out.println(rCode);
			System.out.println(cnt);
			System.out.println(sum);
			re = sum/(double)cnt;
			System.out.println(re);
			query = "update rooms set stars=? where rCode = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, re);
			pstmt.setInt(2, rCode);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
}
