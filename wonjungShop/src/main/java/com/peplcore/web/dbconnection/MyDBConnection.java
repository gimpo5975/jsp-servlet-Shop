package com.peplcore.web.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.peplcore.web.dbconnection.DBCon.*;

public class MyDBConnection {
	public static Connection getConnection() throws SQLException { //throws ClassNotFoundException, SQLException
		Connection con = null;
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//con = DriverManager.getConnection(DBCon.URL, DBCon.USER, DBCon.PASSWORD);
				
			} catch (ClassNotFoundException e) {
			   System.out.println("예외 발생");
			}
			   con = DriverManager.getConnection(URL, USER, PASSWORD);
			   System.out.println("접속 성공");
	     return con;
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}	
	
}
