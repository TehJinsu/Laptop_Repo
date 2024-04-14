import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/* Ivan Lewis
   Dr. Steinberg
   COP3503 Fall 2022
   Programming Assignment 3
*/

public class GreedyChildren {
	public int [] greedArr;
	public int [] sweetnessArr;
	
	private int candy;
	private int children;
	public int happyKids;
	public int angryKids;
	
	public int getCandy() {
		return candy;
	}
	public void setCandy(int candy) {
		this.candy = candy;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}

	public GreedyChildren(int candy, int children, String greedyFile, String sweetnessFile) throws FileNotFoundException {
		//read files and insert into int Array
		setCandy(candy);
		setChildren(children);
		read(greedyFile, sweetnessFile);
	}
	
	public void read(String greedyFile, String sweetnessFile) throws FileNotFoundException {
		//according to eclipse Arrays.sort runs in nlogn time
		Scanner scanner = new Scanner(new File(greedyFile));
		greedArr = new int [getChildren()];
		int i = 0;
		while(scanner.hasNextInt()){
		   greedArr[i++] = scanner.nextInt();
		}
		Arrays.sort(greedArr);
		scanner.close();
		
		scanner = new Scanner(new File(sweetnessFile));
		sweetnessArr = new int [getCandy()];
		int j = 0;
		while(scanner.hasNextInt()){
		   sweetnessArr[j++] = scanner.nextInt();
		}
		Arrays.sort(sweetnessArr);
		scanner.close();
		
		//why is only one arrya showing up? shits fucked yo
		
		
		
	}
	
	public void greedyCandy() {
		//in order to make this work we must start at the end of the arrays
		//we have to --i every loop
		
		int i = getCandy() - 1;
		int j = getChildren() - 1;


		//if sweetness is greaTER than greedy factor decremnt both arrays
		//+1 to hppy children
		
		//if greeedy is greater than sweetness decrment chikd array
		// add 1 to angry mofos
		
		//candy arr is i
		// child arr is j
		
		while(j >= 0) {
			if(sweetnessArr[i] >= greedArr[j]) {
				happyKids++;
				i--; 
				j--;
			}
			else {
				angryKids++;
				j--;
			}
		}
		
	}
	
	public void display() {
		System.out.println("There are " + happyKids + " happy children.");
		System.out.println("There are " + angryKids + " angry children.");
	}
}


