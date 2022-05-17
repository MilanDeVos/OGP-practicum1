package radioactivity;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import utils.Circle;
import utils.Point;
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
	
	public Color getColor() {
		return ALPHA_COLOR;
	}
	
    public void move(Vector v, int elapsedTime) {
		location = new Circle(getLocation().getCenter().plus(v), getLocation().getDiameter());
	}
    
    public Alpha cloneWithVelocity(Vector v) {
		return new Alpha(getLocation(), v);
	}
    
    /**
	 * Return a clone of this BallState.
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
