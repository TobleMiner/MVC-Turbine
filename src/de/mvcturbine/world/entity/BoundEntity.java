package de.mvcturbine.world.entity;

import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.World;

public class BoundEntity extends Entity
{
	protected Size2D size;

	public BoundEntity(World w)
	{
		super(w);
	}

	public BoundEntity(World w, Size2D size)
	{
		super(w);
		setSize(size);
	}

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
