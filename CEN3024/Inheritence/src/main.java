
public class main {

	public static void main(String[] args) {
		
		Employee e = new Employee(111, "Anna");
		Manager m = new Manager (111, "Anna", 25000);
		
		//array of employees
		//Employee [] array = new Employee[100];
		//array[0] = new Manager (333, "Keith", 2546);
		
		System.out.println(m);
	}

}//End of main class
//___________________________________________________

class Employee{
	private int id;
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
	
	
}//End of class employee

class Manager extends Employee{
	
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Manager (int id, String name, double salary) {
		super(id, name);
		this.salary = salary; 
	}
	 public String toString() {
		 return super.toString() + "\tSalary:" + salary;
	 }
}

class Ceo extends Employee{
	public ceo (int w) {
		super (0, name);
	}
}