package de.mvcturbine.util.geom;

public class Vec2D implements Cloneable, IDimensionProvider
{
	public double x;
	public double y;

	public Vec2D()
	{
		this(0, 0);
	}

	public Vec2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vec2D add(IDimensionProvider vec)
	{
		this.x += vec.getX();
		this.y += vec.getY();
		return this;
	}

	public Vec2D sub(IDimensionProvider vec)
	{
		this.x -= vec.getX();
		this.y -= vec.getY();
		return this;
	}

	public Vec2D multiply(double m)
	{
		this.x *= m;
		this.y *= m;
		return this;
	}

	public Vec2D rotate(double angle)
	{
		double x = this.x * Math.cos(angle) - this.y * Math.sin(angle);
		this.y = this.y * Math.cos(angle) + this.x * Math.sin(angle);
		this.x = x;
		return this;
	}

	public double length()
	{
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}

	@Override
	public Vec2D clone()
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
}
