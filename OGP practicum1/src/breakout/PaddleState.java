package breakout;

import java.awt.Color;

/**
 * Represents the state of a paddle in the breakout game.
 *
 * @immutable
 */
public abstract class PaddleState {
	
	/**
	 * Return the center point of this paddle.
	 */
	public abstract Point getCenter();

	/**
	 * Return the rectangle occupied by this paddle in the field.
	 */
	public abstract Rect getLocation();
	
	/**
	 * Returns this paddle's color.
	 */
	public abstract Color getColor();
	
	/**
	 * Returns this paddle's health.
	 */
	public abstract int getHealth();
	
	/**
	 * returns true or false if the paddle is normal or not
	 */
	public abstract boolean isNormal();
	
	/**
	 * returns true or false if the paddle is replicator or not
	 */
	public abstract boolean isReplicator();

}
