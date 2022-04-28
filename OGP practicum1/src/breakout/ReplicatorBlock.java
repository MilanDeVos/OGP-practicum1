package breakout;

import java.awt.Color;

/**
 * Represents the state of a replicator block in the breakout game.
 *
 *@immutable
 * @invar | getLocation() != null
 */
public class ReplicatorBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;
	private final static Color color = Color.RED;
	private final static int health = -1;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * 
	 * @post | getLocation().equals(location)
	 */
	public ReplicatorBlock(Rect location) {
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
	
	/**
	 * returns true or false if the block is destroyed or not
	 */
	@Override
	public boolean isDestroyed() {
		return true;
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
		return false;
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
		return true;
	}
	
	/**
	 * Returns this blocks health.
	 */
	@Override
	public int getHealth() {
		return health;
	}
}