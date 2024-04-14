
public class Book {

	//data members must be set to private unless stated otherwise
	private String isbn;
	private double price;
	private static String publisher; // this makes it the same for all the objects
	
	
	
	public static String getPublisher() {
		return publisher;
	}
	public static void setPublisher(String publisher) {
		Book.publisher = publisher;
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
	
	public String toString() { 
		return "[" + publisher + "|ISBN:" + isbn + "|PRICE: $" + price + "]";
	}
	// source generate getters and setters
	/*
	public double getPrice() {
		return price;
	}
	
	public void setPrice (double newPrice) {
		price = newPrice;
	}
	*/
	
	//contructors must be public cannot return any data type and it must have the name of the class
	//can also use Source for constructors
	
	public Book() {
		price = -1;
		isbn = "00000000";
	}
	
	public Book(String isbn) {
		this.isbn = isbn;
	}
	
	public Book(double price) {
		this.price = price;
	}
	
	public Book(String isbn, double price) {
		this.isbn = isbn;
		this.price = price;
	}

}	
