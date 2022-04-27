package breakout;

import java.awt.Color;

/**
 * Represents the state of a block in the breakout game.
 *
 * @invar | getLocation() != null
 * @invar | getHealth() != -1
 */
public class SturdyBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;
	private  Color color;
	private final int health;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * 
	 * @post | getLocation().equals(location)
	 */
	public SturdyBlock(Rect location, int health) {
		this.location = location;
		this.health = health;
		if (health == 3) {
			color = Color.ORANGE;
		}
		if (health == 2) {
			color = Color.YELLOW;
		}
		if (health == 1) {
			color = Color.gray;
		}
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
		return false;
	}
	
	public boolean isSturdy() {
		return true;
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
