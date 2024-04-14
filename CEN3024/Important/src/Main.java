
/* class MyInteger{
	public int data;
	//this wraps the int in class to change the data to 100
	//java has wrapper classes to do this
}


public class Main {

	public static void main(String[] args) {
		MyInteger age = new MyInteger();
		age.data = 7;
		
		
		System.out.println("The old age is "+ age);
		
		change (age);
		
		System.out.println("The new age is "+ age);
	}
	
	private static void change(MyInteger myInteger) {
		myInteger.data = 100;
	}
}*/

class MyString{
	public String data;
	//you would then change age to age.data'
	//MyString age = new MyString
}

public class Main {

	public static void main(String[] args) {
		Integer age = 7;
		//Integer is an immutable class 
		// all 8 primitive data types
		// Boolean Double etc,etc
		//for String you need to create a new class to wrap the wrapper
		change (age);
		
		System.out.println("After the age is "+ age);
		
	}
	
	private static void change(Integer x) {
		x = 100;
	}
}
