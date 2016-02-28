package de.mvcturbine.world;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import de.mvcturbine.world.entity.Entity;

public class World extends Observable
{
	protected List<Entity> entityRegistry = new ArrayList<>();
	protected List<Entity> entityRemove = new ArrayList<>();
	protected List<Entity> entityAdd = new ArrayList<>();

	private Dimension size;
	private Rectangle2D bounds;

	public World(Dimension size)
	{
		this.setSize(size);
	}

	/**
	 * @return the size
	 */
	public Dimension getSize()
	{
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Dimension size)
	{
		this.size = size;
		this.bounds = new Rectangle(size);
	}

	public Rectangle2D getBounds()
	{
		return this.bounds;
	}
}
