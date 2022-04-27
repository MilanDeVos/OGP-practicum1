package breakout;

import java.awt.Color;

/**
 * Represents the state of a block in the breakout game.
 *
 *@immutable
 * @invar | getLocation() != null
 * @invar | getHealth() != -1
 */
public class SturdyBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;
	private  Color color;
	private int health;
	
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
		return true;
	}
	
	@Override
	public boolean isPowerup() {
		return false;
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
