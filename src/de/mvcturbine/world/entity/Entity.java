package de.mvcturbine.world.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import de.mvcturbine.util.geom.BoundingBox;
import de.mvcturbine.util.geom.EntityBB;
import de.mvcturbine.util.geom.Loc2D;
import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.util.geom.Vec2D;
import de.mvcturbine.world.World;
import de.mvcturbine.world.physics.PhysicsModel;

/**
 * Base class of all in game entities
 * 
 * @author tsys
 *
 */
public abstract class Entity implements Observer
{
	/** {@code true} if entity shall be removed by tick scheduler */
	private boolean remove = false;

	/** Physics mode to use for this entity */
	protected PhysicsModel physics;

	/** Location of this entity */
	protected Loc2D location;

	/** World this entity is in */
	protected World world;

	/** Constructs a new entity */
	protected Entity(World w)
	{
		this.world = w;
	}

	/**
	 * Updates this entity
	 * 
	 * @param o
	 *            The issuer of the update
	 * @param arg
	 *            Some additional argument
	 */
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
	public abstract Size2D getSize();

	/**
	 * Returns a bounding box for this entity
	 * 
	 * @return A new vounding box for this entity
	 */
	public EntityBB getBounds()
	{
		return new EntityBB(this);
	}

	/**
	 * Returns true if this entity shall be removed on next tick
	 * 
	 * @return true if this entity shall be removed on next tick
	 */
	public boolean shouldRemove()
	{
		return remove;
	}

	/**
	 * Sets whether this entity should be removed on next tick
	 * 
	 * @param remove
	 *            true if entity should be removed
	 */
	public void remove(boolean remove)
	{
		this.remove = remove;
	}

	/**
	 * Defines whether this entity is solid (can it collide with other
	 * entities?)
	 * 
	 * @return true if entity is solid
	 */
	public abstract boolean isSolid();

	/**
	 * Returns all solid entities colliding with this entity
	 * 
	 * @param delta
	 *            Vec2D to translate the position of this entity by before
	 *            checking for collisions
	 * @return a list of colliding entities
	 */
	public List<Entity> getCollidingEntities(Vec2D delta)
	{
		List<Entity> entities = new ArrayList<>();
		synchronized(this.world)
		{
			for(Entity e : this.world.getAllEntities())
			{
				if(this == e || !e.isSolid()) continue;
				BoundingBox bb = e.getBounds();
				Loc2D[] corners = getBounds().getCorners();
				for(Loc2D corner : corners)
				{
					if(bb.contains(corner.clone().add(delta)))
					{
						entities.add(e);
						break;
					}
				}
			}
		}
		return entities;
	}

	/**
	 * Defines whether this entity can be rendered
	 * 
	 * @return true if this entity should be rendered
	 */
	public abstract boolean visible();
}
