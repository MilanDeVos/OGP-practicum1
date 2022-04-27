package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BreakoutTest {
	Ball[] oneBall;
	Point bottomRight;
	PaddleState paddle;
	BreakoutState state1;
	Vector origBallVelocity;
	Ball ball;
	
	public static final String normalBlockBounce = """
      ###              
	   o	   
		       
		       
		       
		       
		     =

		""";
	
	@BeforeEach
	void setUp() throws Exception {
		state1 = GameMap.createStateFromDescription(normalBlockBounce);
		oneBall = state1.getBalls();
		ball = oneBall[0];
		origBallVelocity = new Vector(0,-10);
		bottomRight = state1.getBottomRight();
		paddle = state1.getPaddle();
		
	}
	
	@Test
	void testCollideBallBlocks() {
		assertEquals(state1.getBlocks().length, 3);
		state1.getBalls()[0].setVelocity(origBallVelocity);
		for(int i = 0; i < 1000; ++i) {
			state1.tick(1,1);
		}
		assertEquals(state1.getBalls()[0].getVelocity(), new Vector(0,10));
		assertEquals(state1.getBlocks().length, 2);
	}
}