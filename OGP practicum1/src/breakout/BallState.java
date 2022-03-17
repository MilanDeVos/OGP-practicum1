package breakout;

public class BallState {
	// TODO: implement
	
	private final Point center;
	private final Vector size;
	private final Vector velocity;
	
	public BallState(Point center, Vector size, Vector velocity ) {
		this.center = center;
		this.size = size;
		this.velocity = velocity;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	public Vector getSize() {
		return size;
	}
}
