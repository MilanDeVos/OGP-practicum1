package breakout;

import java.awt.Color;

/**
 * Represents the state of a paddle in the breakout game.
 *
 * @immutable
 * @invar | getCenter() != null
 */
public abstract class PaddleState {
	
	public abstract Point getCenter();

	public abstract Rect getLocation();
	
	public abstract Color getColor();
	
	public abstract int getHealth();
	
	public abstract void setCenter(Point newCenter);
	
	public abstract void setHealth(int newHealth);
	
	public abstract boolean isNormal();
	
	public abstract boolean isReplicator();

}
