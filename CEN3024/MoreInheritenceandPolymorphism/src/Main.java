import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static String menu() {
		String option;
		System.out.println("1 - Add Salaried");
		System.out.println("2 - Add Manger");
		System.out.println("3 - Add Hourly Paid");
		System.out.println("4 - Promote Salaried to Manager");
		System.out.println("5 - Fire All Hourly Paid Employees");
		System.out.println("6 - Print Info Given an Id");
		System.out.println("7 - Give 10% Raise");
		System.out.println("8 - Print all Employees");
		System.out.println("9 - Print Employees by Salary");
		System.out.println("0 - Exit\n");
		
		System.out.println("Enter your Choice: ");
		
		option = (new Scanner(System.in)).nextLine();
		return option;
	}
	
	public static void main(String[] args) {
		
		/*Employee e;
		e = new Manager("Erika Jones", 111, 25000, 3600.25);
		//System.out.println(e instanceof Manager); // this will return true if there is a manager named e
		//if e instanceof manager = true set stuff to ____
		 e.printIncome();
		 e = new Salaried("Jill Jones", 222, 4988);
		 e.printIncome();*/
		 
		/*ArrayList<Employee> list = new ArrayList<>();
		list.add(new Manager("Manager 1", 1, 1, 1));
		
		Company company = new Company(list);
		
		company.hireEmployee(new HourlyPaid("Hourly Paid 2", 22, 22));
		
		System.out.println(company);
		*/
		
		String option;
		String data;
		Scanner myScan = new Scanner (System.in);
		Company company = new Company();
		int id;
		String name;
		double salary, bonus, hoursWorked;
		String [] tokens;
		
		
		do {
			option = menu();
			switch (option) {
				case "1" : 
					System.out.println("Enter id, name, and salary");
					data = myScan.nextLine();	
					tokens = data.split(",");
					id = Integer.parseInt(tokens[0]);
					name = tokens[1];
					salary = Double.parseDouble(tokens[2]);
					company.hireEmployee(new Salaried(name, id, salary));
					break;
					
				case "2" :
					System.out.println("Enter id, name, salary, and bonus");
					data = myScan.nextLine();	
					tokens = data.split(",");
					id = Integer.parseInt(tokens[0]);
					name = tokens[1];
					salary = Double.parseDouble(tokens[2]);
					bonus = Double.parseDouble(tokens[3]);
					company.hireEmployee(new Manager(name, id, salary, bonus));
					break;
					
				case "3" :
					System.out.println("Enter id, name, and hours worked");
					data = myScan.nextLine();	
					tokens = data.split(",");
					id = Integer.parseInt(tokens[0]);
					name = tokens[1];
					hoursWorked = Double.parseDouble(tokens[2]);
					company.hireEmployee(new Salaried(name, id, hoursWorked));
					break;
					
				case "4" :	
					System.out.println("Enter the id of the employee: ");
					id = myScan.nextInt();
					if (! company.promoteToManager(id)) {
						System.out.println("Wrong Id");
					}
					else System.out.println("Promotion finished!");
					break;
					
				case "5" :
					company.fireAllHourlyPaid();
					break;
				
				case "6" :
					System.out.println("Enter the id of the employee: ");
					id = myScan.nextInt();
					company.printInfo(id);
					break;
					
				case "7" :
					System.out.println("Enter the id of the employee: ");
					id = myScan.nextInt();
					company.promote(id);
					break;
					
				case "8" :
					System.out.println(company);
					break;
					
				case "9" :
					System.out.println("Enter the Salary: ");
					salary = myScan.nextDouble();
					company.printBySalary(salary);
					break;
					
				case "0" :
					System.out.println("Have a good day!");
					break;
					
				default : System.out.println("Invalid input.....");
					
					
			}//END OF SWITCH STATEMENTS___________________________________________
				
		}while (option.equals("0"));
		 
	}
	//END OF MAIN METHOD____________________________
}
//END OF DRIVER_____________________________________

abstract class Employee{
	//abstract only works for inheritance
	
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public Employee() {
		this.name = "";
		this.id = 0;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	
	abstract public void printIncome();//this is polymorphism
	
	
}
//END OF CLASS EMPLOYEE___________________________________

class HourlyPaid extends Employee{
	
	private double hoursWorked;

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public HourlyPaid() {
		super();
		hoursWorked = 0.0;
	}
	
	public HourlyPaid(String name, int id, double hoursWorked) {
		super(name, id);
		this.hoursWorked = hoursWorked;
	}

	@Override
	public String toString() {
		return super.toString() + "\tTotal Hours Worked: " + hoursWorked;
	}
	
	@Override
	public void printIncome() {
		System.out.println(hoursWorked * 15);
	}
	
}
//END OF CLASS HOURLYPAID

class Salaried extends Employee{
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Salaried(String name, int id, double salary) {
		super(name, id);
		this.salary = salary;
	}	
	public Salaried() {
		super();
		this.salary = 0.0;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tSalary: " + salary;
	}
	
	@Override
	public void printIncome() {
		System.out.println(salary);
	}
}
//END OF CLASS SALARIED

class Manager extends Salaried{
	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Manager(String name, int id, double salary, double bonus) {
		super(name, id, salary);
		this.bonus = bonus;
	}
	
	public Manager() {
		super();
		this.bonus = 0.0;
	}
	
	public Manager (Salaried salaried) {
		setId(salaried.getId());
		setSalary (salaried.getSalary());
		setName (salaried.getName());
		bonus = 800.25;	
	}//this constuctor is used to promote a salaried to manager
	
	@Override
	public String toString() {
		return super.toString() + "Bonus: " + bonus;
	}
	
	@Override
	public void printIncome() {
		super.printIncome();
		System.out.println("+ Bonus" + bonus);
		}
	
} 
