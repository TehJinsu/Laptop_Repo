import java.util.Scanner;

public class PointRunner {

	public static void main(String[] args) {
		
		Point enteredP = new Point(0, 0);
		Point addsubP = new Point(0, 0);
		Point mathedP = new Point(0, 0);
		
		Double angle;
		Double distance;
		
		Scanner myScan = new Scanner (System.in);
		System.out.println("Enter a number for x");
		
		//No need to add fail statements unless i need to?
		//ask for input of an x and y
		//print the x and y coord
		//this covers the first 4 of the list
		enteredP.setxCoord(myScan.nextDouble());
		myScan.nextLine();
		
		System.out.println("Now Enter a number for y");
		enteredP.setyCoord(myScan.nextDouble());
		myScan.nextLine();
		
		System.out.println("Here is the Point you entered: (" + enteredP.getxCoord() + ", " + enteredP.getyCoord() + ")");
		
		//ask for two new sets of points 
		//set them to a new set of poijnts using constructor
		//add then print 
		System.out.println("Enter a number to add and then subtract to x");
		addsubP.setxCoord(myScan.nextDouble());
		myScan.nextLine();
		
		System.out.println("Now Enter a number to add and then subtract to y");
		addsubP.setyCoord(myScan.nextDouble());
		myScan.nextLine();
		
		mathedP = Point.Add(enteredP, addsubP);
		
		System.out.println("Here is the Points added: (" + mathedP.getxCoord() + ", " + mathedP.getyCoord() + ")");
		
		//do the same again 
		//sub then print
		
		mathedP = Point.Sub(enteredP, addsubP);
		System.out.println("Now here is the same numbers subtracted instead of adding: (" + mathedP.getxCoord() + ", " + mathedP.getyCoord() + ")");
		
		//use method polarCoordangle
		//print
		System.out.println("Now we will convert the original Point to Polar Coordinates");
				
		//use method polarCoordAngle
		//use method polarCoordDisance
		//print
		angle = enteredP.polarCoordAngle();
		distance = enteredP.polarCoordDistance();
		System.out.println("First is the Angle: " + angle);
		System.out.println("Next is the Distance: " + distance);
		
		System.out.println("Now we will covert it back from Polar coordiantes to Cartesian coordinates");
		
		// use method setPolarCoord
		mathedP.setPolarCoord(angle, distance);
		System.out.println("Now here are the two points side by side (" + mathedP.getxCoord() + ", " + mathedP.getyCoord() + ") -------- (" + enteredP.getxCoord() + ", " + enteredP.getyCoord() + ")");
		
		


	}

}
