package de.mvcturbine.world.entity;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import de.mvcturbine.util.geom.AABB;
import de.mvcturbine.util.geom.Pos2D;
import de.mvcturbine.world.World;
import de.mvcturbine.world.physics.PhysicsModel;

public class Entity implements Observer
{
	/** {@code true} if entity shall be removed by tick scheduler */
	protected boolean remove = false;

	protected PhysicsModel physics;

	protected Pos2D location;

	protected World world;

	private Dimension size;

	protected Entity(World w)
	{
		this.world = w;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		if(o instanceof World)
		{
			this.worldUpdate((World) o);
		}
		this.applyPhysics();
	}

	protected void worldUpdate(World w)
	{

	}

	protected void applyPhysics()
	{
		if(this.physics == null) return;
		this.physics.apply();
	}

	/**
	 * @return the position
	 */
	public Pos2D getPosition()
	{
		return this.location;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Pos2D position)
	{
		this.location = position;
	}

	/**
	 * @return the world
	 */
	public World getWorld()
	{
		return world;
	}

	/**
	 * @param world
	 *            the world to set
	 */
	public void setWorld(World world)
	{
		this.world = world;
	}

	/**
	 * @return the size
	 */
	public Dimension getSize()
	{
		return size;
	}

	public AABB getBounds()
	{
		Rectangle aabb = new Rectangle(this.location, this.size);
	}
}
