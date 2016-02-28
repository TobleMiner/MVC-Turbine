package de.mvcturbine.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import de.mvcturbine.ui.View;

public abstract class Game extends Observable implements Runnable
{
	private static ScheduledExecutorService threadPool = Executors
			.newScheduledThreadPool(1);

	private Future<?> thread = null;

	private boolean initialized = false;

	protected List<View> views = new ArrayList<>();

	protected long ticks = 0;

	protected void tick()
	{
		this.ticks++;
	}

	@Override
	public void run()
	{
		this.tick();
	}

	public void init()
	{
		assert !initialized;
		this.start();
	}

	/**
	 * 
	 * Returns number of game ticks per second
	 * 
	 * @return Number of game ticks per second
	 */
	public abstract int getTPS();

	protected void start()
	{
		int msPerTick = 1000 / getTPS();
		this.thread = threadPool.scheduleAtFixedRate(this, msPerTick, msPerTick,
				TimeUnit.MILLISECONDS);
	}

	protected void stop()
	{
		this.thread.cancel(true);
		this.thread = null;
	}
}
