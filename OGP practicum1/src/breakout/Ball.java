package breakout;

import java.awt.Color;

/**
 * Represents the state of a ball in the breakout game.
 * 
 * @immutable
 * @invar | getLocation() != null
 * @invar | getVelocity() != null
 */
public abstract class Ball {
	
	/**
	 * Return this ball's location.
	 */
	public abstract Circle getLocation();

	/**
	 * Return this ball's velocity.
	 */
	public abstract Vector getVelocity();

	/**
	 * Check whether this ball collides with a given `rect` and if so, return the 
	 * new velocity this ball will have after bouncing on the given rect.
	 * 
	 * @pre | rect != null
	 * @post | (rect.collideWith(getLocation()) == null && result == null) ||
	 *       | (getVelocity().product(rect.collideWith(getLocation())) <= 0 && result == null) || 
	 *       | (result.equals(getVelocity().mirrorOver(rect.collideWith(getLocation()))))
	 */
	public abstract Vector bounceOn(Rect rect);

	/**
	 * Return this point's center.
	 * 
	 * @post | getLocation().getCenter().equals(result)
	 */
	public abstract Point getCenter();
	
	public abstract int getLifetime();
	
	public abstract Color getColor();
}




