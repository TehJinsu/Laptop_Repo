import java.util.ArrayList;

public class Company {
	private ArrayList<Employee> list;
	private final int SIZE = 100;
	
	public Company() {
		list = new ArrayList<Employee>(SIZE);
	}
	
	public Company(ArrayList<Employee> list) {
		this.list = list;
	}
	
	public String toString() {
		String all = "LIST OF ALL EMPLOYEES\n";
		
		for(Employee e : list) {
			all += e.toString()+ "\n---------------------------------------\n";
		}
			
		all += "______________________________________\n";
		
		return all;
	}//END OF TOSTRING___________________________________________
	int index = 0;
	
	private int searchById (int id) {
		for (Employee e : list) {
			index++;
			if (e.getId()== id) {
				return index;
			}
		}	
		return -1;	
	}//END OF SEARCHBYID_________________________________________

	public void printBySalary (double salary) {
		for (Employee e : list) {
			if (e instanceof Salaried || e instanceof Manager) {
				if ( ((Salaried)e).getSalary() == salary) {
					System.out.println(e);
				}
			}
		}
	}//END OF PRINTBYSALARY_______________________________________
	
	public void deleteById (int id) {
		int index = searchById(id);
		if (index != -1) {
			list.remove(index);
		}
	}//END OF DELETEBYID__________________________________________
	
	public void hireEmployee(Employee e) {
		list.add(e);
	}//END OF HIREEMPLOYEE________________________________________
	
	public void promote (int id) {
		/*if (e instanceof Salaried)
			((Salaried) e).setSalary(((Salaried) e).getSalary()*1.1);*/
		
		//can alos do
		if (index == -1) {
			return;
		}
		
		int index = searchById(id);
		if(list.get(index) instanceof Salaried salaried) 
			salaried.setSalary(salaried.getSalary()*2);
		
		//this crates a varieble to use instead of casting
		
		else if (list.get(index) instanceof HourlyPaid hourly)
			hourly.setHoursWorked(hourly.getHoursWorked() *2);
	}//END OF PROMOTOE____________________________________________
	
	public void printInfo(int id) {
		int index = searchById(id);
		
		if( index == -1) {
			System.out.println(id + " not found as an employee!");
			return;
		}
		
		System.out.println(list.get(index));
		//this will print the infoo of the employee when supplied with the id
		
		
	}//END OF PRINTINFO___________________________________________
	
	public void fireAllHourlyPaid() {
		for (int index = 0; index < list.size() ; index++) {
			if( list.get(index) instanceof HourlyPaid hourly)
				list.remove(hourly);
		}
	}//END OF FIREALLHOURLYPAID__________________________________
	
	public void sortById() {
		//after we cover Java Interfaces
	}
	
	public boolean promoteToManager (int id) {
		int index = searchById(id);
		
		if (index == -1) return false;
		
		if ((list.get(index) instanceof Salaried salaried) && ! (list.get(index) instanceof Manager));
		{
			Manager manager = new Manager(salaried);
			list.add(manager);
			list.remove(index);
			return true;
		}
		return false;
	}
}	