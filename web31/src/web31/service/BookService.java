package web31.service;

import java.util.List;

import web31.common.BookDAOInterface;
import web31.dao.BookDAO;
import web31.entity.Book;

public class BookService implements BookDAOInterface{

	public BookService(){
	}
	
	private static final BookService INSTANCE = new BookService();
	
	public static BookService getInstance(){
		return INSTANCE;
	}
	
	@Override
	public int addBook(Book book) {
		return BookDAO.getInstance().addBook(book);
	}

	@Override
	public int deleteBook(int id) {
		return BookDAO.getInstance().deleteBook(id);
	}

	@Override
	public int updateBook(Book book) {
		return BookDAO.getInstance().updateBook(book);
	}

	@Override
	public Book getBook(int id) {
		return BookDAO.getInstance().getBook(id);
	}

	@Override
	public List<Book> getAllBook() {
		return BookDAO.getInstance().getAllBook();
	}

}
