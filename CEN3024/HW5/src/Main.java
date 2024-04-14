import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
   public static void main(String[] args) {
      Employee emp1 = new Employee(111, "Jimmy Dean", 5256.32, 0),  
      emp2 = new Employee(598, "Jen Johnson", 47370, 5), 
      emp3 = new Employee(920, "Jan Jones", 47834.25, 1); 
   
      System.out.println(emp1.equals(emp3)); 
 
      ArrayList<Employee> list = new ArrayList<>(); 
 
      list.add(emp1); 
      list.add(emp2); 
      list.add(emp3); 
      
      //System.out.println(list);
      //call the sort method here 
      Collections.sort(list, Employee.NetSalaryCompare);
   
      for (Employee e : list) 
         System.out.println(e); 
   }
}

class Employee {
	//Create the class Employee with int id, String name, double salary and int numberOfDependents as 
	//private attributes. Add the Setters and Getters for each of those attributes, and override the toString 
	//method to print an employee in the format [id,name,net salary], where: 
//	                  Net salary = salary*0.91 + (numberOfDependent *0.01*salary) 

	private int id, numberofdependants;
	private String name;
	private double salary;

	private double netSalary;
	    
		public Employee(int id, String name, double salary, int numberofdependants) {
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.numberofdependants = numberofdependants;
		}

		public int getId() {
	        return this.id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getNumberofdependants() {
	        return this.numberofdependants;
	    }

	    public void setNumberofdependants(int numberofdependants) {
	        this.numberofdependants = numberofdependants;
	    }

	    public String getName() {
	        return this.name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getSalary() {
	        return this.salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
		public double getNetSalary() {
			return netSalary = (salary*0.91)+(numberofdependants * 0.01 * salary);
		}

		public double setNetSalary(double netSalary) {
			this.netSalary = netSalary;
			return netSalary;
		}
	    	
	    //id,name,net salary], where: 
	    //Net salary = salary*0.91 + (numberOfDependent *0.01*salary)       
	    @Override
	    public String toString() {
	        return "[" + id + "," + name + "," + getNetSalary() + "]"; 
	    }

	    @Override
	    public boolean equals(Object obj){
	    	if(this.netSalary == ((Employee) obj).getNetSalary()) {
	    		return true;
	    	}
	    	
	    	else {
	    		return false;
	    	}
	    	
	    }
	    
	    
	    public static Comparator<Employee> NetSalaryCompare = new Comparator<Employee>() {
	    	@Override
	    	public int compare(Employee o1, Employee o2) {
	    		double empSalary1 = o1.getNetSalary();
	    		double empSalary2 = o2.getNetSalary();
	    		return Double.compare(empSalary1, empSalary2);
	    	}
	    };


	}

