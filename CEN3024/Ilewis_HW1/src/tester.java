import java.text.DecimalFormat;
//THIS IS SUPER IMPORTANT AS WELL
import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		Scanner myScan;
		DecimalFormat df = new DecimalFormat("0.00");
		//REMEBER THIS FOR OTHER ASSIGNMENTS
		myScan = new Scanner (System.in);
		String employeeName;
		String employeeNumber;
		double employeePay;
		int employeeHours;
		double grossPay;
		double taxDeductions;
		double netPay;
		
		System.out.print("Enter the Employee's full name: ");
		employeeName = myScan.nextLine();
		
		System.out.print("Enter the Employee's number: ");
		employeeNumber = myScan.nextLine();
		
		System.out.print("Enter the pay rate per hour: ");
		employeePay = myScan.nextFloat();
		
		System.out.print("Enter the hours worked: ");
		employeeHours = myScan.nextInt();
		
		grossPay = employeePay * employeeHours;
		taxDeductions = grossPay * 0.06;
		netPay = grossPay - taxDeductions;
		
		System.out.println("\nThank You!");
		
		System.out.println("\nHere is your paycheck!");
		
		System.out.println("\n\n\n________________________________________");
		
		System.out.println("\nEmployee Name:\t\t" + employeeName);
		System.out.println("Employee Number:\t" + employeeNumber);
		System.out.println("Hourly rate of pay:\t" + "$" + df.format(employeePay));
		//the df.format forces however many decimal places i state from line 9 
		System.out.println("Hours Worked:\t\t" + employeeHours);
		
		System.out.println("\nTotal Gross Pay:\t" + "$" + df.format(grossPay));
		
		System.out.println("\nDeductions");
		System.out.println("Tax (6%):\t\t" + "$" + df.format(taxDeductions));
		
		System.out.println("\nNet Pay:\t\t" + "$" + df.format(netPay));
		
		System.out.println("________________________________________");
		
		System.out.println("\n\n\nBye!");
	}
	
	
}
