package breakout;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTest {
	Point p11;
	Point p05;
	Point p38;
	Point pm14;
	
	Rect r1138;
	Rect rm1438;
	
	Vector v1010;
	
	Circle c052;
	Circle c389;
	Ball b1;
	Ball superb;
	
	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p05 = new Point(0,5);
		p38 = new Point(3,8);
		pm14 = new Point(-1,4);
		r1138 = new Rect(p11,p38);
		rm1438 = new Rect(pm14,p38);
		c052 = new Circle(p05,2);
		c389 = new Circle(p38,9);
		v1010 = new Vector(10,10);
		b1 = new NormalBall(c052, v1010,0);
		superb = new SuperchargedBall(c052, v1010,1);
	}

	@Test
	void testBall() {
		assertEquals(p05, b1.getLocation().getCenter());
		assertEquals(2, b1.getLocation().getDiameter());
		assertEquals(v1010, b1.getVelocity());
		b1.setCenter(p05);
		assertEquals(p05, b1.getCenter());
		b1.setLifetime(0);
		assertEquals(0, b1.getLifetime());
		b1.setLocation(c052);
		assertEquals(c052, b1.getLocation());
		b1.setVelocity(v1010);
		assertEquals(v1010, b1.getVelocity());
		assertEquals(Color.GREEN, b1.getColor());
		assertTrue(b1.isNormal());
		assertFalse(b1.isSupercharged());
		
		assertEquals(p05, superb.getLocation().getCenter());
		assertEquals(2, superb.getLocation().getDiameter());
		assertEquals(v1010, superb.getVelocity());
		superb.setCenter(p05);
		assertEquals(p05, superb.getCenter());
		superb.setLifetime(0);
		assertEquals(0, superb.getLifetime());
		superb.setLocation(c052);
		assertEquals(c052, superb.getLocation());
		superb.setVelocity(v1010);
		assertEquals(v1010, superb.getVelocity());
		assertEquals(Color.MAGENTA, superb.getColor());
		assertFalse(superb.isNormal());
		assertTrue(superb.isSupercharged());
	}

	@Test
	void testBounceOn() {
		assertEquals(new Vector(-10,10),b1.bounceOn(r1138));
		assertEquals(new Vector(-10,10),superb.bounceOn(r1138));
	}
}
