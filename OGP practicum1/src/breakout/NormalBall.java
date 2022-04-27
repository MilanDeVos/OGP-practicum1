package breakout;

import java.awt.Color;

/**
 * Represents the state of a normal ball in the breakout game.
 * 
 * @invar | getLocation() != null
 * @invar | getVelocity() != null
 * @invar | getLifetime() >= 0
 * 
 */
public class NormalBall extends Ball {
	
	/**
	 * @invar | location != null
	 * @invar | velocity != null
	 * @invar | lifetime >= 0
	 * 
	 */
	private Circle location;
	private Vector velocity;
	private int lifetime;
	private final static Color color = Color.green;
	
	/**
	 * @pre | location != null
	 * @pre | velocity != null
	 * 
	 * @post | location == getLocation()
	 * @post | velocity == getVelocity()
	 * @post | lifetime == getLifetime()
	 */
	
	public NormalBall(Circle location, Vector velocity, int lifetime) {
		this.location = location;
		this.velocity = velocity;
		this.lifetime = lifetime;
	}
	
	/**
	 * Return this ball's location.
	 */
	public Circle getLocation() {
		return location;
	}

	/**
	 * Return this ball's velocity.
	 */
	public Vector getVelocity() {
		return velocity;
	}

	/**
	 * Check whether this ball collides with a given `rect` and if so, return the 
	 * new velocity this ball will have after bouncing on the given rect.
	 * 
	 * @pre | rect != null
	 * @post | (rect.collideWith(getLocation()) == null && result == null) ||
	 *       | (getVelocity().product(rect.collideWith(getLocation())) <= 0 && result == null) || 
	 *       | (result.equals(getVelocity().mirrorOver(rect.collideWith(getLocation()))))
	 */
	public Vector bounceOn(Rect rect) {
		Vector coldir = rect.collideWith(location);
		if(coldir != null && velocity.product(coldir) > 0) {
			return velocity.mirrorOver(coldir);
		}
		return null;
	}

	/**
	 * Return this point's center.
	 * 
	 * @post | getLocation().getCenter().equals(result)
	 */
	public Point getCenter() {
		return getLocation().getCenter();
	}
	
	/**
	 * Return this ball's lifetime.
	 */
	public int getLifetime() {
		return lifetime;
	}
	
	/**
	 * Return this ball's color.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * sets this ball's lifetime to the given value.
	 */
	public void setLifetime(int newLifetime) {
		this.lifetime = newLifetime;
	}
	
	/**
	 * sets this ball's center to the given value.
	 */
	public void setCenter(Point newCenter) {
		this.location = new Circle(newCenter, 700);
	}
	
	/**
	 * sets this ball's location to the given value.
	 */
	public void setLocation(Circle newLocation) {
		this.location = newLocation;
	}
	
	/**
	 * sets this ball's velocity to the given value.
	 */
	public void setVelocity(Vector newVelocity) {
		this.velocity = newVelocity;
	}
	
	public boolean isNormal() {
		return true;
	}
	
	public boolean isSupercharged() {
		return false;
	}


}