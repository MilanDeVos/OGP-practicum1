package breakout;

import java.awt.Color;

/**
 * Represents the state of a normal ball in the breakout game.
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
	 */
	public abstract Vector bounceOn(Rect rect);
	
	public abstract Vector hitBlock(Rect rect, boolean destroyed);

	/**
	 * Return this point's center.
	 */
	public abstract Point getCenter();
	
	/**
	 * Return this ball's lifetime.
	 */
	public abstract int getLifetime();
	
	/**
	 * Return this ball's color.
	 */
	public abstract Color getColor();
	
	/**
	 * sets this ball's lifetime to the given value.
	 */
	public abstract void setLifetime(int newLifetime);
	
	/**
	 * sets this ball's center to the given value.
	 */
	public abstract void setCenter(Point newCenter);
	
	/**
	 * sets this ball's location to the given value.
	 */
	public abstract void setLocation(Circle newLocation);
	
	/**
	 * sets this ball's velocity to the given value.
	 */
	public abstract void setVelocity(Vector newVelocity);
	
	public abstract boolean isNormal();
	
	public abstract boolean isSupercharged();
	
}




