
import java.lang.Math; 
public class Point {
	
	private double xCoord;
	
	private double yCoord;
	/**
	 * This gets the x Coordinate
	 * @return This returns the x Coordinate
	 */
	public double getxCoord() {
		return xCoord;
	}
	/**
	 * This sets the x coordinate
	 * @param xCoord uses getxCoord to set the x Coordinate
	 */
	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}
	/**
	 * This gets the y Coordinate
	 * @return This returns the y coordinate
	 */
	public double getyCoord() {
		return yCoord;
	}
	/**
	 * This sets the y Coordinate
	 * @param yCoord This uses getyCoord to set the y Coordinate
	 */
	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}
	
	//make a var for both x and y
	/**
	 * This is a Constructor for a point
	 * @param xCoord This is the x Coordinate
	 * @param yCoord This is the y Coordinate
	 */
	public Point(double xCoord, double yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	//________________________END OF CONSTRUCTOR POINT
	
	/**
	 * This adds the two coordinates
	 * @param currentP The current point 
	 * @param newP The point being added
	 * @return This returns the added x and y point
	 */
	public static Point Add(Point currentP, Point newP) {
		double x = currentP.getxCoord() + newP.getxCoord();
		double y = currentP.getyCoord() + newP.getyCoord();
		return new Point(x,y);
	}
	//_________________________END OF ADD

	/**
	 * This subtracts two coordinates
	 * @param currentP The current point
	 * @param newP The point being added
	 * @return This returns the subtracted x and y point
	 */
	public static Point Sub(Point currentP, Point newP) {
		double x = currentP.getxCoord() - newP.getxCoord();
		double y = currentP.getyCoord() - newP.getyCoord();
		return new Point(x,y);
	}
	//_________________________END OF SUB

	/**
	 * This returns the angle between two coordinates
	 * @return This returns the angle of the point
	 */
	public double polarCoordAngle() {
	// use atan() and import java Math
		return Math.atan2(yCoord, xCoord);
	}
	//_________________________END OF POLARCOORDANGLE
	
	/**
	 * This returns the distance between two points
	 * @return This returns the square root of x squared plus y squared
	 */
	public double polarCoordDistance() {
		//sqrt(x^2+y^2)
		return Math.sqrt(Math.pow(xCoord, 2)+ Math.pow(yCoord, 2));
	}
	//_________________________END OF POLARCOORDISTANCE
	
	/**
	 * This converts the angle and distance into a Polar Coordinate
	 * @param coordAngle Uses the polarCoordAngle function
	 * @param coordDistance Uses the polarCoordDistance Function
	 */
	public void setPolarCoord(double coordAngle, double coordDistance) {
		//polar coord is length and direction(angle)
		this.xCoord = coordDistance * Math.cos(coordAngle);
		this.yCoord = coordDistance * Math.sin(coordAngle);
	}
	//_________________________END OF SETPOLARCOORD
	

}
//_________________________END OF CLASS POINT