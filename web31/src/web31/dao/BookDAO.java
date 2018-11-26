package web31.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web31.common.BookDAOInterface;
import web31.common.connectionDB;
import web31.entity.Book;


public class BookDAO implements BookDAOInterface{
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public BookDAO(){
	}
	
	private static final BookDAO INSTANCE = new BookDAO();
	
	public static BookDAO getInstance(){
		return INSTANCE;
	}

	@Override
	public int addBook(Book book) {
		conn = connectionDB.getInstace().getConnect();
		int status = 0;
		String sql = "INSERT INTO book(title, author, publishdate) VALUES(?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getPublishDate());
			
			status = stmt.executeUpdate();
		} catch (Exception e) {
		}
		return status;
	}

	@Override
	public int deleteBook(int id) {
		conn = connectionDB.getInstace().getConnect();
		int status = 0;
		String sql = "DELETE FROM book WHERE id = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			status = stmt.executeUpdate();
		} catch (Exception e) {
		}
		return status;
	}

	@Override
	public int updateBook(Book book) {
		conn = connectionDB.getInstace().getConnect();
		int status = 0;
		String sql = "UPDATE book set id =?, title=?, author=?, publishdate=? WHERE id=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, book.getId());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getPublishDate());
			stmt.setInt(5, book.getId());
			
			status = stmt.executeUpdate();
		} catch (Exception e) {
		}
		return status;
	}

	@Override
	public Book getBook(int id) {
		conn = connectionDB.getInstace().getConnect();
		Book book = new Book();
		String sql = "select *from book where id = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublishDate(rs.getString(4));
			}
		} catch (Exception e) {
		}
		return book;
	}

	@Override
	public List<Book> getAllBook() {
		conn = connectionDB.getInstace().getConnect();

		List<Book> listBook = new ArrayList<>();
		String sql = "select *from book";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Book book = new Book();
				
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublishDate(rs.getString(4));
				
				listBook.add(book);
			}
		} catch (Exception e) {
		}
		return listBook;
	}
	
	
}
