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
		block1 = new NormalBlock(new Rect(new Point(5,5), new Point(15,15)));
		block2 = new NormalBlock(new Rect(new Point(5,5), new Point(15,15)));
		block3 = new NormalBlock(new Rect(new Point(5,5), new Point(15,15)));
	}
	
	@Test
	void testBallS() {
		assertEquals(new Rect(new Point(5,5), new Point(15,15)), block1.getLocation());
		assertEquals(new Rect(new Point(5,5), new Point(15,15)), block2.getLocation());
		assertEquals(new Rect(new Point(5,5), new Point(15,15)), block3.getLocation());
		
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
