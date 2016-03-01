package de.mvcturbine.util.geom;

public class Vec2D implements Cloneable, DimensionProvider, Comparable<Vec2D>
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

	public Vec2D(DimensionProvider d)
	{
		this.x = d.getX();
		this.y = d.getY();
	}

	public Vec2D add(DimensionProvider vec)
	{
		this.x += vec.getX();
		this.y += vec.getY();
		return this;
	}

	public Vec2D sub(DimensionProvider vec)
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

	public Vec2D divide(double d)
	{
		this.x /= d;
		this.y /= d;
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

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vec2D)) return false;
		Vec2D vec = (Vec2D) obj;
		return vec.x == this.x && vec.y == this.y;
	}

	@Override
	public int compareTo(Vec2D vec)
	{
		if(vec.length() > this.length()) return 1;
		if(vec.length() < this.length()) return -1;
		return 0;
	}

	public double getAngle()
	{
		return Math.atan2(this.y, this.x);
	}

	public Vec2D setAngle(double a)
	{
		double length = this.length();
		this.x = length * Math.cos(a);
		this.y = length * Math.sin(a);
		return this;
	}
}
