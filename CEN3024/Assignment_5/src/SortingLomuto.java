import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class SortingLomuto {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		
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
		
		long startTime = System.currentTimeMillis();
		ArrayList<String> nums = new ArrayList<String>();  
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ivanl\\Documents\\GitHub\\Laptop_Repo\\CEN3024\\Assignment_5\\src\\millionsofnumbers.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				//add to Array List
				nums.add(line);
			}
		}  
		//sorting goes here
		/*
	partition(arr[], lo, hi) 
    pivot = arr[hi]
    i = lo-1     // place for swapping
    for j := lo to hi – 1 do
        if arr[j] <= pivot then
            i = i + 1 
            swap arr[i] with arr[j]
    swap arr[i+1] with arr[hi]
    return i+1
		 */
		
		//nums.size will give the lenth f array list
		//nums.size - 1 is the last value
		int length = nums.size() - 1;
		quickSort(nums, 0, length -1);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Lomuto sort took " + (endTime - startTime) + " milliseconds");
	}

static void Swap (ArrayList<String> numsList,int pos1, int pos2) {
//this function is to swap the two elements in the list
	//first is the box for the num getting replaced
	String temp = numsList.get(pos1);
	
	//swap the numbers
	numsList.set(pos1, numsList.get(pos2));
	numsList.set(pos2, temp);
	
}

static int partition(ArrayList<String> numsList,int low, int high) {
	
	//set pivot
	int pivot = Integer.parseInt(numsList.get(high));
	
	int i = low - 1;
	//for loop to see if current is less than pivot
	for (int j = low; j <= high - 1; j++) {
		if (Integer.parseInt(numsList.get(j)) <= pivot) {
			i++;
			Swap(numsList, i, j);
		}
	}
	Swap(numsList, i+1, high);
	//returns the index to continue sorting
	return i + 1;
}

static void quickSort(ArrayList<String> numsList,int low, int high) {
	if (low<high) {
		int pi = partition(numsList, low, high);
		
		//now recursively sort
		quickSort(numsList, low, pi - 1);
		quickSort(numsList, pi + 1, high);
	}
}



}