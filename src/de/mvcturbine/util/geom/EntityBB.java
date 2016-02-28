package de.mvcturbine.util.geom;

import de.mvcturbine.world.entity.Entity;

public class EntityBB extends BoundingBox
{
	protected final Entity entity;

	public EntityBB(Entity e)
	{
		this.entity = e;
	}

	@Override
	public Loc2D[] getCorners()
	{
		Loc2D[] corners = new Loc2D[4];
		Loc2D loc = this.entity.getLocation();
		Size2D size = this.entity.getSize();
		corners[0] = loc.clone();
		corners[1] = loc.clone().add(new Vec2D(size.width, 0));
		corners[2] = loc.clone().add(new Vec2D(0, size.height));
		corners[3] = loc.clone().add(size);
		return corners;
	}

	@Override
	public Loc2D getLocation()
	{
		return this.entity.getLocation();
	}

	@Override
	public Size2D getSize()
	{
		return this.entity.getSize();
	}
}
