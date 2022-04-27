package breakout;

import java.awt.Color;

/**
 * Represents the state of a replicator block in the breakout game.
 *
 *@immutable
 * @invar | getLocation() != null
 * @invar | getHealth() == -1
 */
public class ReplicatorBlock extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;
	private final static Color color = Color.RED;
	private final static int health = -1;
	
	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * 
	 * @post | getLocation().equals(location)
	 */
	public ReplicatorBlock(Rect location) {
		this.location = location;
	}

	/**
	 * Return the rectangle occupied by this block in the field.
	 */
	@Override
	public Rect getLocation() {
		return location;
	}
	
	/**
	 * Returns this blocks color.
	 */
	@Override
	public Color getColor() {
		return color;
	}
	
	@Override
	public boolean isDestroyed() {
		return true;
	}
	
	@Override
	public boolean isNormal() {
		return false;
	}
	
	@Override
	public boolean isSturdy() {
		return false;
	}
	
	@Override
	public boolean isPowerup() {
		return false;
	}
	
	@Override
	public boolean isReplicator() {
		return true;
	}
	
	/**
	 * Returns this blocks health.
	 */
	@Override
	public int getHealth() {
		return health;
	}
}