import java.text.DecimalFormat;

public class BookstoreBook {
	
	private String author;
	private String title;
	private String isbn;
	
	private double price;
	private boolean sale;// this is just a true false statement to tell if its on sale or not.
	private double	salePrice;
	
	DecimalFormat df = new DecimalFormat("0.00");	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isSale() {
		return sale;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public void setSale(boolean sale) {
		this.sale = sale;
	}

	
	//CONSTRUCTOR
	public BookstoreBook() {
	}
	
	public BookstoreBook(String isbn) {
		this.isbn = isbn;
	}
	
	public BookstoreBook(boolean sale) {
		this.sale = sale;
	}

	public String toString() { 
		return "[" + isbn + " - " + title + " by " + author + ", " + "$" + df.format(price) + " listed for $" + df.format(salePrice) + "]";
	}
	
	public String toStringNoSale() {
		return "[" + isbn + " - " + title + " by " + author + ", " + "$" + df.format(price) + "]";
		
	}
	
	public void inputBookstoreBook() {
		author = Menu.bookInput[0];
		title = Menu.bookInput[1];
		isbn = Menu.bookInput[2];
		
	}
}
