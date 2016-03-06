package de.mvcturbine.ui.render;

import java.awt.image.BufferedImage;

import de.mvcturbine.util.geom.Size2D;

/**
 * Base class for renderers
 * 
 * @author tsys
 *
 */
public abstract class Render
{
	public abstract void render(Object o, BufferedImage img, Size2D scale);
}
