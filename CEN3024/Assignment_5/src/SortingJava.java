import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortingJava {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		long startTime = System.currentTimeMillis();
		ArrayList<String> nums = new ArrayList<String>();  
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ivanl\\Documents\\GitHub\\Laptop_Repo\\CEN3024\\Assignment_5\\src\\millionsofnumbers.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				//add to Array List
				nums.add(line);
				
				//nums.size will give the lenth f array list
				//nums.size - 1 is the last value
			}

		}
		Collections.sort(nums);
		long endTime = System.currentTimeMillis();
		System.out.println("Java sort took " + (endTime - startTime) + " milliseconds");
	}
}

//long startTime = System.currentTimeMillis();

//doReallyLongThing();

//long endTime = System.currentTimeMillis();

//System.out.println("That took " + (endTime - startTime) + " milliseconds");