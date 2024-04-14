import java.util.Scanner;

public class Menu {
	public void showOptions() {
		System.out.println("\n\t\t_____________________________________________\n\n");
		
		System.out.println("\n\t\t1-Print all Books\n");
		System.out.println("\n\t\t2-Print the infor of a book given the ISBN\n");
		System.out.println("\n\t\t3-Sort books by ISBN\n");
		System.out.println("\n\t\t4-Sort books by Price\n");
		System.out.println("\n\t\t5-Add a book\n");
		System.out.println("\n\t\t6-Remove a book\n");
		System.out.println("\n\t\t0-Exit Program\n");
	}
	
	public int getChoice() {
		int option;
		do {
		System.out.println("Enter your selection: ");
		option = (new Scanner(System.in)).nextInt();
		}while( !(option <= 6 && option >= 0));
			return option;
	}
}
