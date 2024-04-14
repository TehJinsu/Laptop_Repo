
public class Staff extends Employee {
	
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
	
	public Staff(String name, int id, String department, String status) {
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
