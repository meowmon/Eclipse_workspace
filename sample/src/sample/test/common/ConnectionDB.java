package sample.test.common;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
public class ConnectionDB {
	
	private ConnectionDB() {}
	
	private static final ConnectionDB INSTANCE = new ConnectionDB();
	
	public static ConnectionDB getInstance() {
		return INSTANCE;
	}
	
	
	public Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tester?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf-8","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
