package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaddleStateTest {
	PaddleState paddle1;
	PaddleState paddle2;
	PaddleState paddle3;
	
	@BeforeEach
	void setUp() throws Exception {
		paddle1 = new PaddleState(new Point(0,0),new Vector(10,5));
		paddle2 = new PaddleState(new Point(1,2),new Vector(10,10));
		paddle3 = new PaddleState(new Point(20,5),new Vector(5,10));
	}
	
	@Test
	void testBallState() {
		assertEquals(new Point(0,0), paddle1.getCenter());
		assertEquals(new Point(1,2), paddle2.getCenter());
		assertEquals(new Point(20,5), paddle3.getCenter());
		assertEquals(new Vector(10,5), paddle1.getSize());
		assertEquals(new Vector(10,10), paddle2.getSize());
		assertEquals(new Vector(5,10), paddle3.getSize());
	}
	@Test
	void testEqualsObject() {
		assertEquals(paddle1, paddle1);
		assertEquals(paddle2, paddle2);
		assertEquals(paddle3, paddle3);
		assertNotEquals(paddle1, paddle2);
		assertNotEquals(paddle1, paddle3);
		assertNotEquals(paddle2, paddle3);
		assertNotEquals(null,paddle1);
		assertNotEquals(null,paddle2);
		assertNotEquals(null,paddle3);
	}
}
