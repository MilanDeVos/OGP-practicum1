package breakout;

import java.awt.Color;

/**
 * @immutable
 * Represents the state of a block in the breakout game.
 */
public abstract class BlockState {
	
	/**
	 * Return the rectangle occupied by this block in the field.
	 */
	public abstract Rect getLocation();
	
	/**
	 * Returns this blocks color.
	 */
	public abstract Color getColor();
	
	/**
	 * returns true or false if the block is destroyed or not
	 */
	public abstract boolean isDestroyed();
	
	/**
	 * returns true or false if the block is normal or not
	 */
	public abstract boolean isNormal();
	
	/**
	 * returns true or false if the block is sturdy or not
	 */
	public abstract boolean isSturdy();
	
	/**
	 * returns true or false if the block is powerup or not
	 */
	public abstract boolean isPowerup();
	
	/**
	 * returns true or false if the block is replicator or not
	 */
	public abstract boolean isReplicator();
	
	/**
	 * Returns this blocks health.
	 */
	public abstract int getHealth();
}
