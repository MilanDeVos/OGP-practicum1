package breakout;

/**
 * An object of this class stores a block which has a center point and a size vector.
 	 * @immutable 
	 * @invar This center point's coordinates are nonnegative.
	 * 		| getCenter().getX() >= 0 |  getCenter().getY() >= 0
	 * @invar this size vector's coordinates are nonnegative.
	 * 		| getSize().getX() >= 0 |  getSize().getY() >= 0
	 * 
	 * 
 */

public class BlockState {
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
	 * Initializes this block with a given center and size.
	 * 
	 * @post this block's center equals the given center.
	 * 		| getCenter() == center
	 * @post this block's size equals the given size.
	 * 		| getSize() == size
	 * 
	 * @param center
	 * @param size
	 */
	public BlockState(Point center, Vector size) {
		this.center = center;
		this.size = size;
	}
	/**
	 * This getter returns the center of the block.
	 * @return
	 */
	public Point getCenter() {
		return center;
	}
	/**
	 * This getter returns the size of the vector, x-value is the width, y-value is the height.
	 * @return
	 */
	public Vector getSize() {
		return size;
	}
}
