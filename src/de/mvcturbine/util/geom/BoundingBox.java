package de.mvcturbine.util.geom;

public abstract class BoundingBox
{
	/**
	 * This test is extremely simplified and works only AND ONLY IF this bb
	 * moves over the bb we are testing against. If two bbs are placed without
	 * any of the corners of the first one being inside the second one the
	 * intersection will NOT be detected!
	 * 
	 * @param bb
	 * @return
	 */
	public boolean intersects(AABB bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(bb.contains(corner)) return true;
		}
		return false;
	}

	public boolean isInside(AABB bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(!bb.contains(corner)) return false;
		}
		return true;
	}

	public boolean contains(Loc2D pos)
	{
		return pos.x >= this.getLocation().x &&
				pos.x <= this.getLocation().x + this.getSize().width &&
				pos.y >= this.getLocation().y &&
				pos.y <= this.getLocation().y + this.getSize().height;
	}

	/**
	 * @return the corners
	 */
	public abstract Loc2D[] getCorners();

	/**
	 * @return the location
	 */
	public abstract Loc2D getLocation();

	/**
	 * @return the size
	 */
	public abstract Size2D getSize();
}
