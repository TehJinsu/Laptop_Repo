import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class Main {

	private static String menu() {
		String option;
		System.out.println("Choose one of the options:");
		System.out.println("1-  Enter the information a faculty");
		System.out.println("2-  Enter the information of a student ");
		System.out.println("3-  Print tuition invoice for a student ");
		System.out.println("4-  Print faculty information ");
		System.out.println("5-  Enter the information of a staff member ");
		System.out.println("6-  Print the information of a staff member ");
		System.out.println("7-  Exit Program ");
		
		System.out.println("\tEnter your Selection: ");
		
		option = (new Scanner(System.in)).nextLine();
		return option;
	}
		
	public static void main(String[] args) {
	/*
		Choose one of the options: 
			1-  Enter the information a faculty 
			2-  Enter the information of a student 
			3-  Print tuition invoice for a student 
			4-  Print faculty information 
			5-  Enter the information of a staff member 
			6-  Print the information of a staff member 
			7-  Exit Program 
	*/
		
		String option;
		
		Scanner myScan = new Scanner (System.in);
		
		School school = new School();
		String name;
		String id;
		double gpa;
		int creditHours;
		String department;
		String rank;
		String status;
		System.out.println("\t\t\t\tWelcome to my Personal Management Program");
		do {
			option = menu();
			switch (option) {
				case "1":
					System.out.println("Enter the faculty info: ");
					myScan.nextLine();
					System.out.println("Name of the faculty: ");
					name = myScan.nextLine();
					myScan.nextLine();
					do{
						System.out.println("ID: ");
						id =  myScan.nextLine();
						try{
							if(isValidId(id)){
								break;
							}
						} 
						catch(IdException e){
							System.out.println(e.getMessage());
						}
					}while (true);
					myScan.nextLine();
					System.out.println("Rank: ");
					rank = myScan.nextLine();
					while (!(rank.equalsIgnoreCase("Professor") || rank.equalsIgnoreCase("Adjunct"))) {
						System.out.println("\t" + '"' + rank + '"' + "is invalid");
						rank = myScan.nextLine();
					}
					System.out.println("Department: ");
					department = myScan.nextLine();
					while (!(department.equalsIgnoreCase("Mathematics") || department.equalsIgnoreCase("Engineering") || department.equalsIgnoreCase("Sciences") )) {
						System.out.println("\t" + '"' + department + '"' + "is invalid");
						department = myScan.nextLine();
					}
					school.addFaculty(name, id, rank, department);
					System.out.println("Faculty added!");
					break;
					
				case "2":
					System.out.println("Enter the Student info: ");
					myScan.nextLine();
					System.out.println("\tName of Student:");
					name = myScan.nextLine();
					myScan.nextLine();
					do{
						System.out.println("ID: ");
						id =  myScan.nextLine();
						try{
							if(isValidId(id)){
								break;
							}
						} 
						catch(IdException e){
							System.out.println(e.getMessage());
						}
					}while (true);
					System.out.println("\tGpa: ");
					gpa =  myScan.nextDouble();
					System.out.println("\tCredit Hours: ");
					creditHours = myScan.nextInt();
					school.addStudent(name, id, gpa, creditHours);
					System.out.println("Student added!"); 
					break;
					
				case "3":
					System.out.println("Enter the students ID: ");
					id =  myScan.nextLine();
					System.out.println("Here is the tuition invoice for the Student");
					school.invoiceStudent(id);
					break;
					
				case "4":
					System.out.println("Enter the Faculty's ID: ");
					id =  myScan.nextLine();
					school.lookupFaculty(id);
					break;
					
				case "5":
					System.out.println("Enter the Staff info: ");
					myScan.nextLine();
					System.out.println("Name of the Staff: ");
					name = myScan.nextLine();
					myScan.nextLine();
					do{
						System.out.println("ID: ");
						id =  myScan.nextLine();
						try{
							if(isValidId(id)){
								break;
							}
						} 
						catch(IdException e){
							System.out.println(e.getMessage());
						}
					}while (true);
					System.out.println("Department: ");
					department = myScan.nextLine();
					while (!(department.equalsIgnoreCase("Mathematics") || department.equalsIgnoreCase("Engineering") || department.equalsIgnoreCase("Sciences") )) {
						System.out.println("\t" + '"' + department + '"' + "is invalid");
						department = myScan.nextLine();
					}
					System.out.println("Status, Enter P for Part-Time or F for Full-Time: ");
					status = myScan.nextLine();
					while (!(status.equalsIgnoreCase("P") || status.equalsIgnoreCase("F"))) {
						System.out.println("\t" + '"' + status + '"' + "is invalid");
						status = myScan.nextLine();
					}
					if(status.equalsIgnoreCase("f")) {
						status = "Full-Time";
					}
					else if (status.equalsIgnoreCase("p")) {
						status = "Part-Time";
					}
					school.addStaff(name, id, department, status);
					System.out.println("Staff added!");
					break;
					
				case "6":
					System.out.println("Enter the Staff's ID: ");
					id =  myScan.nextLine();
					school.lookupStaff(id);
					break;
					
				case "7":
					System.out.println("Goodbye!");
					break;
					
				default : System.out.println("Invalid Input....");
				
					
			}//END OF SWITCH STATEMENTS_____________________
		}while (!option.equals("7"));
		//END OF DO WHILE LOOP______________________________
		
	}//END OF MAIN__________________________________________

	static boolean isValidId(String id) throws IdException {
		
		String idOrder = "^[A-z]{2}[0-9]{4}$";

		boolean isOrder = Pattern.matches(idOrder, id);

		if(!isOrder){
			throw new IdException("Invalid Id format. Must be LetterLetterDigitDigitDigitDigit");
		}

		else{
			return true;
		}
	}

}//END OF RUNNER____________________________________________


