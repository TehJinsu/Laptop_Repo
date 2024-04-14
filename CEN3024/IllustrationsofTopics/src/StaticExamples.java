
public class StaticExamples {
	public static void main (String[] args) {
		//static is shared across the whole class
		//it is a shared memory location
		
		Employee e1 = new Employee();//e is an object of class employee
		Employee e2 = new Employee();
		e1.setCompanyName("UCF");
		e2.setCompanyName("UF");//since it is static both e1 and e2 will have UF as the companyName
		
		e1.setName("John");
		e2.setName("Emma");
		
		System.out.println(e1);//this will print the inherited ToString from java
		// this will display the name and the memory location
		
	}//end of main

}
//____________________________________________

class Employee{
	//public static String companyName;//one memory location
	//if this is changed to private you must use setters and getters
	private static String companyName;
	private String Name;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		Employee.companyName = companyName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	//can use extends to make  a class use a whole other class
	
	//This is how to change an inherited method from java
	/*
	@Override
	public String toString(){
		return ("Hello");
	}
	*/
	
}
//______________________________________________

class xyz{
	
}
//_______________________________________________


}