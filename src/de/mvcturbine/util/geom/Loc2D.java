package de.mvcturbine.util.geom;

import java.awt.geom.Point2D;

/**
 * Represents a coordinate in 2d space with double precision
 * 
 * @author tsys
 *
 */
public class Loc2D extends Point2D implements Cloneable, DimensionProvider
{
	/** The x component */
	public double x;

	/** The y component */
	public double y;

	/**
	 * Constructs a new location at [0, 0]
	 */
	public Loc2D()
	{
		this(0, 0);
	}

	/**
	 * 
	 * Constructs a new location at [{@code x}, {@code y}]
	 * 
	 * @param x
	 *            X coordiante
	 * @param y
	 *            Y coordinate
	 */
	public Loc2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Initializes a new Loc2D from a {@link DimensionProvider}
	 * 
	 * @param d
	 *            The {@link DimensionProvider}
	 */
	public Loc2D(DimensionProvider d)
	{
		this.x = d.getX();
		this.y = d.getY();
	}

	/**
	 * Adds the coordinates of a {@link DimensionProvider} to this location
	 * 
	 * @param vec
	 *            The {@link DimensionProvider}
	 * @return This vector
	 */
	public Loc2D add(DimensionProvider vec)
	{
		this.x += vec.getX();
		this.y += vec.getY();
		return this;
	}

	/**
	 * Subtracts the coordinates of a {@link DimensionProvider} from this
	 * location
	 * 
	 * @param vec
	 *            The {@link DimensionProvider}
	 * @return This vector
	 */
	public Loc2D sub(DimensionProvider vec)
	{
		this.x -= vec.getX();
		this.y -= vec.getY();
		return this;
	}

	@Override
	public Loc2D clone()
	{
		return new Loc2D(this);
	}

	/**
	 * Constructs a vector to this location
	 * 
	 * @return
	 */
	public Vec2D toVector()
	{
		return new Vec2D(this);
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
