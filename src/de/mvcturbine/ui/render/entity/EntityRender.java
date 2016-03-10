package de.mvcturbine.ui.render.entity;

import java.awt.image.BufferedImage;

import de.mvcturbine.ui.render.Render;
import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.entity.Entity;

public abstract class EntityRender extends Render
{
	@Override
	public void render(Object o, BufferedImage img, Size2D scale)
	{
		Entity e = (Entity) o;
		if(e.visible()) renderEntity(e, img, scale);
	}

	protected abstract void renderEntity(Entity e, BufferedImage img, Size2D scale);
}
