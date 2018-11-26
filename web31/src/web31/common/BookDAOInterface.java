package web31.common;

import java.util.List;

import web31.entity.Book;

public interface BookDAOInterface {
	public int addBook(Book book);
	public int deleteBook(int id);
	public int updateBook(Book book);
	public Book getBook(int id);
	public List<Book> getAllBook();
}
