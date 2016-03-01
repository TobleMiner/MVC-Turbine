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
	public boolean intersects(BoundingBox bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(bb.contains(corner)) return true;
		}
		return false;
	}

	public int numberOfIntersectingCorners(BoundingBox bb)
	{
		int i = 0;
		for(Loc2D corner : this.getCorners())
		{
			if(bb.contains(corner)) i++;
		}
		return i;
	}

	public boolean isInside(BoundingBox bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(!bb.contains(corner)) return false;
		}
		return true;
	}

	public Direction getOuterCollidingFace(BoundingBox bb)
	{
		Loc2D[] corners = this.getCorners();
		for(int i = 0; i < corners.length; i++)
		{
			int j = (i + 1) % corners.length;
			if(bb.contains(corners[i]) && bb.contains(corners[j]))
			{
				return Direction.values()[i];
			}
		}
		System.out.println("Face not found m(");
		return null;
	}

	public Direction getInnerCollidingFace(BoundingBox bb)
	{
		Loc2D[] corners = this.getCorners();
		for(int i = 0; i < corners.length; i++)
		{
			int j = (i + 1) % corners.length;
			if(!bb.contains(corners[i]) && !bb.contains(corners[j]))
			{
				return Direction.values()[i];
			}
		}
		System.out.println("Face not found m(");
		return null;
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

	@Override
	public String toString()
	{
		return String.format("%s loc=%s size=%s", this.getClass().getName(),
				this.getLocation().toString(), this.getSize().toString());
	}
}
