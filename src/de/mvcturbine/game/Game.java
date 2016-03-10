package de.mvcturbine.game;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Game base class
 * 
 * @author tsys
 *
 */
public abstract class Game extends Observable implements Runnable
{
	/** Thread pool used for tick execution */
	private static ScheduledExecutorService threadPool = Executors
			.newScheduledThreadPool(1);

	/** Thread running the tick updates */
	private Future<?> thread = null;

	/** True if game instance has been initialized */
	private boolean initialized = false;

	/** Number of ticks since game started */
	private long ticks = 0;

	public final Random rand = new Random();

	/**
	 * Tick update handler. Overwrite and call super() in your game
	 * implementation
	 */
	protected void tick()
	{
		this.ticks++;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void run()
	{
		synchronized(this)
		{
			this.tick();
		}
	}

	/**
	 * Initializes this game instance. May only be called once;
	 */
	public void init()
	{
		if(this.initialized) throw new IllegalStateException("Already initialized");
		this.start();
	}

	/**
	 * 
	 * Returns number of game ticks per second
	 * 
	 * @return Number of game ticks per second
	 */
	public abstract int getTPS();

	/**
	 * Starts the game
	 */
	protected void start()
	{
		int msPerTick = 1000 / getTPS();
		this.thread = threadPool.scheduleAtFixedRate(this, msPerTick, msPerTick,
				TimeUnit.MILLISECONDS);
	}

	/**
	 * Stops the game
	 */
	protected void stop()
	{
		this.thread.cancel(true);
		this.thread = null;
	}

	/**
	 * @return the ticks
	 */
	public long getTicks()
	{
		return ticks;
	}
}
