package de.mvcturbine.world.entity;

import java.util.Observable;

import de.mvcturbine.util.geom.Vec2D;
import de.mvcturbine.world.World;

public class MovingeEntity extends Entity
{
	private Vec2D velocity;

	public MovingeEntity(World w)
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
		super.update(o, arg);
		this.updatePosition();
	}

	protected void updatePosition()
	{
		this.setLocation((this.getLocation().add(this.getVelocity())));
	}
}
