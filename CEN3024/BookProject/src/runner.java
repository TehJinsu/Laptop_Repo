import java.util.Scanner;

public class runner {

	public static void main(String[] args) {
		
		Menu myMenu = new Menu();
		BookList myList = new BookList();
		String isbn;
		Book book;
		double price;
		Scanner myScan = new Scanner (System.in);
		
		
		Book.setPublisher("UCF Publishing");
		
		myMenu.showOptions();
		int selection = myMenu.getChoice();
		
		while ( selection != 0) {
			switch (selection) {
			case 1 : 
				myList.printBooks();
				break;
				
			case 2:
				System.out.print("Enter the isbn: ");
				isbn = (new Scanner(System.in)).nextLine();
				myList.printBookInfo(isbn);
				break;
				
			case 3: 
				myList.sortByIsbn();
				//myList.printBooks();
				break;
				
			case 4:
				myList.sortByPrice();
				break;
				
			case 5:
				System.out.print("Enter the price");
				price = myScan.nextDouble();
				myScan.close();
				
				myScan = new Scanner(System.in);
				
				System.out.print("Enter the isbn");
				isbn = myScan.nextLine();
				
				book = new Book(isbn, price);
				if( !myList.addBook(book))
					System.out.print("Can't add a book");
				else
					System.out.print("Book added!");
				
				break;
				
			case 6:
				System.out.print("Enter the isbn: ");
				isbn = myScan.nextLine();
				
				if( !myList.removeBook(isbn))
					System.out.print("Wrong isbn");
				else
					System.out.print("Book removed");
				break;
			}//end of switch
			
			selection = myMenu.getChoice();
		}//end of loop
			System.out.print("Thanks for using my Library Program!");
	}//end of main

}


//split method
/* String info = "John Smith,123 Street Some Street, Orlando";
String[] item = info.split(",");

for (String string : item) {
	System.out.println(string);
}

for (int i = 0; item <item.legth; i++) {
	System.out.println(item[i]);
}
*/