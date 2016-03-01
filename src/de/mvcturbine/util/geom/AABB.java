package de.mvcturbine.util.geom;

/**
 * A simple rectangular axis aligned bounding box
 * 
 * @author tsys
 *
 */
public class AABB extends BoundingBox
{
	/** Location of this AABB */
	private Loc2D location;

	/** Size of this AABB */
	private Size2D size;

	/** Holds the position of all four corners */
	private Loc2D[] corners = new Loc2D[4];

	/**
	 * Constructs a new AABB
	 * 
	 * @param loc
	 *            Location of the AABB
	 * @param size
	 *            Size of the AABB
	 */
	public AABB(Loc2D loc, Size2D size)
	{
		this.setBoundingBox(loc, size);
	}

	/**
	 * Sets new position and bounds for this AABB
	 * 
	 * @param loc
	 *            Location of the AABB
	 * @param size
	 *            Size of the AABB
	 */
	public void setBoundingBox(Loc2D loc, Size2D size)
	{
		this.location = loc;
		this.size = size;
		this.corners[0] = loc.clone();
		this.corners[1] = loc.clone().add(new Vec2D(size.width, 0));
		this.corners[2] = loc.clone().add(size);
		this.corners[3] = loc.clone().add(new Vec2D(0, size.height));
	}

	@Override
	public Loc2D[] getCorners()
	{
		return corners;
	}

	@Override
	public Loc2D getLocation()
	{
		return location;
	}

	@Override
	public Size2D getSize()
	{
		return size;
	}
}
