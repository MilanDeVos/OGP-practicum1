package breakout;

import java.awt.Color;

/**
 * Represents the state of a paddle in the breakout game.
 *
 * @immutable
 * @invar | getCenter() != null
 */

public class ReplicatorPaddle extends PaddleState {
	
	public static final int HEIGHT = 500;
	public static final int WIDTH = 3000;
	private final static Color color = Color.BLUE;
	private int health;
	
	/**
	 * @invar | center != null
	 */
	private Point center;
	
	/**
	 * Construct a paddle located around a given center in the field.
	 * @pre | center != null
	 * @post | getCenter().equals(center)
	 */
	public ReplicatorPaddle(Point center, int health) {
		this.center = center;
		this.health = health;
	}
	
	/**
	 * Return the center point of this paddle.
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * Return the rectangle occupied by this paddle in the field.
	 * 
	 * @post | result != null
	 * @post | result.getTopLeft().equals(getCenter().plus(new Vector(-WIDTH/2,-HEIGHT/2)))
	 * @post | result.getBottomRight().equals(getCenter().plus(new Vector(WIDTH/2,HEIGHT/2)))
	 */
	public Rect getLocation() {
		Vector halfDiag = new Vector(-WIDTH/2,-HEIGHT/2);
		return new Rect(center.plus(halfDiag), center.plus(halfDiag.scaled(-1)));
	}
	
	public Color getColor() {
		return color;
	}
	
	public  int getHealth() {
		return health;
	}
	
	public  void setCenter(Point newCenter) {
		this.center = newCenter;
	}
	
	public  void setHealth(int newHealth) {
		this.health = newHealth;
	}
	
	public  boolean isNormal() {
		return false;
	}
	
	public  boolean isReplicator() {
		return true;
	}
	
}