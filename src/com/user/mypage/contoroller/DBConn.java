package com.user.mypage.contoroller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	public static Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.27:1521:xe";
		String dbUser="web";
		String dbPwd="web";
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection(url, dbUser, dbPwd);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
