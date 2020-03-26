package com.user.review.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.user.mypage.contoroller.DBConn;

public class RvDao {
	Connection conn;
	SimpleDateFormat sdf = new SimpleDateFormat("yyy");
	
	public RvDao() {
		conn = DBConn.getConn();
	}
	
	public int rvWrite(int rCode, String eMail, String rContent, int star) {
		PreparedStatement pstmt = null;
		int re = 0;
		String query = "insert into review values(seq_review_rno.nextval,?, ?, ?, sysdate,(select nvl(max(rGroup)+1,1)from review a),0,0,?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rCode);
			pstmt.setString(2, eMail);
			pstmt.setString(3, rContent);
			pstmt.setInt(4, star);
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return re;
	}
}
