package de.mvcturbine.util.geom;

import de.mvcturbine.world.entity.Entity;
import de.mvcturbine.world.entity.MovingEntity;

/**
 * A bounding box representing the bounds of an entity
 * 
 * @author tsys
 *
 */
public class EntityBB extends BoundingBox
{
	/** Entity attached to this bounding box */
	protected final Entity entity;

	/** Creates a new bounding box around {@code e} */
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
		corners[2] = loc.clone().add(size);
		corners[3] = loc.clone().add(new Vec2D(0, size.height));
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

	/**
	 * A bounding box designed to calculate collisions of a moving entity with
	 * some bounding box
	 * 
	 * @author tsys
	 *
	 */
	public static class Moving extends EntityBB
	{
		/**
		 * Creates a new bounding box for a moving entity
		 * 
		 * @param e
		 */
		public Moving(MovingEntity e)
		{
			super(e);
		}

		/**
		 * Calculates the angle of an Entity reflecting of a bounding box
		 * 
		 * @param bb
		 *            The bounding box to collide with
		 * @return The angle
		 */
		public double getCollisionAngle(BoundingBox bb)
		{
			for(Loc2D c : bb.getCorners())
			{
				if(this.contains(c))
				{
					System.out.println("Unhandled corner hit"); // Implementation
																// is not
																// strictly
																// necessary as
																// hitting a
																// corner
																// results
																// in two
																// subsequent
																// calls, one
																// for each edge
				}
			}
			for(Loc2D c : this.getCorners())
			{
				if(!bb.contains(c)) continue;
				MovingEntity e = (MovingEntity) this.entity;
				Line2D velocity = new Line2D(c, e.getVelocity().clone().multiply(-2));
				Loc2D[] bbCorners = bb.getCorners();
				for(int j = 0; j < bbCorners.length; j++)
				{
					int k = (j + 1) % bbCorners.length;
					Line2D edge = new Line2D(bbCorners[j], bbCorners[k]);
					Loc2D poi = edge.intersection(velocity);
					if(poi == null) continue;
					double angleEdge = edge.getDirection().getAngle();
					double angleIn = velocity.getDirection().getAngle() - angleEdge;
					if(angleIn < 0) angleIn += Math.PI;
					return angleEdge - angleIn;
				}
			}
			return Double.NaN;
		}
	}
}
