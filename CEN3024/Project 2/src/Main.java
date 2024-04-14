import java.util.Scanner;
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
		int id;
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
					System.out.println("ID: ");
					id =  myScan.nextInt();
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
					System.out.println("\tID: ");
					id =  myScan.nextInt();
					System.out.println("\tGpa: ");
					gpa =  myScan.nextDouble();
					System.out.println("\tCredit Hours: ");
					creditHours = myScan.nextInt();
					school.addStudent(name, id, gpa, creditHours);
					System.out.println("Student added!"); 
					break;
					
				case "3":
					System.out.println("Enter the students ID: ");
					id =  myScan.nextInt();
					System.out.println("Here is the tuition invoice for the Student");
					school.invoiceStudent(id);
					break;
					
				case "4":
					System.out.println("Enter the Faculty's ID: ");
					id =  myScan.nextInt();
					school.lookupFaculty(id);
					break;
					
				case "5":
					System.out.println("Enter the Staff info: ");
					myScan.nextLine();
					System.out.println("Name of the Staff: ");
					name = myScan.nextLine();
					myScan.nextLine();
					System.out.println("ID: ");
					id =  myScan.nextInt();
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
					id =  myScan.nextInt();
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

}//END OF RUNNER____________________________________________