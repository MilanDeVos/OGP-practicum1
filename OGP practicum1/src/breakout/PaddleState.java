package breakout;

public class PaddleState {
	// TODO: implement
	private final Point center;
	private final Vector size;
	
	public PaddleState(Point center, Vector size) {
		this.center = center;
		this.size = size;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public Vector getSize() {
		return size;
	}
}
