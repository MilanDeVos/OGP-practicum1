package breakout;

import java.awt.Color;

/**
 * Represents the state of a paddle in the breakout game.
 *
 * @mutable
 * @invar | getCenter() != null
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
	 * sets this paddle's center to the given value.
	 */
	public abstract void setCenter(Point newCenter);
	
	/**
	 * sets this paddle's health to the given value.
	 */
	public abstract void setHealth(int newHealth);
	
	public abstract boolean isNormal();
	
	public abstract boolean isReplicator();

}