class School {
	private Person people[];
	private final int SIZE = 100;

	public School() {
		people = new Person[SIZE];
	}
	
	public School(Person people[]) {
		this.people = people;
	}
	
	public String toString() {
		String all = "LIST OF ALL PEOPLE IN THE SCHOOL \n";
		
		for(Person p : people) {
			all += p.toString()+ "\n---------------------------------------\n";
		}
			
		all += "______________________________________\n";
		
		return all;
	}//END OF TOSTRING
	
	int index= 0;
	
	private int searchById (String id) {
		for (index = 0; index < SIZE; index++) {
			if(people[index] == null) {
				break;
			}
			else if(people[index].getId() == id) {
				return index;
			}
		}		
		return -1;	
	}
	
	int count = 0;
	
	public void addFaculty(Person p) {
		people[count] = p;
		count++;
	}//END OF ADDFACULTY_____________________________________

	
	public void addStudent(String name, String id, double gpa, int creditHours) {
		people[count] = new Student(name, id, gpa, creditHours);
		count++;
	}//END OF ADDSTUDENT_____________________________________
	
	public void invoiceStudent(String id){
		if (searchById(id) == -1) {
			System.out.println("No match found for Student!");
		}
		else {
			people[index].print();
		}
	}
	//LOOK INTO INSTANCEOF
	public void lookupFaculty(String id) {
		if (searchById(id) == -1) {
			System.out.println("No match found for Faculty!");
		}
		else {
			people[index].print();
		}
	}

	public void addFaculty(String name, String id, String rank, String department) {
		people[count] = new Faculty(name, id, rank, department);
		count++;
	}
	
	public void lookupStaff(String id) {
		if (searchById(id) == -1) {
			System.out.println("No match found for Staff!");
		}
		else {
			people[index].print();
		}
	}
	
	public void addStaff(String name, String id, String department, String status) {
		people[count] = new Faculty(name, id, department, status);
		count++;
	}
	/* add these functions here
	 * Choose one of the options: 
		1-  Enter the information a faculty 
		2-  Enter the information of a student 
		3-  Print tuition invoice for a student 
		4-  Print faculty information 
		5-  Enter the information of a staff member 
		6-  Print the information of a staff member 
		7-  Exit Program 
	 */
	
	
}//END OF CLASS SCHOOL______________________________________


abstract class Person {
	
	//full name and ID
	private String name;
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public Person() {
		this.name = "";
		this.id = "";
	}
	
	@Override
	public String toString() {
		return name + "\t\t" + id;
	}
	
	public abstract void print();
}//END OF CLASS PERSON______________________________________

class Student extends Person {

	//full name ID gpa and credit hours
	DecimalFormat df = new DecimalFormat("0.00");	
	
	private double gpa;
	private int creditHours;
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public int getCreditHours() {
		return creditHours;
	}
	
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	public Student() {
		super();
		gpa = 0.0;
		creditHours = 0;
	}
	
	public Student(String name, String id, double gpa, int creditHours) {
		super(name, id);
		this.gpa = gpa;
		this.creditHours = creditHours;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nCredit Hours: " + creditHours + " (236.45/credit hour)\nFees: $52\n\n";
	}
	
	@Override
	public void print() {
		double fee;
		double discountedFee;
		
		//something fee invoice something something
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(toString());
		fee = creditHours * 236.45 + 52;
		discountedFee = fee;
		if(gpa >= 3.85) {
			discountedFee = discountedFee * 0.75;
		}
		
		System.out.println("Total payment(after discount): " + df.format(discountedFee) + "\t\t($" + df.format(fee - discountedFee) + " discount applied");
		System.out.println("---------------------------------------------------------------------------");
	}
	
	//the print statement prints the fee invoice
}//END OF CLASS STUDENT______________________________________


abstract class Employee extends Person {

	//full name ID and department
	
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Employee() {
		super();
		department = "";
	}
	
	public Employee(String name, String id, String department) {
		super(name, id);
		this.department = department;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + department + " Department";
	}
	
	@Override
	public void print() {
		//something fee invoice something something
	}
	
}//END OF CLASS EMPLOYEE______________________________________


class Faculty extends Employee{

	//full name ID department rank
	
	private String rank;

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public Faculty() {
		super();
		rank = "";
	}
	
	public Faculty(String name, String id, String department, String rank) {
		super(name, id, department);
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + rank;
	}
	
	@Override
	public void print() {
		//something fee invoice something something
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(toString());
		System.out.println("---------------------------------------------------------------------------");
	}//the print statement prints the pertaining info
}//END OF CLASS FACULTY______________________________________


class Staff extends Employee {
	
	//full name ID department and status (full or part time)
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Staff() {
		super();
		status = "";
	}
	
	public Staff(String name, String id, String department, String status) {
		super(name, id, department);
		this.status = status;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t\t" + status;
	}
	
	@Override
	public void print() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(toString());
		System.out.println("---------------------------------------------------------------------------");
	}//the print statement prints the pertaining info
}//END OF CLASS STAFF______________________________________

class IdException extends Exception{
	public IdException(String returnex){
		super(returnex);
	}
}


