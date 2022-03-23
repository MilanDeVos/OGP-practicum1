package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallStateTest {
	BallState ball1;
	BallState ball2;
	BallState ball3;
	
	@BeforeEach
	void setUp() throws Exception {
		ball1 = new BallState(new Point(0,0),new Vector(10,5), new Vector(5,5));
		ball2 = new BallState(new Point(1,2),new Vector(10,10), new Vector(10,10));
		ball3 = new BallState(new Point(20,5),new Vector(5,10), new Vector(2,5));
	}
	
	@Test
	void testBallState() {
		assertEquals(new Point(0,0), ball1.getCenter());
		assertEquals(new Point(1,2), ball2.getCenter());
		assertEquals(new Point(20,5), ball3.getCenter());
		assertEquals(new Vector(10,5), ball1.getSize());
		assertEquals(new Vector(10,10), ball2.getSize());
		assertEquals(new Vector(5,10), ball3.getSize());
		assertEquals(new Vector(5,5), ball1.getVelocity());
		assertEquals(new Vector(10,10), ball2.getVelocity());
		assertEquals(new Vector(2,5), ball3.getVelocity());
	}
	
	@Test
	void testEqualsObject() {
		assertEquals(ball1, ball1);
		assertEquals(ball2, ball2);
		assertEquals(ball3, ball3);
		assertNotEquals(ball1, ball2);
		assertNotEquals(ball1, ball3);
		assertNotEquals(ball2, ball3);
		assertNotEquals(null,ball1);
		assertNotEquals(null,ball2);
		assertNotEquals(null,ball3);
	}
}
