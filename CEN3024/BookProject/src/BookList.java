
public class BookList {

	private Book [] list;
	final int SIZE = 1000;
	
	public BookList() {
		list = new Book[SIZE];
		for( int i = 0; i < SIZE; i++)
			list[i] = null;
	}
	
	public void printBooks() {
		
		System.out.println("Here are the Books!");
		for(Book b: list) {
			if ( b != null)
				System.out.println(b);
			}
		}
			
		//this is equivalent to
			//for (int i = 0; i < SIZE; i++)
				//if(list[i] != null)
					//System.out.println(list[i]);
			
	private int indexOfNull () {
		int index = -1; 
		for (int i = 0; i < SIZE; i++)
			if (list[i] == null) {
				index = i;
				break;
			}
		return index;
	}
		
		
	private int indexOfIsbn (String isbn) {

		for (int i = 0; i < SIZE; i++) {
			if (list[i] != null) {
				if(isbn.equalsIgnoreCase(list[i].getIsbn()))
					return i;
			}
		}
		return -1;
	}
	public boolean addBook( Book book) {
	
		int index = indexOfNull();
		if (index == -1) return false;
		list[index] = book;
		return true;
	}
	
	public boolean removeBook(String isbn) {
		
		int index = indexOfIsbn(isbn);
		if (index == -1) return false;
		list[index] = null;
	
		return true;
	}
	
	//you can overload named functions by having a different input type
	// i.e. can have a string isbn and a book book have the same name.
		
	public void printBookInfo (String isbn) {
		int index = indexOfIsbn (isbn);
		
		if (index == -1) System.out.println("Wrong ISBN");
		else System.out.println(list[index]);
	}
	
	//keep it in the class
	
	public void sortByPrice() {
		//sorting by price
		double temp = 999;
		int index = -1;
		Book ref;
		int start = 0;
	
		do {
			temp = 999;
			for (int i = 0; i < SIZE; i++) {
				if ( list[i] != null && list[i].getPrice() < temp) {
					index = i;
						}//end of if
				}//end of for
				ref = list[index];
				list[index] = list[0];
				list[start] = ref;
				start++;
				
			}//end of do
		while (start < SIZE -1);
		}//end of method
	
	public void sortByIsbn() {
		//sorting by price
		String temp = "z";
		int index = -1;
		Book ref;
		int start = 0;
	
		do {
			temp = "~";
			for (int i = 0; i < SIZE; i++) {
				if ( list[i] != null && list[i].getIsbn().compareTo(temp) < 0) {
					temp = list[i].getIsbn();
					index = i;
						}//end of if
				}//end of for
				ref = list[index];
				list[index] = list[0];
				list[start] = ref;
				start++;
				
			}//end of do
		while (start < SIZE -1);
		}//end of method
}//end of class


