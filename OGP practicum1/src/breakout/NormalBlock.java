package breakout;

import java.awt.Color;

/**
 * Represents the state of a normal block in the breakout game.
 *
 * @invar | getLocation() != null
 * @invar | getHealth() == -1
 */
public class NormalBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;
	private final static Color color = Color.BLUE;
	private final static int health = -1;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * 
	 * @post | getLocation().equals(location)
	 */
	public NormalBlock(Rect location) {
		this.location = location;
	}

	/**
	 * Return the rectangle occupied by this block in the field.
	 */
	public Rect getLocation() {
		return location;
	}
	
	/**
	 * Returns this blocks color.
	 */
	public Color getColor() {
		return color;
	}
	
	public boolean isNormal() {
		return true;
	}
	
	public boolean isSturdy() {
		return false;
	}
	
	public boolean isPowerup() {
		return false;
	}
	
	public boolean isReplicator() {
		return false;
	}
	
	/**
	 * Returns this blocks health.
	 */
	public int getHealth() {
		return health;
	}
}