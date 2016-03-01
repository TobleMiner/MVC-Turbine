package de.mvcturbine.util.geom;

import java.awt.geom.Point2D;

public class Line2D extends java.awt.geom.Line2D.Double
{
	public Line2D(Point2D pos1, Point2D pos2)
	{
		super(pos1, pos2);
	}

	public Line2D(Loc2D pos, Vec2D dir)
	{
		super(pos, pos.clone().add(dir));
	}

	public Vec2D getDirection()
	{
		return new Loc2D(this.getX2(), this.getY2())
				.sub(new Loc2D(this.getX1(), this.getY1())).toVector();
	}

	// TODO restructure
	public Loc2D intersection(Line2D line)
	{
		double dx0 = this.getX2() - this.getX1();
		double dy0 = this.getY2() - this.getY1();
		double dx1 = line.getX2() - line.getX1();
		double dy1 = line.getY2() - line.getY1();
		double m = (-dx1 * dy0 + dx0 * dy1);
		double s = (-dy0 * (this.getX1() - line.getX1()) +
				dx0 * (this.getY1() - line.getY1())) / m;
		double t = (dx1 * (this.getY1() - line.getY1()) -
				dy1 * (this.getX1() - line.getX1())) / m;

		if(s >= 0 && s <= 1 && t >= 0 && t <= 1)
		{
			return new Loc2D(this.getX1() + (t * dx0), this.getY1() + (t * dy0));
		}
		return null;
	}
}
