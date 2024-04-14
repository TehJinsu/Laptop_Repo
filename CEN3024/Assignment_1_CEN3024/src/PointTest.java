import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	public void testAdd() {
		Point p1 = new Point(5, 10);
		Point p2 = new Point(12, 24);
		double addedX = p1.getxCoord() + p2.getxCoord();
		double addedY = p1.getyCoord() + p2.getyCoord();
		Point addedP = new Point(addedX, addedY);
		assertEquals(17, addedP.getxCoord());
		assertEquals(34, addedP.getyCoord());
	}
	
	@Test
	public void testSub() {
		Point p1 = new Point(17, 40);
		Point p2 = new Point(12, 24);
		double subbedX = p1.getxCoord() - p2.getxCoord();
		double subbedY = p1.getyCoord() - p2.getyCoord();
		Point subbedP = new Point(subbedX, subbedY);
		assertEquals(5, subbedP.getxCoord());
		assertEquals(16, subbedP.getyCoord());
	}
	
	@Test
	public void testPolarCoordAngle() {
		Point p1 = new Point(12, 34);
		assertEquals(Math.atan2(34, 12), p1.polarCoordAngle());
	}
	
	@Test
	public void testPolarCoordDistance() {
		Point p1 = new Point(5, 8);
		assertEquals(25, Math.pow(p1.getxCoord(), 2));
		assertEquals(64, Math.pow(p1.getyCoord(), 2));
	}
	
	@Test
	public void testSetPolarCoord() {
		Point p1 = new Point(5, 6);
		double p1Angle = Math.atan2(p1.getyCoord(), p1.getxCoord());
		double p1Distance = Math.sqrt(Math.pow(p1.getxCoord(), 2) + Math.pow(p1.getyCoord(), 2));
		assertEquals(p1Distance * Math.cos(p1Angle), p1Distance * Math.cos(p1Angle));
		assertEquals(p1Distance * Math.sin(p1Angle), p1Distance * Math.sin(p1Angle));
		
	}

}
