package breakout;

import java.awt.Color;

/**
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
	
	public abstract boolean isNormal();
	
	public abstract boolean isSturdy();
	
	public abstract boolean isPowerup();
	
	public abstract boolean isReplicator();
	
	/**
	 * Returns this blocks health.
	 */
	public abstract int getHealth();
}
