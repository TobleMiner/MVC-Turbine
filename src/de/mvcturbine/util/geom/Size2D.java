package de.mvcturbine.util.geom;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;

public class Size2D extends Dimension2D implements IDimensionProvider
{
	public double width;
	public double height;

	public Size2D(double widht, double height)
	{
		this.width = widht;
		this.height = height;
	}

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
}
