package de.mvcturbine.ui.render;

import java.util.HashMap;

public class RenderRegistry
{
	protected final HashMap<Class<?>, Render> renderRegistry = new HashMap<>();

	public void registerRender(Render renderer, Class<?> type)
	{
		this.renderRegistry.put(type, renderer);
	}

	public Render getRender(Class<?> type)
	{
		while(type != null)
		{
			Render render = this.renderRegistry.get(type);
			if(render != null) return render;
			type = type.getSuperclass();
		}
		return null;
	}
}
