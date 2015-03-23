package net.gammas.lasers.display;

import java.util.Random;

public class Screen
{
	private int WIDTH, HEIGHT;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random;

	public Screen(int width, int height)
	{
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[width * height];
		random = new Random();

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++)
		{
			tiles[i] = 0xffffff * random.nextInt();
		}
	}

	public void clear()
	{
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = 0;
		}
	}

	public void render(int xOffset, int yOffset)
	{
		for (int y = 0; y < HEIGHT; y++)
		{
			int yy = y + yOffset;
			// if (yy < 0 || yy >= HEIGHT) return;
			for (int x = 0; x < WIDTH; x++)
			{
				int xx = x + xOffset;
				// if (xx < 0 || xx >= WIDTH) return;
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				pixels[x + y * WIDTH] = tiles[tileIndex];
			}
		}
	}
}
