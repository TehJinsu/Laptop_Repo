
public abstract class Person {
	
	//full name and ID
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
	
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public Person() {
		this.name = "";
		this.id = 0;
	}
	
	@Override
	public String toString() {
		return name + "\t\t" + id;
	}
	
	public abstract void print();
}//END OF CLASS PERSON______________________________________
