package de.mvcturbine.util.geom;

import java.awt.geom.Point2D;

/**
 * Little more useful implementation of a 2D line
 * 
 * @author tsys
 *
 */
public class Line2D extends java.awt.geom.Line2D.Double
{
	/**
	 * Constructs a new line from two points
	 * 
	 * @param pos1
	 *            Point 1
	 * @param pos2
	 *            Point 2
	 */
	public Line2D(Point2D pos1, Point2D pos2)
	{
		super(pos1, pos2);
	}

	/**
	 * Constructs a line from a location and a direction
	 * 
	 * @param pos
	 *            Location
	 * @param dir
	 *            Direction
	 */
	public Line2D(Loc2D pos, Vec2D dir)
	{
		super(pos, pos.clone().add(dir));
	}

	/**
	 * Returns a vector parallel to this line
	 * 
	 * @return a vector parallel to this line
	 */
	public Vec2D getDirection()
	{
		return new Loc2D(this.getX2(), this.getY2())
				.sub(new Loc2D(this.getX1(), this.getY1())).toVector();
	}

	/**
	 * Calculates the point in which two line segments intersect
	 * 
	 * @param line
	 *            The other line
	 * @return The point of intersection or {@code null} if the two line
	 *         segments don't intersect
	 */
	public Loc2D intersection(Line2D line)
	{
		double dx0 = this.getX2() - this.getX1();
		double dy0 = this.getY2() - this.getY1();
		double dx1 = line.getX2() - line.getX1();
		double dy1 = line.getY2() - line.getY1();
		double m = (-dx1 * dy0 + dx0 * dy1);
		double rdLine0 = (-dy0 * (this.getX1() - line.getX1()) +
				dx0 * (this.getY1() - line.getY1())) / m;
		double rdLine1 = (dx1 * (this.getY1() - line.getY1()) -
				dy1 * (this.getX1() - line.getX1())) / m;

		if(rdLine0 >= 0 && rdLine0 <= 1 && rdLine1 >= 0 && rdLine1 <= 1)
		{
			return new Loc2D(this.getX1() + (rdLine0 * dx0),
					this.getY1() + (rdLine0 * dy0));
		}
		return null;
	}
}
