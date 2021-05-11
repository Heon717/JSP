package com.koreait.board4;

import java.sql.*;

public class DBU {
	public static Connection getcon() throws Exception {
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/boardver4";
		final String U_NAME = "root";
		final String PASSWORD = "koreait";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL,U_NAME,PASSWORD);
		System.out.println("연결 성공!!");
		
		return con;
	}
	public static void close(Connection con, PreparedStatement ps) {
		close(con,ps,null);
	}
	
	public static void close(Connection con, PreparedStatement ps,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch 
				(SQLException e) {e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch 
				(SQLException e) {e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch 
				(SQLException e) {e.printStackTrace();
			}
		}
		
	}
}
