package de.mvcturbine.ui.render.entity;

import java.awt.image.BufferedImage;

import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.entity.Entity;

public abstract class EntityRender
{
	public void render(Object o, BufferedImage img, Size2D scale)
	{
		renderEntity((Entity) o, img, scale);
	}

	public abstract void renderEntity(Entity e, BufferedImage img, Size2D scale);
}
