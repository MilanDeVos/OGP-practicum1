package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BreakoutStateTest {
	BreakoutState bos1;
	BreakoutState bos2;
	BallState[] balls1 = {new BallState(new Point(0,0),new Vector(10,5), new Vector(5,-7))};
	BallState[] balls2 = {new BallState(new Point(10,5),new Vector(5,10), new Vector(5,7))};
	BlockState[] blocks1 = {new BlockState(new Point(0,0),new Vector(10,5))};
	BlockState[] blocks2 = {new BlockState(new Point(10,5),new Vector(5,10))};
	
	@BeforeEach
	void setUp() throws Exception {
		bos1 = new BreakoutState(balls1, blocks1, new Point(1,1), new PaddleState(new Point(0,0),new Vector(10,5)));
		bos2 = new BreakoutState(balls2, blocks2, new Point(1,1), new PaddleState(new Point(0,0),new Vector(10,5)));
	}
	
	@Test
	void testBreakoutState() {
		assertEquals(bos1, bos1);
		assertEquals(bos2, bos2);
		assertNotEquals(bos1, bos2);
		assertNotEquals(bos1, null);
		assertNotEquals(null, bos2);
	}

}
