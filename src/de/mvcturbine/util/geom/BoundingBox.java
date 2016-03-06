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
	 *            Bounding box to test against
	 * @return true if bbs intersect
	 */
	public boolean intersects(BoundingBox bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(bb.contains(corner)) return true;
		}
		return false;
	}

	/**
	 * Returns the number of corners of another bounding box that are inside of
	 * this bounding box
	 * 
	 * @param bb
	 *            The bounding box to check
	 * @return the number of corners
	 */
	public int numberOfIntersectingCorners(BoundingBox bb)
	{
		int i = 0;
		for(Loc2D corner : this.getCorners())
		{
			if(bb.contains(corner)) i++;
		}
		return i;
	}

	/**
	 * Returns true if this bounding box is fully contained in {@code bb}
	 * 
	 * @param bb
	 *            The bounding box to test
	 * @return true if this bounding box is fully contained in {@code bb}
	 */
	public boolean isInside(BoundingBox bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(!bb.contains(corner)) return false;
		}
		return true;
	}

	/**
	 * Returns the edge of {@code bb} this bounding box is colliding with
	 * 
	 * @param bb
	 *            The box to test against
	 * @return The edge
	 */
	@Deprecated
	public Direction getOuterCollidingEdge(BoundingBox bb)
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
		return null;
	}

	/**
	 * Returns the edge of {@code bb} this bounding box is colliding with on the
	 * inside
	 * 
	 * @param bb
	 *            The box to test against
	 * @return The edge
	 */
	@Deprecated
	public Direction getInnerCollidingEdge(BoundingBox bb)
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
		return null;
	}

	/**
	 * Checks of {@code pos} is inside this bounding box
	 * 
	 * @param pos
	 *            Position to test
	 * @return true if {@code pos} is inside this bounding box
	 */
	public boolean contains(Loc2D pos)
	{
		return pos.x >= this.getLocation().x &&
				pos.x <= this.getLocation().x + this.getSize().width &&
				pos.y >= this.getLocation().y &&
				pos.y <= this.getLocation().y + this.getSize().height;
	}

	/**
	 * Gets all corners of this bounding box
	 * 
	 * @return the corners
	 */
	public abstract Loc2D[] getCorners();

	/**
	 * Gets the current location of this bounding box
	 * 
	 * @return the location
	 */
	public abstract Loc2D getLocation();

	/**
	 * Returns the current size of this bounding box
	 * 
	 * @return the size
	 */
	public abstract Size2D getSize();

	/**
	 * Provides a human readable description of this bounding box
	 * 
	 * @return Human readable representation
	 */
	@Override
	public String toString()
	{
		return String.format("%s loc=%s size=%s", this.getClass().getName(),
				this.getLocation().toString(), this.getSize().toString());
	}
}
