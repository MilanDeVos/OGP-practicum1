package breakout;

/**
 * An object of this class stores a ball which has a center, a size and a velocity.
 * 
 * @invar This center point's coordinates are nonnegative.
 * 		| getCenter().getX() >= 0 |  getCenter().getY() >= 0
 * @invar This size vector's coordinates are nonnegative.
 * 		| getSize().getX() >= 0 |  getSize().getY() >= 0
 * 
 */

public class BallState {
	// TODO: implement
	
	/**
	 * @invar This center point's coordinates are nonnegative.
	 * 		| center.getX() >= 0 |  center.getY() >= 0
	 * @invar this size vector's coordinates are nonnegative.
	 * 		| size.getX() >= 0 |  size.getY() >= 0
	 */
	
	private final Point center;
	private final Vector size;
	private final Vector velocity;
	
	/**
	 * Initializes this ball with a given center and size.
	 * 
	 * @post this ball's center equals the given center.
	 * 		| getCenter() == center
	 * @post this ball's size equals the given size.
	 * 		| getSize() == size
	 * @post this ball's velocity equals the given velocity.
	 * 		| getVelocity() == velocity
	 * 
	 * @param center
	 * @param size
	 * @param velocity
	 */
	
	public BallState(Point center, Vector size, Vector velocity ) {
		this.center = center;
		this.size = size;
		this.velocity = velocity;
	}
	/**
	 * This getter returns the center point of the ball.
	 * @return
	 */
	public Point getCenter() {
		return center;
	}
	/**
	 * This getter returns a vector which contains the velocity of the ball.
	 * @return
	 */
	public Vector getVelocity() {
		return velocity;
	}
	/**
	 * This getter returns a vector which contains size of the ball, x-value is the width, y-value is the height.
	 * @return
	 */
	public Vector getSize() {
		return size;
	}
}
