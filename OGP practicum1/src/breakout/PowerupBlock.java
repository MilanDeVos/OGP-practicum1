package breakout;

import java.awt.Color;

/**
 * Represents the state of a block in the breakout game.
 *
 * @immutable
 * @invar | getLocation() != null
 */
public class PowerupBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	public final Rect location;
	public final static Color color = Color.MAGENTA;
	public final static int health = -1;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public PowerupBlock(Rect location) {
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
		return false;
	}
	
	public boolean isPowerup() {
		return true;
	}
	
	public boolean isReplicator() {
		return false;
	}
	
	public int getHealth() {
		return health;
	}
}
