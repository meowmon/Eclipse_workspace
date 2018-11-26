package web31.entity;

public class Book {
	private int id;
	private String title;
	private String author;
	private String publishDate;
	
	public Book() {}
	
	public Book(int id, String title, String author, String publishDate) {
		this.id = id;
		this.title = title;
		this.author = author; 
		this.publishDate = publishDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
}
