package de.mvcturbine.util.geom;

import java.awt.Point;

public class Pos2D extends Point implements Cloneable, IDimensionProvider
{
	public double x;
	public double y;

	public Pos2D()
	{
		this(0, 0);
	}

	public Pos2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Pos2D add(IDimensionProvider vec)
	{
		this.x += vec.getX();
		this.y += vec.getY();
		return this;
	}

	public Pos2D sub(IDimensionProvider vec)
	{
		this.x -= vec.getX();
		this.y -= vec.getY();
		return this;
	}

	@Override
	public Pos2D clone()
	{
		return new Pos2D(this.x, this.y);
	}

	public Vec2D toVector()
	{
		return new Vec2D(this.x, this.y);
	}

	@Override
	public double getX()
	{
		return this.x;
	}

	@Override
	public double getY()
	{
		return this.y;
	}

	@Override
	public void setLocation(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}
