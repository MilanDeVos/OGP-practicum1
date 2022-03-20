package breakout;

// TODO: implement, document
public class BreakoutState {

	private BallState[] balls;
	private BlockState[] blocks;
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
		BlockState[] currentBlocks = blocks.clone();
		return currentBlocks;
		}

	public PaddleState getPaddle() {
		PaddleState currentPaddle = new PaddleState(paddle.getCenter(), paddle.getSize()); // So paddle doesn't get leaked.
		return currentPaddle;
	}
	public Point getBottomRight() {
		return bottomRight;
	}

	public void tick(int paddleDir) {
		if (balls.length > 0) {
			for (int i = 0 ; i < balls.length ; i++) {
				// ball moves
				Point nextCenter = balls[i].getCenter().plus(balls[i].getVelocity());
				balls[i] = new BallState(nextCenter, balls[i].getSize(), balls[i].getVelocity());
				// ball bounces on walls
				if (balls[i].getCenter().getX() + balls[i].getSize().getX()/2 == 50000) { // right wall
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(1,0));
					balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
				}
				if (balls[i].getCenter().getX() - balls[i].getSize().getX()/2 == 0) { // left wall
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(-1,0));
					balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
				}
				if (balls[i].getCenter().getY() - balls[i].getSize().getY()/2 == 0) { // top wall
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(0,-1));
					balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
				}
				// ball gets removed
				if (balls[i].getCenter().getY() >= 30000) {
					BallState[] newBalls = new BallState[balls.length-1];
					for (int j = 0 ; j < balls.length ; j++) {
						if (balls[i] != balls[j]) {
							newBalls[j] = balls[j];
						}
					}
					balls = newBalls;
				}
				if (balls.length == 0) {
					break;
				}
				// ball bounces on block, block gets removed
				for (int j = 0 ; j < blocks.length ; j++) {
					if (balls[i].getCenter().getY() - balls[i].getSize().getY()/2 <= blocks[j].getCenter().getY() + blocks[j].getSize().getY()/2
							&& balls[i].getCenter().getY() >= blocks[j].getCenter().getY() + blocks[j].getSize().getY()/256
							&& balls[i].getCenter().getX() >= blocks[j].getCenter().getX() - blocks[j].getSize().getX()/2
							&& balls[i].getCenter().getX() <= blocks[j].getCenter().getX() + blocks[j].getSize().getX()/2) { //botside
						BlockState[] newBlocks = new BlockState[blocks.length-1];
						for (int k = 0 ; k < blocks.length ; k++) {
							if (blocks[j] != blocks[k]) {
								if (k<j) {
									newBlocks[k] = blocks[k];
								}
							if (k>j) {
								newBlocks[k-1] = blocks[k];
								}
							}
						}
						blocks = newBlocks;
						Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(0,1));
						balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
						break;
					}
					else if (balls[i].getCenter().getX() - balls[i].getSize().getX()/2 <= blocks[j].getCenter().getX() + blocks[j].getSize().getX()/2
							 && balls[i].getCenter().getX() <= blocks[j].getCenter().getX() + blocks[j].getSize().getX()/16
							 && balls[i].getCenter().getY() >= blocks[j].getCenter().getY() - blocks[j].getSize().getY()/2
							 && balls[i].getCenter().getY() <= blocks[j].getCenter().getY() + blocks[j].getSize().getY()/2) { //right side
						BlockState[] newBlocks = new BlockState[blocks.length-1];
						for (int k = 0 ; k < blocks.length ; k++) {
							if (blocks[j] != blocks[k]) {
								if (k<j) {
									newBlocks[k] = blocks[k];
								}
							if (k>j) {
								newBlocks[k-1] = blocks[k];
								}
							}
						}
						blocks = newBlocks;
						Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(1,0));
						balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
						break;
					}
					else if (balls[i].getCenter().getX() + balls[i].getSize().getX()/2 <= blocks[j].getCenter().getX() + blocks[j].getSize().getX()/2
							 && balls[i].getCenter().getX() <= blocks[j].getCenter().getX() + blocks[j].getSize().getX()/16
							 && balls[i].getCenter().getY() >= blocks[j].getCenter().getY() - blocks[j].getSize().getY()/2
							 && balls[i].getCenter().getY() <= blocks[j].getCenter().getY() + blocks[j].getSize().getY()/2 ) { //left side
						BlockState[] newBlocks = new BlockState[blocks.length-1];
						for (int k = 0 ; k < blocks.length ; k++) {
							if (blocks[j] != blocks[k]) {
								if (k<j) {
									newBlocks[k] = blocks[k];
								}
							if (k>j) {
								newBlocks[k-1] = blocks[k];
								}
							}
						}
						blocks = newBlocks;
						Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(1,0));
						balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
						break;
					}
				}
				
				// ball bounces on paddle and speedup
				if (balls[i].getCenter().getY() + balls[i].getSize().getY()/2 >= paddle.getCenter().getY() - paddle.getSize().getY()/2 
						&& balls[i].getCenter().getY() <= paddle.getCenter().getY()
						&& balls[i].getCenter().getX() >= paddle.getCenter().getX() - paddle.getSize().getX()/2
						&& balls[i].getCenter().getX() <= paddle.getCenter().getX() + paddle.getSize().getX()/2) {
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(0,1));
					//newVelocity = newVelocity.scaled(paddleDir/5);
					balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
				}
			}
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
		if (blocks.length==0) {
			return true;
		}
		return false;
	}

	public boolean isDead() {
		if (balls.length == 0) {
			return true;
		}
		return false;
	}
}
