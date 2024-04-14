import java.util.Scanner;
public class ifStatements {

	public static void main(String[] args) {
	
		int score;
		char letterGrade;
		
		System.out.print("Enter your score: ");
		score = (new Scanner(System.in)).nextInt();
		
		if( score <= 100 && score >= 0) {
			//System.out.println("Valid Score!");
			
			if( score >= 90) letterGrade = 'A';
			else if( score >= 80 ) letterGrade = 'B';
			else if( score >= 70 ) letterGrade = 'C';
			else if( score >= 60 ) letterGrade = 'D';
			else letterGrade = 'F';
			
			System.out.println(letterGrade);
			
		}
		else {
			System.out.println("Invalid Score!");
		}
	}

}
