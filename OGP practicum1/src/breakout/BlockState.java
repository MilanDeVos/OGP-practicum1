package breakout;

import java.awt.Color;

/**
 * Represents the state of a block in the breakout game.
 *
 * @immutable
 * @invar | getLocation() != null
 */
public abstract class BlockState {
	
	/**
	 * Return the rectangle occupied by this block in the field.
	 */
	public abstract Rect getLocation();
	
	public abstract Color getColor();
	
	public abstract boolean isNormal();
	
	public abstract boolean isSturdy();
	
	public abstract boolean isPowerup();
	
	public abstract boolean isReplication();
	
	public abstract int getHealth();
}
