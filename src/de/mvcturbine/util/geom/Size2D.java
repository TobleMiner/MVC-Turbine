package de.mvcturbine.util.geom;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;

/**
 * 2 dimensional space quantifier with double precision
 * 
 * @author tsys
 *
 */
public class Size2D extends Dimension2D implements DimensionProvider
{
	/** Width */
	public double width;

	/** Height */
	public double height;

	/**
	 * Constructs a new Size2D with the given width and height<
	 * 
	 * @param widht
	 *            Width
	 * @param height
	 *            Height
	 */
	public Size2D(double widht, double height)
	{
		this.width = widht;
		this.height = height;
	}

	/**
	 * Initializes a new Size2D from a {@link DimensionProvider}, taking the x
	 * coordinate as the width and the y coordinate as the height
	 * 
	 * @param d
	 *            A {@link DimensionProvider}
	 */
	public Size2D(DimensionProvider d)
	{
		this.width = d.getX();
		this.height = d.getY();
	}

	/**
	 * Initializes a new Size2D from a Java.awt Dimension
	 * 
	 * @param d
	 *            Dimension
	 */
	public Size2D(Dimension d)
	{
		this.width = d.getWidth();
		this.height = d.getHeight();
	}

	@Override
	public double getHeight()
	{
		return this.height;
	}

	@Override
	public double getWidth()
	{
		return this.width;
	}

	@Override
	public void setSize(double width, double height)
	{
		this.width = width;
		this.height = height;
	}

	@Override
	public double getX()
	{
		return this.width;
	}

	@Override
	public double getY()
	{
		return this.height;
	}

	@Override
	public String toString()
	{
		return String.format("%s[width=%f,height=%f]", this.getClass().getName(),
				this.getX(), this.getY());
	}
}
