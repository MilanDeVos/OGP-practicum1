package breakout;

import java.awt.Color;

/**
 * Represents the state of a block in the breakout game.
 *
 * @immutable
 * @invar | getLocation() != null
 */
public class SturdyBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;
	private final static Color color = Color.ORANGE;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public SturdyBlock(Rect location) {
		this.location = location;
	}

	/**
	 * Return the rectangle occupied by this block in the field.
	 */
	public Rect getLocation() {
		return location;
	}
	
	public Color getColor() {
		return color;
	}
	
	public boolean isNormal() {
		return false;
	}
	
	public boolean isSturdy() {
		return true;
	}
	
	public boolean isPowerup() {
		return false;
	}
	
	public boolean isReplication() {
		return false;
	}
}
