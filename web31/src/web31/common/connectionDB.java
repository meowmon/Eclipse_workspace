package web31.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {
private connectionDB(){}
	
	private static final connectionDB INSTANCE = new connectionDB();
	
	public static connectionDB getInstace(){
		return INSTANCE;
	}
	
	private static Connection conn = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static String DB_URL = "jdbc:mysql://localhost/employee";
	public static String USER = "root";
	public static String PASSWORD = "1111";
	
	public Connection getConnect(){
		if(conn != null){
			return conn;
		}else{
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				
				System.out.println("connect to Mysql successfully!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("failes connection!");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failes connection!");
			}
			return conn;
		}
	}
}
