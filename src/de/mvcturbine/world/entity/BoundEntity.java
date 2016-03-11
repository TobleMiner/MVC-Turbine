package de.mvcturbine.world.entity;

import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.World;

/**
 * The bound entity is used to construct the bounds of a {@link World}
 * 
 * @author tsys
 *
 */
public class BoundEntity extends Entity
{
	/** The size of this entity */
	protected Size2D size;

	/**
	 * Constructs a new BoundEntity in {@code world}
	 * 
	 * @param w
	 *            The world this bound entity is in
	 */
	public BoundEntity(World w)
	{
		super(w);
	}

	/**
	 * Constructs a new BoundEntity with a specific size in {@code world}
	 * 
	 * @param w
	 *            The world this bound entity is in
	 * @param size
	 *            The size if this bound entity
	 */
	public BoundEntity(World w, Size2D size)
	{
		super(w);
		setSize(size);
	}

	/**
	 * Sets the size
	 * 
	 * @param size
	 *            The size to set
	 */
	public void setSize(Size2D size)
	{
		this.size = size;
	}

	@Override
	public Size2D getSize()
	{
		return this.size;
	}

	@Override
	public boolean isSolid()
	{
		return true;
	}

	@Override
	public boolean visible()
	{
		return false;
	}
}
