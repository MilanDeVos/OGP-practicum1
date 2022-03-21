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
	 * @pre 
	 * @param center
	 * @param size
	 * @param velocity
	 */
	
	public BallState(Point center, Vector size, Vector velocity ) {
		this.center = center;
		this.size = size;
		this.velocity = velocity;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	public Vector getSize() {
		return size;
	}
}
