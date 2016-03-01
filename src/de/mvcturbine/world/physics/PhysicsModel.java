package de.mvcturbine.world.physics;

import de.mvcturbine.world.entity.Entity;

/**
 * Base of every physics model
 * 
 * @author tsys
 *
 */
public abstract class PhysicsModel
{
	/** Entity associated with this model */
	protected final Entity entity;

	/**
	 * Creates a new physics model for the Entity {@code e}
	 * 
	 * @param e
	 *            The entity
	 */
	public PhysicsModel(Entity e)
	{
		this.entity = e;
	}

	/**
	 * Performs all necessary alteration to the entity to update its state
	 * according to the physics of this model (e.g. changes velocity)
	 */
	public abstract void apply();
}
