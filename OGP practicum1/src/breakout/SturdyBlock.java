package breakout;

import java.awt.Color;

/**
 * Represents the state of a block in the breakout game.
 *
 *@immutable
 * @invar | getLocation() != null
 * @invar | getHealth() >= 0
 * @invar | getHealth() <=3
 */
public class SturdyBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 * @invar | health != -1
	 */
	private final Rect location;
	private  Color color;
	private int health;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * @pre | health > 0
	 * @pre | health <=3
	 * 
	 * @post | getLocation().equals(location)
	 * @post | getHealth() == health
	 * 
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
	
	/**
	 * returns true or false if the block is destroyed or not
	 */
	@Override
	public boolean isDestroyed() {
		if (health <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns true or false if the block is normal or not
	 */
	@Override
	public boolean isNormal() {
		return false;
	}
	
	/**
	 * returns true or false if the block is sturdy or not
	 */
	@Override
	public boolean isSturdy() {
		return true;
	}
	
	/**
	 * returns true or false if the block is powerup or not
	 */
	@Override
	public boolean isPowerup() {
		return false;
	}
	
	/**
	 * returns true or false if the block is replicator or not
	 */
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
