package de.mvcturbine.world;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import de.mvcturbine.game.Game;
import de.mvcturbine.util.geom.AABB;
import de.mvcturbine.util.geom.BoundingBox;
import de.mvcturbine.util.geom.Loc2D;
import de.mvcturbine.util.geom.Size2D;
import de.mvcturbine.world.entity.Entity;

public class World extends Observable implements Observer
{
	protected List<Entity> entityRegistry = new ArrayList<>();
	protected List<Entity> entityRemove = new ArrayList<>();
	protected List<Entity> entityAdd = new ArrayList<>();

	private Game game;

	private Dimension size;
	private AABB bounds;

	public World(Game game, Dimension size)
	{
		this.game = game;
		this.setSize(size);
		game.addObserver(this);
	}

	/**
	 * @return the size
	 */
	public Dimension getSize()
	{
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Dimension size)
	{
		this.size = size;
		this.bounds = new AABB(new Loc2D(), new Size2D(size));
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

	@Override
	public void update(Observable o, Object arg)
	{
		if(o instanceof Game)
		{
			this.tick();
		}
	}

	public void tick()
	{
		this.setChanged();
		this.notifyObservers();
	}

	public List<Entity> getAllEntities()
	{
		return this.entityRegistry;
	}
}
