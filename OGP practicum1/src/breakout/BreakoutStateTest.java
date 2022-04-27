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
	BreakoutState balls;
	Ball[] threeBalls = {new NormalBall(new Circle(new Point(800,800),2), new Vector(5,-7), 0), new NormalBall(new Circle(new Point(800,800),2), new Vector(0,1), 0), new NormalBall(new Circle(new Point(800,800),2), new Vector(5,-7), 0)};
	Ball[] balls1 = {new NormalBall(new Circle(new Point(800,800),2), new Vector(5,-7), 0)};
	Ball[] balls2 = {new NormalBall(new Circle(new Point(800,800),2), new Vector(5,7), 0)};
	Ball[] ballsTop = {new NormalBall(new Circle(new Point(800,800),2), new Vector(-1,-1), 0)};
	Ball[] ballsLeft = {new NormalBall(new Circle(new Point(800,800),2), new Vector(-1,1), 0)};
	Ball[] ballsRight = {new NormalBall(new Circle(new Point(800,800),2), new Vector(1,1), 0)};
	Ball[] ballsBounceBlockUnder = {new NormalBall(new Circle(new Point(800,800),2), new Vector(0,-1), 0)};
	Ball[] ballsBounceBlockTop = {new NormalBall(new Circle(new Point(800,800),2), new Vector(0,1), 0)};
	Ball[] ballsBounceBlockLeft = {new NormalBall(new Circle(new Point(800,800),2), new Vector(1,0), 0)};
	Ball[] ballsBounceBlockRight = {new NormalBall(new Circle(new Point(800,800),2), new Vector(-1,0), 0)};
	Ball[] ballsBouncePaddle = {new NormalBall(new Circle(new Point(800,800),2), new Vector(5,7), 0)};
	Ball[] ballsIsDead = {new NormalBall(new Circle(new Point(800,800),2), new Vector(5,7), 0)};
	Ball[] ballsIsWon =  {new NormalBall(new Circle(new Point(800,800),2), new Vector(0,-1), 0)};
	BlockState[] bounceBlocks = {new NormalBlock(new Rect(new Point(1,1),new Point(3,8))), new NormalBlock(new Rect(new Point(1,1),new Point(3,8))), new NormalBlock(new Rect(new Point(1,1),new Point(3,8)))};
	BlockState[] blocks1 = {new NormalBlock(new Rect(new Point(1,1),new Point(3,8)))};
	BlockState[] blocks2 = {new NormalBlock(new Rect(new Point(1,1),new Point(3,8)))};
	BlockState[] bounceOneBlock = {new NormalBlock(new Rect(new Point(1,1),new Point(3,8)))};
		
	@BeforeEach
	void setUp() throws Exception {
		bos1 = new BreakoutState(balls1, blocks1, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000),0));
		bos2 = new BreakoutState(balls2, blocks2, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000),0));
		bounceTopWall = new BreakoutState(ballsTop, blocks2, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000),0));
		bounceLeftWall = new BreakoutState(ballsLeft, blocks2, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000),0));
		bounceRightWall = new BreakoutState(ballsRight, blocks2, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000),0));
		bounceBlockUnder = new BreakoutState(ballsBounceBlockUnder, bounceBlocks, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000), 0));
		bounceBlockTop = new BreakoutState(ballsBounceBlockTop, bounceBlocks, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000), 0));
		bounceBlockLeft = new BreakoutState(ballsBounceBlockLeft, bounceBlocks, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000), 0));
		bounceBlockRight = new BreakoutState(ballsBounceBlockRight, bounceBlocks, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000), 0));
		bouncePaddle = new BreakoutState(ballsBouncePaddle, blocks1, new Point(1000000,1000000), new NormalPaddle(new Point(25000, 30000), 0));
		isDead = new BreakoutState(ballsIsDead, blocks1, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000), 0));
		isWon = new BreakoutState(ballsIsWon, bounceOneBlock, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000), 0));
		balls = new BreakoutState(threeBalls, blocks1, new Point(1000000,1000000), new NormalPaddle(new Point(10000,10000), 0));
	}
	
	@Test
	void testBreakoutState() {
		assertEquals(bos1.getBalls()[0].getCenter().getX(), 800);
		assertEquals(bos1.getBalls()[0].getCenter().getY(), 800);
	
		assertEquals(bos1.getBalls()[0].getVelocity().getX(), 5);
		assertEquals(bos1.getBalls()[0].getVelocity().getY(), -7);
		
		assertEquals(bos2.getBalls()[0].getCenter().getX(), 800);
		assertEquals(bos2.getBalls()[0].getCenter().getY(), 800);
		
		assertEquals(bos2.getBalls()[0].getVelocity().getX(), 5);
		assertEquals(bos2.getBalls()[0].getVelocity().getY(), 7);
		
		//assertEquals(bos1.getBlocks()[0].getCenter().getX(), 0);
		//assertEquals(bos1.getBlocks()[0].getCenter().getY(), 0);
		//assertEquals(bos1.getBlocks()[0].getSize().getX(), 10);
		//assertEquals(bos1.getBlocks()[0].getSize().getY(), 5);
		
		//assertEquals(bos2.getBlocks()[0].getCenter().getX(), 10);
		//assertEquals(bos2.getBlocks()[0].getCenter().getY(), 5);
		//assertEquals(bos2.getBlocks()[0].getSize().getX(), 5);
		//assertEquals(bos2.getBlocks()[0].getSize().getY(), 10);
		
		assertEquals(bos1.getBottomRight().getX(), 1000000);
		assertEquals(bos1.getBottomRight().getY(), 1000000);
		
		assertEquals(bos2.getBottomRight().getX(), 1000000);
		assertEquals(bos2.getBottomRight().getY(), 1000000);
		
		assertEquals(bos1.getPaddle().getCenter().getX(), 10000);
		assertEquals(bos1.getPaddle().getCenter().getY(), 10000);
		//assertEquals(bos1.getPaddle().getSize().getX(), 10);
		//assertEquals(bos1.getPaddle().getSize().getY(), 5);
		
		assertEquals(bos2.getPaddle().getCenter().getX(), 10000);
		assertEquals(bos2.getPaddle().getCenter().getY(), 10000);
		//assertEquals(bos2.getPaddle().getSize().getX(), 5);
		//assertEquals(bos2.getPaddle().getSize().getY(), 10);
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
			bounceTopWall.tick(1, 100);
			bounceLeftWall.tick(1, 100);
			bounceRightWall.tick(1, 100);
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
			bounceBlockUnder.tick(1, 100);
			bounceBlockTop.tick(1, 100);
			bounceBlockLeft.tick(1, 100);
			bounceBlockRight.tick(1, 100);
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
			bouncePaddle.tick(1, 100);
		}
		assertEquals(bouncePaddle.getBalls()[0].getVelocity().getX(), 6);
		assertEquals(bouncePaddle.getBalls()[0].getVelocity().getY(), -8);
	}
	
	@Test
	void testIsDead() {
		for(int i = 0; i < 22; ++i) {
			isDead.tick(1, 100);
		}
		assertTrue(isDead.isDead());
		assertFalse(isDead.isWon());
	}
	
	@Test
	void testIsWon() {
		for(int i = 0; i < 22; ++i) {
			isWon.tick(1, 100);
		}
		assertTrue(isWon.isWon());
		assertFalse(isWon.isDead());
	}
	
	@Test
	void testBalls() {
		assertEquals(balls.getBalls().length, 3);
		for(int i = 0; i < 22; ++i) {
			balls.tick(1, 100);
		}
		assertEquals(balls.getBalls().length, 2);
	}
	
	@Test
	void testPaddle() {
		assertEquals(bos1.getPaddle().getCenter().getX(), 0);
		bos1.movePaddleRight(100);
		assertEquals(bos1.getPaddle().getCenter().getX(), 10);
		bos1.movePaddleLeft(100);
		assertEquals(bos1.getPaddle().getCenter().getX(), 0);
	}
}
