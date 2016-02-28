package de.mvcturbine.util.geom;

import java.awt.Point;

public class Loc2D extends Point implements Cloneable, DimensionProvider
{
	public double x;
	public double y;

	public Loc2D()
	{
		this(0, 0);
	}

	public Loc2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Loc2D(DimensionProvider d)
	{
		this.x = d.getX();
		this.y = d.getY();
	}

	public Loc2D add(DimensionProvider vec)
	{
		this.x += vec.getX();
		this.y += vec.getY();
		return this;
	}

	public Loc2D sub(DimensionProvider vec)
	{
		this.x -= vec.getX();
		this.y -= vec.getY();
		return this;
	}

	@Override
	public Loc2D clone()
	{
		return new Loc2D(this.x, this.y);
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

	@Override
	public String toString()
	{
		return String.format("%s[x=%f,y=%f]", this.getClass().getName(), this.getX(),
				this.getY());
	}
}
