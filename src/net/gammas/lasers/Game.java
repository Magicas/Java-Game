package net.gammas.lasers;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import net.gammas.lasers.display.Screen;
import net.gammas.lasers.input.Keyboard;
import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ObjectList;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 320;
	public static int HEIGHT = (WIDTH / 16) * 9;
	public static int SCALE = 4;
	public static String TITLE = "Lasers";

	private Thread thread;
	private JFrame frame;
	private Screen screen;
	private Keyboard key;
	private Handler handler;
	private Random random;
	private ObjectList objectList;

	private boolean running = false;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game()
	{
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);

		handler = new Handler();
		screen = new Screen(WIDTH, HEIGHT);
		frame = new JFrame();
		key = new Keyboard(handler);
		random = new Random();
		objectList = new ObjectList(handler);

		addKeyListener(key);
	}

	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop()
	{
		running = false;
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		final double ns1 = 1000000000.0 / 120.0;
		double delta = 0;
		double delta1 = 0;
		int frames = 0;
		int ticks = 0;

		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			delta1 += (now - lastTime) / ns1;
			lastTime = now;

			while (delta >= 1)
			{
				tick();
				ticks++;
				delta--;
			}
			
			while (delta1 >= 1)
			{
				render();
				frames++;
				delta1--;
			}

			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("TPS: " + ticks + " FPS: " + frames);
				frame.setTitle(TITLE + " | " + "TPS: " + ticks + " FPS: " + frames);
				frames = 0;
				ticks = 0;
			}
		}
	}

	private void tick()
	{
		handler.tick();
	}

	private void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}

		// screen.clear();
		// screen.render(x, y);

		// for (int i = 0; i < pixels.length; i++)
		// {
		// pixels[i] = screen.pixels[i];
		// }

		Graphics g = bs.getDrawGraphics();

		// --- Draw Graphics Start --- \\

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		handler.render(g);

		// --- Draw Graphics End --- \\

		g.dispose();
		bs.show();
	}

	public static void main(String[] args)
	{
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Lasers");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
