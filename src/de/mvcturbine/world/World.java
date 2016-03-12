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
	/** List of all valid entities */
	protected List<Entity> entityRegistry = new ArrayList<>();

	/** List of entities to remove on next tick */
	private List<Entity> entityRemove = new ArrayList<>();

	/** List of entities to add on next tick */
	private List<Entity> entityAdd = new ArrayList<>();

	/** Game of this world */
	private Game game;

	/** Size of this world */
	private Dimension size;

	/**
	 * Initializes a new world with the given game and size
	 * 
	 * @param game
	 *            The game (you lost)
	 * @param size
	 *            The size of the world
	 */
	public World(Game game, Dimension size)
	{
		this.game = game;
		this.setSize(size);
	}

	/**
	 * Returns the size of the world
	 * 
	 * @return the size
	 */
	public Dimension getSize()
	{
		return size;
	}

	/**
	 * Sets the size of this world
	 * 
	 * @param size
	 *            the size to set
	 */
	public void setSize(Dimension size)
	{
		this.size = size;
	}

	/**
	 * Returns the bounds of this world as a bounding box
	 * 
	 * @return The bounds of this world as a bounding box
	 */
	protected BoundingBox getBounds()
	{
		return new AABB(new Loc2D(), new Size2D(size));
	}

	/**
	 * Returns the game of this world
	 * 
	 * @return the game
	 */
	public Game getGame()
	{
		return game;
	}

	/**
	 * Updates the world state if the update originates from a Game class
	 * 
	 * @param o
	 *            Observable
	 * @param arg
	 *            Argument
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		if(o instanceof Game)
		{
			this.tick();
		}
	}

	/**
	 * Tick method
	 */
	public void tick()
	{
		this.setChanged();
		this.notifyObservers();
		for(Entity e : this.entityRegistry)
		{
			if(e.shouldRemove())
			{
				this.entityRemove.add(e);
				deleteObserver(e);
			}
		}
		synchronized(this)
		{
			this.entityRegistry.removeAll(this.entityRemove);
			this.entityRemove.clear();
			this.entityRegistry.addAll(this.entityAdd);
			for(Entity e : this.entityAdd)
			{
				this.addObserver(e);
			}
			this.entityAdd.clear();
		}
	}

	/**
	 * Returns a list of all entities in this world
	 * 
	 * @return A list of all entities in this world
	 */
	public List<Entity> getAllEntities()
	{
		return this.entityRegistry;
	}

	/**
	 * Adds an entity to this world
	 * 
	 * @param e
	 *            Entity to add
	 */
	synchronized public void addEntity(Entity e)
	{
		this.entityAdd.add(e);
	}

	public void resetWorld()
	{
		synchronized(this.getGame())
		{
			this.entityRegistry.clear();
			this.entityAdd.clear();
			this.entityRemove.clear();
		}
	}

}
