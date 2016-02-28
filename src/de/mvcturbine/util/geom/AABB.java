package de.mvcturbine.util.geom;

public class AABB
{
	private Pos2D location;
	private Size2D size;
	private Pos2D[] corners = new Pos2D[4];

	public AABB(Pos2D loc, Size2D size)
	{
		this.setBoundingBox(loc, size);
	}

	public void setBoundingBox(Pos2D loc, Size2D size)
	{
		this.location = loc;
		this.size = size;
		this.getCorners()[0] = loc.clone();
		this.getCorners()[1] = loc.clone().add(new Vec2D(size.width, 0));
		this.getCorners()[2] = loc.clone().add(new Vec2D(0, size.height));
		this.getCorners()[3] = loc.clone().add(size);
	}

	public boolean intersects(AABB bb)
	{
		if(this.isInside()) return true;

	}

	public boolean isInside(AABB bb)
	{

	}

	/**
	 * @return the corners
	 */
	public Pos2D[] getCorners()
	{
		return corners;
	}
}
