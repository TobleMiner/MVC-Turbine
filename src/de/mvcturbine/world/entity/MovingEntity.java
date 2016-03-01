package de.mvcturbine.world.entity;

import java.util.Observable;

import de.mvcturbine.util.geom.EntityBB;
import de.mvcturbine.util.geom.Vec2D;
import de.mvcturbine.world.World;

/**
 * This class is based on the {@link Entity} class. It is optimized for entities
 * that move around and maintain some sort of speed that is not directly
 * controlled by player input
 * 
 * @author tsys
 *
 */
public class MovingEntity extends Entity
{
	/** The velovity of this entity */
	private Vec2D velocity;

	/**
	 * Creates a new Moving Entity
	 *
	 * @param w
	 *            The world of the entity
	 */
	public MovingEntity(World w)
	{
		super(w);
	}

	/**
	 * Returns the current velocity of this entity
	 * 
	 * @return the velocity
	 */
	public Vec2D getVelocity()
	{
		return this.velocity;
	}

	/**
	 * Sets the current velocity of this entity
	 * 
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

	/**
	 * Updates the position of this entity by adding the current speed of the
	 * entity to it's position. Called on a tick basis, must compensate for
	 * number of ticks reported by game
	 */
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
