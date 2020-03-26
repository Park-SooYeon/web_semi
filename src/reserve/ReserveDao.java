package reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.mypage.contoroller.DBConn;

public class ReserveDao {
	Connection conn;
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	public ReserveDao() {
		conn = DBConn.getConn();
	}
	
	// 디비에 데이터 추가
	protected boolean insert() {
		boolean result = true;
		
		try {
			sql = "insert into reserve(컬럼명) values(1)";
			this.ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 디비에 데이터 삭제
	protected boolean delete() {
		boolean result = true;
		
		return result;
	}
}
