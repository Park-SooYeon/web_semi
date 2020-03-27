package com.login.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.mypage.contoroller.DBConn;

public class LoginDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int cnt;
	
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
	
	public boolean membership(LoginVo vo) {
		boolean flag = false;
		try {
			String sql = "insert into membership(mNo, email, pwd, phone, nName, birth) values (seq_membership_mNo.nextval, ?, pkg_crypto.encrypt(?), ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getEmail());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getnName());
			ps.setString(5, vo.getBirth()+"");
			cnt = ps.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
				flag = true;
			}else {
				conn.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
			try { conn.rollback();
			} catch (SQLException e1) {e1.printStackTrace();}
		}finally {
			try {conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
}


















