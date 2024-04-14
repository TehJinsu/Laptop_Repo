import java.util.Scanner;

public class ForLoopandSwitches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int score;
		char letterGrade = 'X';
		
		System.out.println("Enter your grade:");
		score = (new Scanner(System.in)).nextInt();	
	
		while (score > 100 || score < 0) {
			System.out.println("Enter your REAL score:");
			score = (new Scanner(System.in)).nextInt();		
		}
			
		
	if (score <= 100 && score >= 0) {
		switch (score/10) {
		
		case 10:
		case 9: 
			letterGrade = 'A';
			break;
		
		case 8: 
			letterGrade = 'B';
			break;
		
		case 7: 
			letterGrade = 'C';
			break;
		
		case 6: 
			letterGrade = 'D';
			break;
			
		default:
			letterGrade = 'F';
		}
	}
	if (letterGrade != 'X') {
		System.out.println(letterGrade);
	}
	else {
		System.out.println("Invalid Score");
		}
	}
}
	
	
	//letterGrade = score > 100 || score < 0 ? 'x' : score >= 90 ? 'A' : score >= 80 ? 'B' : score >= 70 ? 'C': score >= 60 ? 'D' : score = 'F';
	
	//DO WHILE
	
	/*do {
		System.out.println("Enter your grade:");
		score = (new Scanner(System.in)).nextInt();	
	}while (score > 100 || score < 0); *\

	
