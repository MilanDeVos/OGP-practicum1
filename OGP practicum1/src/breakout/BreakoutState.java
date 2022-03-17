package breakout;

// TODO: implement, document
public class BreakoutState {

	private final BallState[] balls;
	private final BlockState[] blocks;
	private final Point bottomRight;
	private final PaddleState paddle;
	
	
	public BreakoutState(BallState[] balls, BlockState[] blocks, Point bottomRight, PaddleState paddle) {
		this.balls = balls;
		this.blocks = blocks;
		this.bottomRight = bottomRight;
		this.paddle = paddle;
	}
	
	public BallState[] getBalls() {
		BallState ball = new BallState(new Point(0,0), new Vector(700, 700), new Vector(5,7));
		BallState[] balls = {ball};
		return balls;
	}

	public BlockState[] getBlocks() {
		return null;
	}

	public PaddleState getPaddle() {
		PaddleState paddle = new PaddleState(paddle.getCenter(),this.getSize());
		return paddle;
	}

	public Point getBottomRight() {
		return ;
	}

	public void tick(int paddleDir) {
	}

	public void movePaddleRight() {
	}

	public void movePaddleLeft() {
	}
	
	public boolean isWon() {
		return false;
	}

	public boolean isDead() {
		return false;
	}
}
