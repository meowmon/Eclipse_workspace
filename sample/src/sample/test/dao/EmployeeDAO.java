package sample.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sample.test.bean.EmployeeInfo;
import sample.test.common.ConnectionDB;

public class EmployeeDAO {

	private EmployeeDAO() {

	}

	private static final EmployeeDAO INSTANCE = new EmployeeDAO();

	public static EmployeeDAO getInstance() {
		return INSTANCE;
	}

	public void createEmployee(EmployeeInfo e) {
		Connection con = ConnectionDB.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = con.createStatement();
			
			statement.executeUpdate(
					"INSERT INTO employee(name, age, sports) VALUES ('" + e.getName() + "'," + e.getAge() + ",'" + e.getSports() + "')");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	public List<EmployeeInfo> getEmployees()
	{
		Connection con = ConnectionDB.getInstance().getConnection();
		Statement statement = null;
		List<EmployeeInfo> employees = new ArrayList<>();
		try {
			statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from employee");
			
			EmployeeInfo e;
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String sports = resultSet.getString(4);
				e = new EmployeeInfo(id,name, age, sports);
				employees.add(e);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		return employees;
	}
	
	public void deleteEmployee(int id) {
		Connection con = ConnectionDB.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = con.createStatement();
			
			statement.executeUpdate(
					"delete from employee where id = "+ id);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}

}
