package de.mvcturbine.util.geom;

/**
 * Basic interface for anything representing coordinates in 2d space
 * 
 * @author tsys
 *
 */
public interface DimensionProvider
{
	/**
	 * Returns the x component
	 * 
	 * @return the x component
	 */
	public double getX();

	/**
	 * Returns the y component
	 * 
	 * @return the y component
	 */
	public double getY();
}
