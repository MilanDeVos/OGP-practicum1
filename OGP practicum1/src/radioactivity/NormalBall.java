package radioactivity;

import java.awt.Color;
//import java.util.Arrays;
import utils.Circle;
import utils.Vector;
import utils.Rect;
import utils.Point;
import radioactivity.Alpha;

public class NormalBall extends Ball {

	private static final Color BALL_COLOR = Color.yellow;

	public NormalBall(Circle location, Vector velocity) {
		super(location, velocity);
	}

	/**
	 * Update the BallState after hitting a block at a given location.
	 * 
	 * @pre | rect != null
	 * @pre | collidesWith(rect)
	 * @post | getLocation().equals(old(getLocation()))
	 * @post | getVelocity().equals(old(getVelocity()).mirrorOver(rect.collideWith(old(getLocation()))))
	 * @mutates this
	 */
	@Override
	public void hitBlock(Rect rect, boolean destroyed) {
		velocity = bounceOn(rect);
	}

	@Override
	public void move(Vector v, int elapsedTime) {
		location = new Circle(getLocation().getCenter().plus(v), getLocation().getDiameter());
	}

	@Override
	public void hitPaddle(Rect rect, Vector paddleVel) {
		Vector nspeed = bounceOn(rect);
		velocity = nspeed.plus(paddleVel.scaledDiv(5));
		//Alpha newAlpha = new Alpha(this.getLocation(), this.getVelocity().plus(new Vector(-2 ,-2)));
		//this.linkedAlphas.add(newAlpha);
	}

	@Override
	public void hitWall(Rect rect) {
		velocity = bounceOn(rect);
	}

	@Override
	public Color getColor() {
		return BALL_COLOR;
	}

	@Override
	public Ball cloneWithVelocity(Vector v) {
		return new NormalBall(getLocation(), v);
	}
	
//	public int getEcharge() {
//		return eCharge;
//	}
}
