import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		/* Cat cat = new Cat();
		SportsCar sportscar = new SportsCar();
		
		cat.makeNoise();
		sportscar.makeNoise();
		
		System.out.println(cat);
		*/
		
		Cat cat1, cat2, cat3;
		cat1 = new Cat();
		cat2 = new Cat();
		cat3 = new Cat();
		
		cat1.setAge(2);
		cat2.setAge(7);
		cat3.setAge(5);
		
		ArrayList <Cat> list = new ArrayList<Cat>(500);
		list.add(cat2);
		list.add(cat1);
		list.add(cat3);
		
		list.sort(null);
		
		//to use the toString just print list
		System.out.println(list);
	}

}
//END OF MAIN______________________________________________________________________________
class Animal {
	String breed;
	
	public String toString(){
		return "Animal";
	}
}
//END OF CLASS ANIMAL_____________________________________________________________________

//naming convention for interfaces mean you ad able to the end of it
interface Noiseable {
	public void makeNoise();
}//interfaces are useless with out additional classes
//interfaces can only have abstract method 
//you can implement more than 1 interface into a class but only 1 abstract class
//END OF INTERFACE NOISE___________________________________________________________________

interface Runnable{
	public void run();
}
//END OF INTERFACE RUNNABLE________________________________________________________________

class Cat extends Animal implements Noiseable, Runnable, Comparable<Cat>, Comparator<Cat>{
	
	private int age;
	private String name;
	
	public int compareTo(Cat cat) {
		if(this.age == cat.age) {
			return 0;
		}
		
		if(this.age > cat.age) {
			return 1;
		}
		
		return -1;
	}
	
	public int compare(Cat cat1, Cat cat2) {
		return cat1.age - cat2.age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void makeNoise() {
		System.out.println("Meow");
	}//just like abstract needs same signature
	
	public void run() {
		System.out.println(" running and jumping without reason");
	}
	
	@Override
	public String toString() {
		return super.toString() + ": Cat " + age ;
	}


}
//END OF CLASS CAT_________________________________________________________________________

class SportsCar implements Noiseable {
	public void makeNoise() {
		System.out.println("Vroom Vroom");
	}
}
//END OF CLASS SPORTSCAR___________________________________________________________________