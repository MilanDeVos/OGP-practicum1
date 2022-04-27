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
public class SuperchargedBall extends Ball {
	
	/**
	 * @invar | location != null
	 * @invar | velocity != null
	 * @invar | lifetime >= 0
	 * 
	 */
	private Circle location;
	private Vector velocity;
	public int lifetime;
	private final static Color color = Color.MAGENTA;
	
	/**
	 * @pre | location != null
	 * @pre | velocity != null
	 * 
	 * @post | location == getLocation()
	 * @post | velocity == getVelocity()
	 * @post | lifetime == getLifetime()
	 */
	public SuperchargedBall(Circle location, Vector velocity, int lifetime) {
		this.location = location;
		this.velocity = velocity;
		this.lifetime = lifetime;
	}
	
	/**
	 * Return this ball's location.
	 */
	@Override
	public Circle getLocation() {
		return location;
	}

	/**
	 * Return this ball's velocity.
	 */
	@Override
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
	@Override
	public Vector bounceOn(Rect rect) {
		Vector coldir = rect.collideWith(location);
		if(coldir != null && velocity.product(coldir) > 0) {
			return velocity.mirrorOver(coldir);
		}
		return null;
	}
	
	@Override
	public Vector hitBlock(Rect rect, boolean destroyed) {
		Vector coldir = rect.collideWith(location);
		if(coldir != null && velocity.product(coldir) > 0 && destroyed == false) {
			return velocity.mirrorOver(coldir);
		}
		else if(coldir != null && velocity.product(coldir) > 0 && destroyed == true) {
			return velocity;
		}
		return null;
	}

	/**
	 * Return this point's center.
	 * 
	 * @post | getLocation().getCenter().equals(result)
	 */
	@Override
	public Point getCenter() {
		return getLocation().getCenter();
	}
	
	/**
	 * Return this ball's lifetime.
	 */
	@Override
	public int getLifetime() {
		return lifetime;
	}
	
	/**
	 * Return this ball's color.
	 */
	@Override
	public Color getColor() {
		return color;
	}
	
	/**
	 * sets this ball's lifetime to the given value.
	 */
	@Override
	public void setLifetime(int newLifetime) {
		this.lifetime = newLifetime;
	}
	
	/**
	 * sets this ball's center to the given value.
	 */
	@Override
	public void setCenter(Point newCenter) {
		this.location = new Circle(newCenter, 700);
	}
	
	/**
	 * sets this ball's location to the given value.
	 */
	@Override
	public void setLocation(Circle newLocation) {
		this.location = newLocation;
	}
	
	/**
	 * sets this ball's velocity to the given value.
	 */
	@Override
	public void setVelocity(Vector newVelocity) {
		this.velocity = newVelocity;
	}
	
	@Override
	public boolean isNormal() {
		return false;
	}
	
	@Override
	public boolean isSupercharged() {
		return true;
	}

}