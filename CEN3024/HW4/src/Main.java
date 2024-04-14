import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		BufferedReader in;
		
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\ivanl\\eclipse-workspace\\HW4\\src\\lec.txt")))){
		    String line;
		  	try {
				while((line = br.readLine())!=null){
					String[] split=line.split(",");
					for(int i = 0; i < split.length; i++) {
						System.out.print(split[i] + ", ");
					}
					System.out.println("\n");
				  	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
