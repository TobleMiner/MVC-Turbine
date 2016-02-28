package de.mvcturbine.world.entity;

import java.util.Observable;
import java.util.Observer;

import de.mvcturbine.util.geom.BoundingBox;
import de.mvcturbine.util.geom.EntityBB;
import de.mvcturbine.util.geom.Loc2D;
import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.World;
import de.mvcturbine.world.physics.PhysicsModel;

public class Entity implements Observer
{
	/** {@code true} if entity shall be removed by tick scheduler */
	protected boolean remove = false;

	protected PhysicsModel physics;

	protected Loc2D location;

	protected World world;

	protected Size2D size;

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
	public Loc2D getLocation()
	{
		return this.location;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setLocation(Loc2D loc)
	{
		this.location = loc;
	}

	/**
	 * @return the world
	 */
	public World getWorld()
	{
		return this.world;
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
	public Size2D getSize()
	{
		return this.size;
	}

	public BoundingBox getBounds()
	{
		return new EntityBB(this);
	}
}
