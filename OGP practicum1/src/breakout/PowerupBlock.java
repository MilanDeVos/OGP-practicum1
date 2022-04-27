package breakout;

import java.awt.Color;

/**
 * Represents the state of a powerup block in the breakout game.
 *
 * @invar | getLocation() != null
 */
public class PowerupBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;
	private final static Color color = Color.MAGENTA;
	private final static int health = -1;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * 
	 * @post | getLocation().equals(location)
	 */
	public PowerupBlock(Rect location) {
		this.location = location;
	}

	/**
	 * Return the rectangle occupied by this block in the field.
	 */
	@Override
	public Rect getLocation() {
		return location;
	}
	
	/**
	 * Returns this blocks color.
	 */
	@Override
	public Color getColor() {
		return color;
	}
	
	@Override
	public boolean isDestroyed() {
		if (health <= 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isNormal() {
		return false;
	}
	
	@Override
	public boolean isSturdy() {
		return false;
	}
	
	@Override
	public boolean isPowerup() {
		return true;
	}
	
	@Override
	public boolean isReplicator() {
		return false;
	}
	
	/**
	 * Returns this blocks health.
	 */
	@Override
	public int getHealth() {
		return health;
	}
}
