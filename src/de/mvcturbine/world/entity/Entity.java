package de.mvcturbine.world.entity;

import java.util.Observable;
import java.util.Observer;

import de.mvcturbine.util.geom.BoundingBox;
import de.mvcturbine.util.geom.EntityBB;
import de.mvcturbine.util.geom.Loc2D;
import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.World;
import de.mvcturbine.world.physics.PhysicsModel;

/**
 * Base class of all in game entities
 * 
 * @author tsys
 *
 */
public class Entity implements Observer
{
	/** {@code true} if entity shall be removed by tick scheduler */
	protected boolean remove = false;

	/** Physics mode to use for this entity */
	protected PhysicsModel physics;

	/** Location of this entity */
	protected Loc2D location;

	/** World this entity is in */
	protected World world;

	/** Size of this entity */
	protected Size2D size;

	/** Constructs a new entity */
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

	/**
	 * Update tick by world
	 * 
	 * @param w
	 *            The world
	 */
	protected void worldUpdate(World w)
	{

	}

	/**
	 * Apply the set physics model to this entity
	 */
	protected void applyPhysics()
	{
		if(this.physics == null) return;
		this.physics.apply();
	}

	/**
	 * Returns the position if this entity
	 * 
	 * @return the position
	 */
	public Loc2D getLocation()
	{
		return this.location;
	}

	/**
	 * Sets the position of this entity
	 * 
	 * @param position
	 *            the position to set
	 */
	public void setLocation(Loc2D loc)
	{
		this.location = loc;
	}

	/**
	 * Returns the world this entity is in
	 * 
	 * @return the world
	 */
	public World getWorld()
	{
		return this.world;
	}

	/**
	 * Sets the world this enity is in
	 * 
	 * @param world
	 *            the world to set
	 */
	public void setWorld(World world)
	{
		this.world = world;
	}

	/**
	 * Returns the size of this entity
	 * 
	 * @return the size
	 */
	public Size2D getSize()
	{
		return this.size;
	}

	/**
	 * Returns a bounding box for this entity
	 * 
	 * @return
	 */
	public BoundingBox getBounds()
	{
		return new EntityBB(this);
	}
}
