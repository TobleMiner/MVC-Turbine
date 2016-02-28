package de.mvcturbine.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import de.mvcturbine.game.Game;
import de.mvcturbine.util.geom.AABB;
import de.mvcturbine.util.geom.BoundingBox;
import de.mvcturbine.util.geom.Loc2D;
import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.entity.Entity;

public class World extends Observable
{
	protected List<Entity> entityRegistry = new ArrayList<>();
	protected List<Entity> entityRemove = new ArrayList<>();
	protected List<Entity> entityAdd = new ArrayList<>();

	private Game game;

	private Size2D size;
	private AABB bounds;

	public World(Game game, Size2D size)
	{
		this.game = game;
		this.setSize(size);
	}

	/**
	 * @return the size
	 */
	public Size2D getSize()
	{
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Size2D size)
	{
		this.size = size;
		this.bounds = new AABB(new Loc2D(), size);
	}

	public BoundingBox getBounds()
	{
		return this.bounds;
	}

	/**
	 * @return the game
	 */
	public Game getGame()
	{
		return game;
	}
}
