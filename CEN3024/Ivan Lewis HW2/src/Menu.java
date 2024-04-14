import java.util.Scanner;
import java.util.Random;

public class Menu {
	
	public static String [] bookInput;


	
	public static void showMenu() {
		Scanner myScan;
		//scnaner object first then have it read data
		myScan = new Scanner (System.in);
		final int BOOKSTORESIZE = 100;
		final int LIBRARYSIZE = 200;
		String bookstoreorLibrary;
		String bookObjectYN;
		String userBookInput;
		String isBookOnSale;
		double salePercent;
		String [] bookstoreBookEntry = new String[BOOKSTORESIZE];
		for( int k = 0; k < BOOKSTORESIZE; k++)
			bookstoreBookEntry[k] = null;
		String [] libraryBookEntry = new String[LIBRARYSIZE];
		for( int l = 0; l < LIBRARYSIZE; l++)
			libraryBookEntry[l] = null;
		int i = 0;
		int j = 0;
		Random r = new Random();
		int randomInt = r.nextInt(100) + 1;
		
		
		System.out.println("Welcome to the book program! Hit Enter to Continue");
	while (true) {
		myScan.nextLine();
		System.out.println("Would you like to create a book object?");
		//insert a scanner to tell is yes or case case irrelevant
		bookObjectYN = myScan.nextLine();
		
		while (!(bookObjectYN.equalsIgnoreCase("Yes") || bookObjectYN.equalsIgnoreCase("NO"))) {
			System.out.println("Oops! That's not a valid entry. Please try again:");
			bookObjectYN = myScan.nextLine();
		}//end of whileloop to see if entey is valid for creating a book object
		
		if (bookObjectYN.equalsIgnoreCase("Yes")){
			System.out.println("Please enter the author, title and the isbn of the book seperated by /:");
			//another scanner that reads the string and seperates the string after each /
			userBookInput = myScan.nextLine();
			
			bookInput = userBookInput.split("/");			
				
			
			System.out.println("Got it!");
		
			System.out.println("Now, tell me if it is a bookstore book or a library book.(Enter BB for bookstore book or LB for library book):");
			//another scanner case irrelevant that only looks for either BB or LB
			bookstoreorLibrary = myScan.nextLine();
		
			while (!(bookstoreorLibrary.equalsIgnoreCase("BB") || bookstoreorLibrary.equalsIgnoreCase("LB"))) {
				//if statement say if its a BB it goes to this section or LB is else
				System.out.println("Oops! That's not a valid entry. Please try again:");
				bookstoreorLibrary = myScan.nextLine();
				}//end of whileloop for bookstore or library
			
			if (bookstoreorLibrary.equalsIgnoreCase("BB")){
				//Bookstore info here

				System.out.println("Please enter the list price of " + bookInput[1].toUpperCase() +  " by " + bookInput[0].toUpperCase());
				
				BookstoreBook bookstoreBook = new BookstoreBook();
				bookstoreBook.inputBookstoreBook();
				
				bookstoreBook.setPrice(myScan.nextDouble());
				//bookInput[3] = bookstoreBook.getPrice();
				myScan.nextLine();
				
				System.out.println("Is it on sale?");
				isBookOnSale = myScan.nextLine();
				while (!( isBookOnSale.equalsIgnoreCase("yes") || isBookOnSale.equalsIgnoreCase("no"))){
					System.out.println("Invalid entry, please eneter yes or no.");
					isBookOnSale = myScan.nextLine();
				}
				if (isBookOnSale.equalsIgnoreCase("yes")) {
					System.out.println("What is the sale percentage?");
					salePercent = myScan.nextDouble();
					salePercent = salePercent/100;
					
					bookstoreBook.setSalePrice(bookstoreBook.getPrice() - (bookstoreBook.getPrice() * salePercent));

					bookstoreBookEntry[i] = bookstoreBook.toString();
					System.out.println(bookstoreBook.toString());
					i++;
				}
				
				else {
					bookstoreBookEntry[i] = bookstoreBook.toStringNoSale();
					System.out.println(bookstoreBook.toStringNoSale());
					i++;
				}
					
			}
			
		
			else {
			//library book info here
				LibraryBook libraryBook = new LibraryBook();
				libraryBook.inputLibraryBook();
				
				System.out.println("Here is your Library Book information.");
				libraryBook.setBookLocation((bookInput[2].charAt(bookInput[2].length() - 1)) + "." + (bookInput[0].substring(0, 3)) + "." + randomInt);
				//str.charAt(isbn.length() - 1) for last letter of isbn
				//author.substring(0, 3) first 3 of the authors name
				//getRandomInteger(99, 0)) for the rand number from 0-99
				
				libraryBookEntry[j] = libraryBook.toString();
				System.out.println(libraryBook.toString());
				j++;
				System.out.println("Press Enter to Continue");
			}
		}//end of if for bookobjectYN
		
		else {
			//print out both book lists
			System.out.println("Sure!");
			System.out.println("Here are all your books...\n");
			for (int l = 0; l < LIBRARYSIZE; l++)
				if(libraryBookEntry[l] != null)
					System.out.println(libraryBookEntry[l]);
			//library books for loop
			System.out.println("\n- - - -\n");
			for (int k = 0; k < BOOKSTORESIZE; k++)
				if(bookstoreBookEntry[k] != null)
					System.out.println(bookstoreBookEntry[k]);
			//bookstore books for loop
			System.out.println("\n- - - - ");
			System.out.println("\nTake care now!");
			break;
		}//end of else statement
		//add entire function to automate this process and return to do you want add another book
		
		
		}
	}
}


