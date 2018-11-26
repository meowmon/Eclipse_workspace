package web.bean;

public class book {
	private int id;
	private String title;
	private String author;
	private String publishdate;
	public book(String title, String author, String publishdate) {
		this.title = title;
		this.author = author;
		this.publishdate = publishdate;
	}
	public book(int id, String title, String author, String publishdate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishdate = publishdate;
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
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
}
