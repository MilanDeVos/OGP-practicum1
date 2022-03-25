package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BreakoutStateTest {
	BreakoutState bos1;
	BreakoutState bos2;
	BreakoutState bounceTopWall;
	BreakoutState bounceLeftWall;
	BreakoutState bounceRightWall;
	BreakoutState bounceBlockUnder;
	BreakoutState bounceBlockTop;
	BreakoutState bounceBlockLeft;
	BreakoutState bounceBlockRight;
	BreakoutState bouncePaddle;
	BreakoutState isDead;
	BreakoutState isWon;
	BallState[] balls1 = {new BallState(new Point(0,0),new Vector(10,5), new Vector(5,-7))};
	BallState[] balls2 = {new BallState(new Point(10,5),new Vector(5,10), new Vector(5,7))};
	BallState[] ballsTop = {new BallState(new Point(200000,20), new Vector(10,10), new Vector(-1,-1))};
	BallState[] ballsLeft = {new BallState(new Point(20,10000), new Vector(10,10), new Vector(-1,1))};
	BallState[] ballsRight = {new BallState(new Point(29980,10000), new Vector(10,10), new Vector(1,1))};
	BallState[] ballsBounceBlockUnder = {new BallState(new Point(100,120),new Vector(10,10), new Vector(0,-1))};
	BallState[] ballsBounceBlockTop = {new BallState(new Point(100,80),new Vector(10,10), new Vector(0,1))};
	BallState[] ballsBounceBlockLeft = {new BallState(new Point(80,100),new Vector(10,10), new Vector(1,0))};
	BallState[] ballsBounceBlockRight = {new BallState(new Point(120,100),new Vector(10,10), new Vector(-1,0))};
	BallState[] ballsBouncePaddle = {new BallState(new Point(24950,29980),new Vector(10,10), new Vector(5,7))};
	BallState[] ballsIsDead = {new BallState(new Point(24950,29980),new Vector(10,10), new Vector(5,7))};
	BallState[] ballsIsWon =  {new BallState(new Point(100,120),new Vector(10,10), new Vector(0,-1))};
	BlockState[] bounceBlocks = {new BlockState(new Point(10,5),new Vector(5,10)), new BlockState(new Point(100,100),new Vector(10,5)), new BlockState(new Point(0,0),new Vector(10,5))};
	BlockState[] blocks1 = {new BlockState(new Point(0,0),new Vector(10,5))};
	BlockState[] blocks2 = {new BlockState(new Point(10,5),new Vector(5,10))};
	BlockState[] bounceOneBlock = {new BlockState(new Point(100,100),new Vector(10,5))};
		
	@BeforeEach
	void setUp() throws Exception {
		bos1 = new BreakoutState(balls1, blocks1, new Point(1,1), new PaddleState(new Point(0,0),new Vector(10,5)));
		bos2 = new BreakoutState(balls2, blocks2, new Point(10,10), new PaddleState(new Point(30,10),new Vector(5,10)));
		bounceTopWall = new BreakoutState(ballsTop, blocks2, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));
		bounceLeftWall = new BreakoutState(ballsLeft, blocks2, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));
		bounceRightWall = new BreakoutState(ballsRight, blocks2, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));
		bounceBlockUnder = new BreakoutState(ballsBounceBlockUnder, bounceBlocks, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));
		bounceBlockTop = new BreakoutState(ballsBounceBlockTop, bounceBlocks, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));
		bounceBlockLeft = new BreakoutState(ballsBounceBlockLeft, bounceBlocks, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));
		bounceBlockRight = new BreakoutState(ballsBounceBlockRight, bounceBlocks, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));
		bouncePaddle = new BreakoutState(ballsBouncePaddle, blocks1, new Point(50000, 30000), new PaddleState(new Point(25000, 30000), new Vector(1000,5)));
		isDead = new BreakoutState(ballsIsDead, blocks1, new Point(50000, 30000), new PaddleState(new Point(10,10), new Vector(5,5)));
		isWon = new BreakoutState(ballsIsWon, bounceOneBlock, new Point(30000,50000), new PaddleState(new Point(30,10),new Vector(5,10)));

	}
	
	@Test
	void testBreakoutState() {
		assertEquals(bos1.getBalls()[0].getCenter().getX(), 0);
		assertEquals(bos1.getBalls()[0].getCenter().getY(), 0);
		assertEquals(bos1.getBalls()[0].getSize().getX(), 10);
		assertEquals(bos1.getBalls()[0].getSize().getY(), 5);
		assertEquals(bos1.getBalls()[0].getVelocity().getX(), 5);
		assertEquals(bos1.getBalls()[0].getVelocity().getY(), -7);
		
		assertEquals(bos2.getBalls()[0].getCenter().getX(), 10);
		assertEquals(bos2.getBalls()[0].getCenter().getY(), 5);
		assertEquals(bos2.getBalls()[0].getSize().getX(), 5);
		assertEquals(bos2.getBalls()[0].getSize().getY(), 10);
		assertEquals(bos2.getBalls()[0].getVelocity().getX(), 5);
		assertEquals(bos2.getBalls()[0].getVelocity().getY(), 7);
		
		assertEquals(bos1.getBlocks()[0].getCenter().getX(), 0);
		assertEquals(bos1.getBlocks()[0].getCenter().getY(), 0);
		assertEquals(bos1.getBlocks()[0].getSize().getX(), 10);
		assertEquals(bos1.getBlocks()[0].getSize().getY(), 5);
		
		assertEquals(bos2.getBlocks()[0].getCenter().getX(), 10);
		assertEquals(bos2.getBlocks()[0].getCenter().getY(), 5);
		assertEquals(bos2.getBlocks()[0].getSize().getX(), 5);
		assertEquals(bos2.getBlocks()[0].getSize().getY(), 10);
		
		assertEquals(bos1.getBottomRight().getX(), 1);
		assertEquals(bos1.getBottomRight().getY(), 1);
		
		assertEquals(bos2.getBottomRight().getX(), 10);
		assertEquals(bos2.getBottomRight().getY(), 10);
		
		assertEquals(bos1.getPaddle().getCenter().getX(), 0);
		assertEquals(bos1.getPaddle().getCenter().getY(), 0);
		assertEquals(bos1.getPaddle().getSize().getX(), 10);
		assertEquals(bos1.getPaddle().getSize().getY(), 5);
		
		assertEquals(bos2.getPaddle().getCenter().getX(), 30);
		assertEquals(bos2.getPaddle().getCenter().getY(), 10);
		assertEquals(bos2.getPaddle().getSize().getX(), 5);
		assertEquals(bos2.getPaddle().getSize().getY(), 10);
	}
	
	@Test
	void testEqualsObject() {
		assertEquals(bos1, bos1);
		assertEquals(bos2, bos2);
		assertNotEquals(bos1, bos2);
		assertNotEquals(bos1, null);
		assertNotEquals(null, bos2);
	}
	
	@Test
	void testTickBounceWalls() {
		for(int i = 0; i < 22; ++i) {
			bounceTopWall.tick(1);
			bounceLeftWall.tick(1);
			bounceRightWall.tick(1);
		}
		assertEquals(bounceTopWall.getBalls()[0].getVelocity().getX(), -1);
		assertEquals(bounceTopWall.getBalls()[0].getVelocity().getY(), 1);
		assertEquals(bounceLeftWall.getBalls()[0].getVelocity().getX(), 1);
		assertEquals(bounceLeftWall.getBalls()[0].getVelocity().getY(), 1);
		assertEquals(bounceRightWall.getBalls()[0].getVelocity().getX(), -1);
		assertEquals(bounceRightWall.getBalls()[0].getVelocity().getY(), 1);
	}
	
	@Test
	void testTickBounceBlock() {
		for(int i = 0; i < 22; ++i) {
			bounceBlockUnder.tick(1);
			bounceBlockTop.tick(1);
			bounceBlockLeft.tick(1);
			bounceBlockRight.tick(1);
		}
		assertEquals(bounceBlockUnder.getBlocks().length, 2);
		assertEquals(bounceBlockUnder.getBalls()[0].getVelocity().getX(), 0);
		assertEquals(bounceBlockUnder.getBalls()[0].getVelocity().getY(), 1);
		assertEquals(bounceBlockTop.getBalls()[0].getVelocity().getX(), 0);
		assertEquals(bounceBlockTop.getBalls()[0].getVelocity().getY(), -1);
		assertEquals(bounceBlockLeft.getBalls()[0].getVelocity().getX(), -1);
		assertEquals(bounceBlockLeft.getBalls()[0].getVelocity().getY(), 0);
		assertEquals(bounceBlockRight.getBalls()[0].getVelocity().getX(), 1);
		assertEquals(bounceBlockRight.getBalls()[0].getVelocity().getY(), 0);
	}
	
	@Test
	void testTickBouncePaddle() {
		for(int i = 0; i < 22; ++i) {
			bouncePaddle.tick(1);
		}
		assertEquals(bouncePaddle.getBalls()[0].getVelocity().getX(), 6);
		assertEquals(bouncePaddle.getBalls()[0].getVelocity().getY(), -8);
	}
	
	@Test
	void testIsDead() {
		for(int i = 0; i < 22; ++i) {
			isDead.tick(1);
		}
		assertTrue(isDead.isDead());
		assertFalse(isDead.isWon());
	}
	
	@Test
	void testIsWon() {
		for(int i = 0; i < 22; ++i) {
			isWon.tick(1);
		}
		assertTrue(isWon.isWon());
		assertFalse(isWon.isDead());
	}
}
