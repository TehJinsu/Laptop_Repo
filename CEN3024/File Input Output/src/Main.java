import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		String data = "John 23";
		
		String name; 
		int age;
		
		/*
		Scanner myScan = new Scanner(data);
		//instead of connecting to keyboard it connectas to String data
		
		name = myScan.next();
		age = myScan.nextInt();
		
		System.out.println(name + " " + age);
		*/
		
		Scanner myScan = new Scanner (new File("data.txt"));
		//you have to use a try/catch block but foe now we add
		//put the file int the folder above the code
		
		/*
		String line; 
		while (myScan.hasNext()) {
			line = myScan.nextLine();
			System.out.println(line);
		}
		*/
		
		//name = myScan.next();
		//age = myScan.nextInt();
		
		//System.out.println(name + " " + age);
		
		BufferedReader myReader = new BufferedReader (new FileReader ("C:\\Users\\ivanl\\eclipse-workspace\\File Input Output\\data.txt"));
		
		String line = myReader.readLine();
		
		while(line != null) {
			//to skip spaces
			//if (!line.equals(" "))
			System.out.println(line);
			line = myReader.readLine();
		}
		System.out.println("____________________________\n");
		
		
		//______________________________________________________________________________________
		
		
		/*BufferedWriter myWriter = new BufferedWriter (new FileWriter("new.txt"));
		
		myWriter.write("Writing to a file");
		
		myWriter.close();
		//you must ahave close in od=rder to write to a file
		*/
		
		File file = new File ("new2.txt");
		if (file.exists())
			System.out.println("File already exists!");
		
		PrintWriter myWriter = new PrintWriter (new File("new2.txt"));
		
		myWriter.println("It's working");
		
		myWriter.close();
		
		/*
		File file = new File ("new2.txt");
		PrintWriter myWriter;
		if (!file.exists())
			myWriter = new PrintWriter("new2.txt");
		else
			myWriter.append("Its working!!");
		
		myWriter.close();
		*/
	}

}
