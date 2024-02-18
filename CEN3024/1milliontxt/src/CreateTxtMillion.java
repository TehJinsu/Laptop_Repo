import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateTxtMillion {


	public static void main(String[] args) {
		
		Random rand = new Random();
		
		try {
			PrintWriter writer = new PrintWriter("millionsofnumbers.txt");
			
			for (int i = 0; i < 1000000; i++) {
				writer.println(rand.nextInt(10000000));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done!");
		
	}

}
