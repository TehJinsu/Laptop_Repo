import java.util.Arrays;

/* Name: Ivan Lewis
 * Dr. Andrew Steinberg
 * COP3503 Fall 2022
 * Programming Assignment 4
 */
public class LCS {
	
	//two private attributes for holding the strings
	private String string1, string2;
	private int[][] twoDArrayint;
	private char[][] twoDArraychar;
	private char [] Arr;
	private char [] Arr2; 
	private int i, j;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}
	
	//contrcutor for two string objexts
	public LCS(String first, String second) {
		setString1(first);
		setString2(second);
	}

	//this is the dynamic programming solution
	public void lcsDynamicSol() {
		//two for loops to traverse through our arrays
		//get length of the two strings
		//+2 becasue of the inate row of zeros adding 1 to our length
		twoDArrayint = new int [string1.length() + 2][string2.length() + 2];
		twoDArraychar = new char [string1.length() + 2][string2.length() + 2];
		
		int k, l;
		
		setI(string1.length());
		setJ(string2.length());
		
		for (k = 0; k < getI(); k++) {
			twoDArrayint[k][0] = 0;
		}
		
		for (l = 0; l < getJ(); l++) {
			twoDArrayint[0][l] = 0;
		}
				
		
		Arr = string1.toCharArray();
		Arr2 = string2.toCharArray();
		
		//System.out.println(Arr2);
		
		//double for loop to itterate through both 2d arrays 
		for(k = 1; k <= getI(); k++) {
			for(l = 1; l <= getJ(); l++) {
				//-1 becasue the intial ARr start at 0
				if(Arr[k-1] == Arr2[l-1]) {
					twoDArrayint[k][l] = twoDArrayint[k - 1][l - 1] + 1;
					twoDArraychar[k][l] = '↖';
				}
				
				else if(twoDArrayint[k - 1][l] >= twoDArrayint[k][l - 1]) {
					twoDArrayint[k][l] = twoDArrayint[k - 1][l];
					twoDArraychar[k][l] = '↑';
				}
				
				else {
					twoDArrayint[k][l] = twoDArrayint[k][l - 1];
					twoDArraychar[k][l] = '←';
				}
			}
		}
		

		//if x[i] = y[j] diagonal
		//if x[i] != y[j] x-1 up
		//if x[i] != y[j] y-1
		//two for loops 
		//System.out.println(Arrays.deepToString(twoDArraychar).replace("], ", "]\n"));
		
	}
	
	public String getLCS() {
		//↑ alt 24, ↓ alt 25, → alt 26 ↗ ↙↘(just copy it) 
		
		String phrase = "";
		
		int i = getI();		
		int j = getJ();
		
		while(i != 0 || j != 0) {
			//System.out.println(phrase);
			if(i == 0 || j == 0) {
				return phrase;
			}
			if(twoDArraychar[i][j] == '↖'){
				i--;
				j--;
				phrase = Arr[i] + phrase;
			}
			
			else if(twoDArraychar[i][j] == '↑') {
				i--;
			}
			
			else {
				j--;
			}
		}
		System.out.println(phrase);
		return phrase;
		
	}
	
	
}
