
public class School {
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
	
	private int searchById (int id) {
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

	
	public void addStudent(String name, int id, double gpa, int creditHours) {
		people[count] = new Student(name, id, gpa, creditHours);
		count++;
	}//END OF ADDSTUDENT_____________________________________
	
	public void invoiceStudent(int id){
		if (searchById(id) == -1) {
			System.out.println("No match found for Student!");
		}
		else {
			people[index].print();
		}
	}
	//LOOK INTO INSTANCEOF
	public void lookupFaculty(int id) {
		if (searchById(id) == -1) {
			System.out.println("No match found for Faculty!");
		}
		else {
			people[index].print();
		}
	}

	public void addFaculty(String name, int id, String rank, String department) {
		people[count] = new Faculty(name, id, rank, department);
		count++;
	}
	
	public void lookupStaff(int id) {
		if (searchById(id) == -1) {
			System.out.println("No match found for Staff!");
		}
		else {
			people[index].print();
		}
	}
	
	public void addStaff(String name, int id, String department, String status) {
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
