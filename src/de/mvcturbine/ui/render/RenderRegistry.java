package de.mvcturbine.ui.render;

import java.util.HashMap;

/**
 * Registry for renders. Attaches Renders to objects.
 * 
 * @author tsys
 *
 */
public class RenderRegistry
{
	/** Hash map holds all renders with their entity (base-)class as keys */
	protected final HashMap<Class<?>, Render> renderRegistry = new HashMap<>();

	/**
	 * Registers a render for a class
	 * 
	 * @param renderer
	 *            The render to register
	 * @param type
	 *            The class to use the render for
	 */
	public void registerRender(Render renderer, Class<?> type)
	{
		this.renderRegistry.put(type, renderer);
	}

	/**
	 * Returns the render for a certain class. Also searches the render registry
	 * for renders of base classes of {@code type} if {@code type} doesn't have
	 * any render
	 * 
	 * @param type
	 *            The class to find the render for
	 * @return The render for {@code type}
	 */
	public Render getRender(Class<?> type)
	{
		while(type != null)
		{
			Render render = this.renderRegistry.get(type);
			if(this.renderRegistry.containsKey(type)) return render;
			type = type.getSuperclass();
		}
		return null;
	}
}
