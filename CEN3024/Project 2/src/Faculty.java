
public class Faculty extends Employee{

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
	
	public Faculty(String name, int id, String department, String rank) {
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
	

