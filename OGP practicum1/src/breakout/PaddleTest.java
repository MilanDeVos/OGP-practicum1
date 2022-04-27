package breakout;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaddleTest {
	Point p11;
	PaddleState p1;
	PaddleState replip;

	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p1 = new NormalPaddle(p11, 0);
		replip = new ReplicatorPaddle(p11, 1000);
	}

	@Test
	void testPaddle() { 
		assertEquals(p11, p1.getCenter());
		assertEquals(Color.RED, p1.getColor());
		assertEquals(0, p1.getHealth());
		assertTrue(p1.isNormal());
		assertFalse(p1.isReplicator());
		
		assertEquals(p11, replip.getCenter());
		assertEquals(Color.BLUE, replip.getColor());
		assertEquals(1000, replip.getHealth());
		assertFalse(replip.isNormal());
		assertTrue(replip.isReplicator());
	}

	@Test
	void testGetLocation() {
		assertEquals(new Point(1-NormalPaddle.WIDTH/2,1-NormalPaddle.HEIGHT/2), p1.getLocation().getTopLeft());
		assertEquals(new Point(1+NormalPaddle.WIDTH/2,1+NormalPaddle.HEIGHT/2), p1.getLocation().getBottomRight());
		
		assertEquals(new Point(1-ReplicatorPaddle.WIDTH/2,1-ReplicatorPaddle.HEIGHT/2), replip.getLocation().getTopLeft());
		assertEquals(new Point(1+ReplicatorPaddle.WIDTH/2,1+ReplicatorPaddle.HEIGHT/2), replip.getLocation().getBottomRight());
	}

}
