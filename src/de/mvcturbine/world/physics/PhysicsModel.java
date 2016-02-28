package de.mvcturbine.world.physics;

import de.mvcturbine.world.entity.Entity;

public abstract class PhysicsModel
{
	protected final Entity entity;

	public PhysicsModel(Entity e)
	{
		this.entity = e;
	}

	public abstract void apply();
}
