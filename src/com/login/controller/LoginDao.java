package com.login.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.mypage.contoroller.DBConn;

public class LoginDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public LoginDao() {
		conn = DBConn.getConn();
	}
	
	public LoginVo login(String email, String pwd) {
		LoginVo vo = new LoginVo();
		try {
			String sql = "select email, nName from membership where email=? and pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setEmail(rs.getString("email"));
				vo.setnName(rs.getString("nName"));
				vo.setFlag(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return vo;			
		}
		
	}
	
}
