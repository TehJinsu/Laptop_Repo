
public class LibraryBook {
	
	private String author;
	private String title;
	private String isbn;
	
	private String bookLocation;
	//str.charAt(isbn.length() - 1) for last letter of isbn
	//author.substring(0, 3) first 3 of the authors name
	//getRandomInteger(99, 0)) for the rand number from 0-99

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookLocation() {
		return bookLocation;
	}
	public void setBookLocation(String bookLocation) {
		this.bookLocation = bookLocation;
	}
	
	//CONTRUCTORS
	public LibraryBook() {
	}
	LibraryBook(String author) {
		this.isbn = author;
	}
	public LibraryBook(String author, String title) {
		this.isbn = author;
		this.title = title;
	}
	public LibraryBook(String author, String title, String isbn) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}
	public String toString() { 
		return "[" + isbn + " - " + title + " by " + author + " - " + bookLocation + "]";
	}
	public void inputLibraryBook() {
		author = Menu.bookInput[0];
		title = Menu.bookInput[1];
		isbn = Menu.bookInput[2];
		
	}
}
