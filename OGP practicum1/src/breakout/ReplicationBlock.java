package breakout;

import java.awt.Color;

/**
 * Represents the state of a block in the breakout game.
 *
 * @immutable
 * @invar | getLocation() != null
 */
public class ReplicationBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	public final Rect location;
	public final static Color color = Color.RED;
	public final static int health = -1;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public ReplicationBlock(Rect location) {
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
		return false;
	}
	
	public boolean isReplication() {
		return true;
	}
	
	public int getHealth() {
		return health;
	}
}