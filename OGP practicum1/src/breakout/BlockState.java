package breakout;

public class BlockState {
	// TODO: implement
	private final Point center;
	private final Vector size;
	
	public BlockState(Point center, Vector size) {
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
