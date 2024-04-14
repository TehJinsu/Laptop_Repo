import java.text.DecimalFormat;

public class Student extends Person {

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
	
	public Student(String name, int id, double gpa, int creditHours) {
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
