
public class tester {

	public static void main(String[] args) {
		//refrences are pointers		
		//this line is essentially a malloc call
		
		//Book myBook;
		
		
		//if you have a . in the line then it must have an object i.e. it must be initialized
		//Book.setPublisher("abc");
		
		
		Book b1 = new Book("123456", 12.99);
		Book.setPublisher("rty");
		//this set.Publisher will be over written by the next set Publisher
	
		Book b2 = new Book("789012", 99.12);
		//b2.setPublisher("xyz");
		
		/*Book b1 = new Book();
		
		Book [] list;
		
		list = new Book[5000];
		
		list[2] = new Book();
		
		list[2].setIsbn("123456"); */
		
		//b1.setPrice(82);
		//b1.setIsbn("123456");
		
		//System.out.println(b1.getIsbn() + "  " + b1.getPrice());

		//toString is a very importatn factor for printing classes
		
		//using set publisher on the main will casue ALL new books to have that publisher becasue it is static
		
		
		System.out.println(b1);
		System.out.println(b1.toString() + b2.toString());
	}
	
	//CONTRUCTORS SETTERS GETTERS TO STRINGS
	//DATA MEMBERS TO PRIVATE

}
