package breakout;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlockTest {
	Point p11;
	Point p05;
	Point p38;
	Point pm14;
	
	Rect r1138;
	Rect rm1438;
	
	BlockState b1;
	BlockState sturdyb1;
	BlockState sturdyb2;
	BlockState sturdyb3;
	BlockState powerb;
	BlockState replib;

	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p05 = new Point(0,5);
		p38 = new Point(3,8);
		pm14 = new Point(-1,4);
		r1138 = new Rect(p11,p38);
		rm1438 = new Rect(pm14,p38);
		b1 = new NormalBlock(r1138);
		sturdyb1 = new SturdyBlock(r1138, 3);
		sturdyb2 = new SturdyBlock(r1138, 2);
		sturdyb3 = new SturdyBlock(r1138, 1);
		powerb = new PowerupBlock(r1138);
		replib = new ReplicatorBlock(r1138);
	}

	@Test
	void testBlock() {
		assertEquals(r1138,b1.getLocation());
		assertEquals(Color.BLUE, b1.getColor());
		assertTrue(b1.isNormal());
		assertFalse(b1.isPowerup());
		assertFalse(b1.isReplicator());
		assertFalse(b1.isSturdy());
		assertEquals(-1, b1.getHealth());
		
		assertEquals(r1138,sturdyb1.getLocation());
		assertEquals(Color.ORANGE, sturdyb1.getColor());
		assertFalse(sturdyb1.isNormal());
		assertFalse(sturdyb1.isPowerup());
		assertFalse(sturdyb1.isReplicator());
		assertTrue(sturdyb1.isSturdy());
		assertEquals(3, sturdyb1.getHealth());
		
		assertEquals(Color.YELLOW, sturdyb2.getColor());
		assertEquals(2, sturdyb2.getHealth());
		
		assertEquals(Color.GRAY, sturdyb3.getColor());
		assertEquals(1, sturdyb3.getHealth());
		
		assertEquals(r1138,powerb.getLocation());
		assertEquals(Color.MAGENTA, powerb.getColor());
		assertFalse(powerb.isNormal());
		assertTrue(powerb.isPowerup());
		assertFalse(powerb.isReplicator());
		assertFalse(powerb.isSturdy());
		assertEquals(-1, powerb.getHealth());
		
		assertEquals(r1138,replib.getLocation());
		assertEquals(Color.RED, replib.getColor());
		assertFalse(replib.isNormal());
		assertFalse(replib.isPowerup());
		assertTrue(replib.isReplicator());
		assertFalse(replib.isSturdy());
		assertEquals(-1, replib.getHealth());
	}

}
