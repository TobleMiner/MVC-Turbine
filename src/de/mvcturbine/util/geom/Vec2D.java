package de.mvcturbine.util.geom;

public class Vec2D implements Cloneable, DimensionProvider, Comparable<Vec2D>
{
	/** length in x direction */
	public double x;

	/** length in y direction */
	public double y;

	/**
	 * Initializes a null vector (I'm so disoriented :()
	 */
	public Vec2D()
	{
		this(0, 0);
	}

	/**
	 * Initializes a new vector with the given extent in x and y direction
	 * 
	 * @param x
	 * @param y
	 */
	public Vec2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Initializes this vector from {@link DimensionProvider}
	 * 
	 * @param d
	 *            A {@link DimensionProvider}
	 */
	public Vec2D(DimensionProvider d)
	{
		this.x = d.getX();
		this.y = d.getY();
	}

	/**
	 * Adds a {@link DimensionProvider} to this vector
	 * 
	 * @param vec
	 *            The {@link DimensionProvider}
	 * @return This vector
	 */
	public Vec2D add(DimensionProvider vec)
	{
		this.x += vec.getX();
		this.y += vec.getY();
		return this;
	}

	/**
	 * Subtracts a {@link DimensionProvider} from this vector
	 * 
	 * @param vec
	 *            The {@link DimensionProvider}
	 * @return This vector
	 */
	public Vec2D sub(DimensionProvider vec)
	{
		this.x -= vec.getX();
		this.y -= vec.getY();
		return this;
	}

	/**
	 * Multiplies the vector scalar with {@code m}
	 * 
	 * @param m
	 *            The factor
	 * @return This vector
	 */
	public Vec2D multiply(double m)
	{
		this.x *= m;
		this.y *= m;
		return this;
	}

	/**
	 * Performs scalar division on this vector
	 * 
	 * @param d
	 *            The divisor
	 * @return This vector
	 */
	public Vec2D divide(double d)
	{
		this.x /= d;
		this.y /= d;
		return this;
	}

	/**
	 * Rotates this vector
	 * 
	 * @param angle
	 *            Angle in rad
	 * @return This vector
	 */
	public Vec2D rotate(double angle)
	{
		double x = this.x * Math.cos(angle) - this.y * Math.sin(angle);
		this.y = this.y * Math.cos(angle) + this.x * Math.sin(angle);
		this.x = x;
		return this;
	}

	/**
	 * Returns the length of this vector
	 * 
	 * @return The length of this vector
	 */
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

	/**
	 * Returns the angle of this vector
	 * 
	 * @return The angle of this vector
	 */
	public double getAngle()
	{
		return Math.atan2(this.y, this.x);
	}

	/**
	 * Sets the angle of this vector (keeps the length)
	 * 
	 * @param a
	 *            The angle to set
	 * @return This vector
	 */
	public Vec2D setAngle(double a)
	{
		double length = this.length();
		this.x = length * Math.cos(a);
		this.y = length * Math.sin(a);
		return this;
	}
}
