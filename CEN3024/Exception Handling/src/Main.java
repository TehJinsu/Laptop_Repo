import java.util.Scanner;

public class Main {

	class MyException extends Exception{
		private String message;
		
		public MyException() {
			message = "Invalid ID";
		}
		public String getMessage(){
		return message;
		}
		
		public String toString() {
			return message;
		}
		
	}
	public static void main(String[] args) throws Exception{
		
		int id;
		do {
		System.out.println("Enter the id, Must be <- 100");
		id = (new Scanner(System.in)).nextInt();
		
		try {
			if (id > 100) throw new MyException();
			System.out.println("Thank you, ID is valid");
		}
		
		catch(MyException e) {
			System.out.println(e.getMessage());
		}
		
		}while (id > 100);
		/*
		int i = 1, j = 0;
		String name = null;
		int k = 0;
		
		try {
			k = Integer.parseInt("Hello");//NUMBER FORMAT EXCEPTION
			System.out.println(name.length());//NULL pOINTER EXCePTION
			System.out.println(i/j);//ARITHMETIC EXCEPTION
		}
		//try to see if the code in the block of try will crash
		
		catch(NullPointerException e) {
			System.out.println("Null Pointer Issue");
		}
		//if there is a error the catch will run
		catch(ArithmeticException e) {
			System.out.println("Divide by zero Issue");
		}
		
		catch(NumberFormatException e) {
			System.out.println("Parser Issue");
		}
		
		catch(Exception e) {
			System.out.println("Different Issue");//can alos use println (e) and use the toString from the excepton class
		}
		//finally cannot be by itself
		finally {
				System.out.println("This happens regardless");
		}
		
		System.out.println("Done!");

		*/
	}

}
