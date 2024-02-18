import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SortingLomuto {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		ArrayList<String> nums = new ArrayList<String>();  
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ivanl\\Documents\\GitHub\\Laptop_Repo\\CEN3024\\Assignment_5\\src\\millionsofnumbers.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				//add to Array List
				nums.add(line);
			}
		}    
	}
}