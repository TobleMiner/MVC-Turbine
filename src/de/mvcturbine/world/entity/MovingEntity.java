package de.mvcturbine.world.entity;

import java.util.Observable;

import de.mvcturbine.util.geom.EntityBB;
import de.mvcturbine.util.geom.Vec2D;
import de.mvcturbine.world.World;

public class MovingEntity extends Entity
{
	private Vec2D velocity;

	public MovingEntity(World w)
	{
		super(w);
	}

	/**
	 * @return the velocity
	 */
	public Vec2D getVelocity()
	{
		return this.velocity;
	}

	/**
	 * @param velocity
	 *            the velocity to set
	 */
	public void setVelocity(Vec2D velocity)
	{
		this.velocity = velocity;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		Vec2D vec_before = this.getVelocity().clone();
		super.update(o, arg);
		this.updatePosition();
		if(!vec_before.equals(this.getVelocity())) this.updatePosition();
	}

	protected void updatePosition()
	{
		this.setLocation(this.getLocation()
				.add(this.getVelocity().clone().divide(this.world.getGame().getTPS())));
	}

	@Override
	public EntityBB.Moving getBounds()
	{
		return new EntityBB.Moving(this);
	}
}
