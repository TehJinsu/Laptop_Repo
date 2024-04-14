import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortingJava {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		Random rand = new Random();
		
		int numOfNums = rand.nextInt(9000000) + 1000000;
		try {
			PrintWriter writer = new PrintWriter("millionsofnumbers.txt");
			
			for (int i = 0; i < numOfNums; i++) {
				writer.println(rand.nextInt(10000000));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done!");
		
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
		System.out.println("Java sort took " + (endTime - startTime) + " milliseconds with " + numOfNums + " words");
	}
}

//long startTime = System.currentTimeMillis();

//doReallyLongThing();

//long endTime = System.currentTimeMillis();

//System.out.println("That took " + (endTime - startTime) + " milliseconds");