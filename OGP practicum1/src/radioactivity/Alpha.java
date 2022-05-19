package radioactivity;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import breakout.BreakoutState;
import utils.Circle;
import utils.Point;
import utils.Rect;
import utils.Vector;

public class Alpha {
	
	protected Circle location;
	protected Vector velocity;
	
	private static final Color ALPHA_COLOR = Color.cyan;
	
    /**
     * @invar linkedBalls != null
     * 
     * @peerObjects
     */
    Set<Ball> linkedBalls = new HashSet<Ball>();	
    
    public Alpha(Circle location, Vector velocity) {
    	this.location = location;
    	this.velocity = velocity;
    }
    
    public Set<Ball> getBalls() {
    	Set<Ball> theseBalls = new HashSet<Ball>();
    	for (Ball b : linkedBalls) {
    		theseBalls.add(b);
    	}
    	return theseBalls; //moet met clones gedaan worden
    }
    
    /**
	 * Return this alpha's location.
	 */
	public Circle getLocation() {
		return location;
	}
	
	/**
	 * Return this point's center.
	 * 
	 * @post | getLocation().getCenter().equals(result)
	 * @inspects this
	 */
	public Point getCenter() {
		return getLocation().getCenter();
	}
	
	/**
	 * Return this ball's velocity.
	 */
	public Vector getVelocity() {
		return velocity;
	}
	
	/**
	 * Check whether this alpha collides with a given `rect` and if so, return the
	 * new velocity this alpha will have after bouncing on the given rect.
	 * 
	 * @pre | rect != null
	 * @post | (rect.collideWith(getLocation()) == null && result == null) ||
	 *       | (rect.collideWith(getLocation()) != null && getVelocity().product(rect.collideWith(getLocation())) <= 0 && result == null) ||
	 *       | (rect.collideWith(getLocation()) != null && result.equals(getVelocity().mirrorOver(rect.collideWith(getLocation()))))
	 * @inspects this
	 */
	public Vector bounceOn(Rect rect) {
		Vector coldir = rect.collideWith(location);
		if (coldir != null && velocity.product(coldir) > 0) {
			return velocity.mirrorOver(coldir);
		}
		return null;
	}
	
	/**
	 * Check whether this ball collides with a given `rect`.
	 * 
	 * @pre | rect != null
	 * @post | result == ((rect.collideWith(getLocation()) != null) &&
	 *       |            (getVelocity().product(rect.collideWith(getLocation())) > 0))
	 * @inspects this
	 */
	public boolean collidesWith(Rect rect) {
		Vector coldir = rect.collideWith(getLocation());
		return coldir != null && (getVelocity().product(coldir) > 0);
	}
	
	public Color getColor() {
		return ALPHA_COLOR;
	}
	
	/**
	 * Move this Alpha by the given vector.
	 * 
	 * @pre | v != null
	 * @pre | elapsedTime >= 0
	 * @pre | elapsedTime <= BreakoutState.MAX_ELAPSED_TIME
	 * @post | getLocation().getCenter().equals(old(getLocation()).getCenter().plus(v))
	 * @post | getLocation().getDiameter() == old(getLocation()).getDiameter()
	 * @mutates this
	 */
    public void move(Vector v, int elapsedTime) {
		location = new Circle(getLocation().getCenter().plus(v), getLocation().getDiameter());
	}
    
    /**
	 * Update the Alpha after hitting a paddle at a given location.
	 * 
	 * @pre | rect != null
	 * @pre | collidesWith(rect)
	 * @pre | paddleVel != null
	 * @post | getLocation().equals(old(getLocation()))
	 * @mutates this
	 */
    public void hitPaddle(Rect rect, Vector paddleVel) {
		Vector nspeed = bounceOn(rect);
		velocity = nspeed.plus(paddleVel.scaledDiv(5));
	}
    
    /**
	 * Update the Alpha after hitting a wall at a given location.
	 * 
	 * @pre | rect != null
	 * @pre | collidesWith(rect)
	 * @post | getLocation().equals(old(getLocation()))
	 * @mutates this
	 */
    public void hitWall(Rect rect) {
		velocity = bounceOn(rect);
	}
    
    public Alpha cloneWithVelocity(Vector v) {
		return new Alpha(getLocation(), v);
	}
    
    /**
	 * Return a clone of this ALpha.
	 * 
	 * @inspects this
	 * @creates result
	 * @post | result.getLocation().equals(getLocation())
	 * @post | result.getVelocity().equals(getVelocity())
	 */
	public Alpha clone() {
		return cloneWithVelocity(getVelocity());
	}
}
