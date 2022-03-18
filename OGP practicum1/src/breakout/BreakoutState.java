package breakout;

// TODO: implement, document
public class BreakoutState {

	private  BallState[] balls;
	private final BlockState[] blocks;
	private final Point bottomRight;
	private PaddleState paddle; 
	private final Vector move = new Vector(10, 0); 
	
	
	public BreakoutState(BallState[] balls, BlockState[] blocks, Point bottomRight, PaddleState paddle) {
		this.balls = balls;
		this.blocks = blocks;
		this.bottomRight = bottomRight;
		this.paddle = paddle;
	}
	
	public BallState[] getBalls() {
		BallState[] currentBalls = balls.clone();
		return currentBalls;
	}

	public BlockState[] getBlocks() {

		return blocks;
		}

	public PaddleState getPaddle() {
		PaddleState currentPaddle = new PaddleState(paddle.getCenter(), paddle.getSize()); // So paddle doesn't get leaked.
		return currentPaddle;
	}
	public Point getBottomRight() {
		return bottomRight;
	}

	public void tick(int paddleDir) {
		for (int i = 0 ; i < balls.length ; i++) {
			Point nextCenter = balls[i].getCenter().plus(balls[i].getVelocity());
			balls[i] = new BallState(nextCenter, balls[i].getSize(), balls[i].getVelocity());

		}
	}

	public void movePaddleRight() {
		Point newCenter = paddle.getCenter().plus(move);
		PaddleState newPaddle = new PaddleState(newCenter, paddle.getSize());
		this.paddle = newPaddle;
	}

	public void movePaddleLeft() {
		Point newCenter = paddle.getCenter().minus(move);
		PaddleState newPaddle = new PaddleState(newCenter, paddle.getSize());
		this.paddle = newPaddle;
	}
	
	public boolean isWon() {
		return false;
	}

	public boolean isDead() {
		if (balls.length == 0) {
			return true;
		}
		return false;
	}
}
