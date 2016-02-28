package de.mvcturbine.util.geom;

import java.awt.Polygon;
import java.awt.Rectangle;

public class ShapeUtil
{

	public static Polygon rectangleToPolygon(Rectangle rect)
	{
		Polygon poly = new Polygon();
		poly.addPoint(rect.x, rect.y);
		poly.addPoint(rect.x + rect.width, rect.y);
		poly.addPoint(rect.x + rect.width, rect.y + rect.height);
		poly.addPoint(rect.x, rect.y + rect.height);
		return poly;
	}
}
