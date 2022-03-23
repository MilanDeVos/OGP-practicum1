package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlockStateTest {

	BlockState block1;
	BlockState block2;
	BlockState block3;
	
	@BeforeEach
	void setUp() throws Exception {
		block1 = new BlockState(new Point(0,0),new Vector(10,5));
		block2 = new BlockState(new Point(1,2),new Vector(10,10));
		block3 = new BlockState(new Point(20,5),new Vector(5,10));
	}
	
	@Test
	void testBallState() {
		assertEquals(new Point(0,0), block1.getCenter());
		assertEquals(new Point(1,2), block2.getCenter());
		assertEquals(new Point(20,5), block3.getCenter());
		assertEquals(new Vector(10,5), block1.getSize());
		assertEquals(new Vector(10,10), block2.getSize());
		assertEquals(new Vector(5,10), block3.getSize());
	}
	@Test
	void testEqualsObject() {
		assertEquals(block1, block1);
		assertEquals(block2, block2);
		assertEquals(block3, block3);
		assertNotEquals(block1, block2);
		assertNotEquals(block1, block3);
		assertNotEquals(block2, block3);
		assertNotEquals(null,block1);
		assertNotEquals(null,block2);
		assertNotEquals(null,block3);
	}
}
