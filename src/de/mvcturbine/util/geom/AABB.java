package de.mvcturbine.util.geom;

public class AABB extends BoundingBox
{
	private Loc2D location;
	private Size2D size;
	private Loc2D[] corners = new Loc2D[4];

	protected AABB()
	{

	}

	public AABB(Loc2D loc, Size2D size)
	{
		this.setBoundingBox(loc, size);
	}

	public void setBoundingBox(Loc2D loc, Size2D size)
	{
		this.location = loc;
		this.size = size;
		this.corners[0] = loc.clone();
		this.corners[1] = loc.clone().add(new Vec2D(size.width, 0));
		this.corners[2] = loc.clone().add(new Vec2D(0, size.height));
		this.corners[3] = loc.clone().add(size);
	}

	/**
	 * This test is extremely simplified and works only AND ONLY IF this bb
	 * moves over the bb we are testing against. If two bbs are placed without
	 * any of the corners of the first one being inside the second one the
	 * intersection will NOT be detected!
	 * 
	 * @param bb
	 * @return
	 */
	@Override
	public boolean intersects(BoundingBox bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(bb.contains(corner)) return true;
		}
		return false;
	}

	@Override
	public boolean isInside(BoundingBox bb)
	{
		for(Loc2D corner : this.getCorners())
		{
			if(!bb.contains(corner)) return false;
		}
		return true;
	}

	@Override
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
	@Override
	public Loc2D[] getCorners()
	{
		return corners;
	}

	/**
	 * @return the location
	 */
	@Override
	public Loc2D getLocation()
	{
		return location;
	}

	/**
	 * @return the size
	 */
	@Override
	public Size2D getSize()
	{
		return size;
	}
}
