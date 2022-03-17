package breakout;

// TODO: implement, document
public class BreakoutState {

	
	public BreakoutState(BallState[] balls, BlockState[] blocks, Point bottomRight, PaddleState paddle) {
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
		return null;
	}

	public Point getBottomRight() {
		return null;
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
