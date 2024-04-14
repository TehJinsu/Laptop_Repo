
public abstract class Employee extends Person {

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
	
	public Employee(String name, int id, String department) {
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
