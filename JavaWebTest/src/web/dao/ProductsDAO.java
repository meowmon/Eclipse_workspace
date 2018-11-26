package web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.common.ConnectionDB;
import web.bean.book;
public class ProductsDAO {
	private static final ProductsDAO INSTANCE = new ProductsDAO();

	public static ProductsDAO getInstance() {
		return INSTANCE;
	}
	public void createBook(book e) {
		Connection con = ConnectionDB.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = con.createStatement();
			
			statement.executeUpdate(
					"INSERT INTO book(title, author, publishdate) VALUES ('" + e.getTitle() + "'," + e.getAuthor() + ",'" + e.getPublishdate() + "')");
		
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
	public List<book> getBook()
	{
		Connection con = ConnectionDB.getInstance().getConnection();
		Statement statement = null;
		List<book> books = new ArrayList<>();
		try {
			statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from books");
			
			book e;
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String author = resultSet.getString(3);
				String publishdate = resultSet.getString(4);
				e = new book(id,title, author, publishdate);
				books.add(e);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		return books;
	}
	
	public void deleteBook(int id) {
		Connection con = ConnectionDB.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = con.createStatement();
			
			statement.executeUpdate(
					"delete from books where id = "+ id);
			
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