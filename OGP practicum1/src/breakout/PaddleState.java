package breakout;

	/**
	 * An object of this class stores a paddle which has a center point and a size vector.
	 * @invar This center point's coordinates are nonnegative.
	 * 		| getCenter().getX() >= 0 |  getCenter().getY() >= 0
	 * @invar this size vector's coordinates are nonnegative.
	 * 		| getSize().getX() >= 0 |  getSize().getY() >= 0
	 */

public class PaddleState {
	// TODO: implement
	
	/**
	 * @invar This center point's coordinates are nonnegative.
	 * 		| center.getX() >= 0 |  center.getY() >= 0
	 * @invar this size vector's coordinates are nonnegative.
	 * 		| size.getX() >= 0 |  size.getY() >= 0
	 */
	
	private final Point center;
	private final Vector size;
	
	/**
	 * Initializes this paddle with a given center and size.
	 * 
	 * @pre 
	 * 
	 * @post this paddle's center equals the given center.
	 * 		| getCenter() == center
	 * @post this paddle's size equals the given size.
	 * 		| getSize() == size
	 * 
	 * @param center
	 * @param size
	 */
	
	public PaddleState(Point center, Vector size) {
		this.center = center;
		this.size = size;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public Vector getSize() {
		return size;
	}
}
