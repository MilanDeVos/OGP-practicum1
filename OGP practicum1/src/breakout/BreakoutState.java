package breakout;

// TODO: implement, document
public class BreakoutState {
	
	/**
	 * 
	 */
	
	/**
	 * @invar | balls != null
	 * 
	 * @representationObject
	 */
	private BallState[] balls;
	/**
	 * @invar | blocks != null
	 * 
	 * @representationObject
	 */
	private BlockState[] blocks;
	/**
	 * @invar | bottomRight != null
	 * 
	 * @representationObject
	 */
	private final Point bottomRight;
	/**
	 * @invar | paddle != null
	 * 
	 * @representationObject
	 */
	private PaddleState paddle; 
	/**
	 * @invar | move != null
	 * 
	 * @representationObject
	 */
	private final Vector move = new Vector(10, 0); 
	
	/**
	 * Initializes this instance so that it represents the given breakout state
	 * 
	 * @throws IllegalArgumentException if argument {@code balls} is {@code null}
	 * 	| balls == null
	 * @throws IllegalArgumentException if argument {@code blocks} is {@code null}
	 * 	| blocks == null
	 * @throws IllegalArgumentException if argument {@code bottomRight} is {@code null}
	 * 	| bottomRight == null
	 * @throws IllegalArgumentException if argument {@code paddle} is {@code null}
	 * 	| paddle == null
	 * 
	 * @post this object's balls equal to given balls
	 * 	| getBalls() == balls
	 * @post this object's blocks equal to given blocks
	 * 	| getBlocks() == blocks
	 * @post this object's bottomRight equal to given bottomRight
	 * 	| getBottomRight() == bottomRight
	 * @post this object's paddle equal to given paddle
	 * 	| getPaddle() == paddle
	 */
	public BreakoutState(BallState[] balls, BlockState[] blocks, Point bottomRight, PaddleState paddle) {
		if (balls == null) {
			throw new IllegalArgumentException("balls_is_null;");
		}
		if (blocks == null) {
			throw new IllegalArgumentException("blocks_is_null");
		}
		if (bottomRight == null) {
			throw new IllegalArgumentException("bottomRight_is_null");
		}
		if (bottomRight.getX() <= 0 || bottomRight.getY() <= 0) {
			throw new IllegalArgumentException("bottomRight_is_null_or_negative");
		}
		if (paddle == null) {
			throw new IllegalArgumentException("paddle_is_null");
		}
		this.balls = balls;
		this.blocks = blocks;
		this.bottomRight = bottomRight;
		this.paddle = paddle;
	}
	
	/**
	 * Returns variable balls
	 * @creates | result
	 * @pre Argument {@code balls} is not {@code null}
	 * 	| getBalls() != null
	 * @post result is equal to {@code balls}
	 * 	| result == getBalls()
	 */
	public BallState[] getBalls() {
		BallState[] currentBalls = balls.clone();
		return currentBalls;
	}
	/**
	 * Returns variable blocks
	 * @creates | result
	 * @pre Argument {@code blocks} is not {@code null}
	 * 	| getBlocks() != null
	 * @post result is equal to {@code blocks}
	 * 	| result == getBlocks()
	 */
	public BlockState[] getBlocks() {
		BlockState[] currentBlocks = blocks.clone();
		return currentBlocks;
		}
	/**
	 * Returns this instance's paddle.
	 */
	public PaddleState getPaddle() {
		return paddle;
	}
	/**
	 * Returns this instance's bottomRight.
	 */
	public Point getBottomRight() {
		return bottomRight;
	}

	public void tick(int paddleDir) {
		if (balls.length > 0) {
			for (int i = 0 ; i < balls.length ; i++) {
				// ball moves
				Point nextCenter = balls[i].getCenter().plus(balls[i].getVelocity());
				balls[i] = new BallState(nextCenter, balls[i].getSize(), balls[i].getVelocity());
				//System.out.println(balls[i].getVelocity());
				// ball bounces on walls
				if (balls[i].getCenter().getX() + balls[i].getSize().getX()/2 >= getBottomRight().getX()) { // right wall
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(1,0));
					balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
				}
				if (balls[i].getCenter().getX() - balls[i].getSize().getX()/2 <= Point.ORIGIN.getX()) { // left wall
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(-1,0));
					balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
				}
				if (balls[i].getCenter().getY() - balls[i].getSize().getY()/2 <= Point.ORIGIN.getY()) { // top wall
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(0,-1));
					balls[i] = new BallState(balls[i].getCenter(), balls[i].getSize(), newVelocity);
				}
				// ball gets removed
				if (balls[i].getCenter().getY() >= getBottomRight().getY()) {
					BallState[] newBalls = new BallState[balls.length-1];
					for (int j = 0 ; j < balls.length ; j++) {
						if (balls[i] != balls[j]) {
							if (j<i) {
								newBalls[j] = balls[j];
							}
							if (j>i) {
								newBalls[j-1] = balls[j];
							}
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
							&& balls[i].getCenter().getY() - balls[i].getSize().getY()/2 >= blocks[j].getCenter().getY() + blocks[j].getSize().getY()*(19/20)
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
					if (balls[i].getCenter().getY() + balls[i].getSize().getY()/2 >= blocks[j].getCenter().getY() - blocks[j].getSize().getY()/2
							&& balls[i].getCenter().getY() + balls[i].getSize().getY()/2 <= blocks[j].getCenter().getY() + blocks[j].getSize().getY()*(19/20)
							&& balls[i].getCenter().getX() >= blocks[j].getCenter().getX() - blocks[j].getSize().getX()/2
							&& balls[i].getCenter().getX() <= blocks[j].getCenter().getX() + blocks[j].getSize().getX()/2 ) { //topside
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
							 && balls[i].getCenter().getX() - balls[i].getSize().getX()/2 >= blocks[j].getCenter().getX() + blocks[j].getSize().getX()*(19/20)
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
					else if (balls[i].getCenter().getX() + balls[i].getSize().getX()/2 >= blocks[j].getCenter().getX() - blocks[j].getSize().getX()/2
							 && balls[i].getCenter().getX() + balls[i].getSize().getX()/2 <= blocks[j].getCenter().getX() + blocks[j].getSize().getX()*(19/20)
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
						&& balls[i].getCenter().getX() <= paddle.getCenter().getX() + paddle.getSize().getX()/2
						) {
					Vector newVelocity = balls[i].getVelocity().mirrorOver(new Vector(0,1));
					newVelocity = newVelocity.plus(newVelocity.scaledDiv(5).scaled(paddleDir));
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
