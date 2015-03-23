package net.gammas.lasers.utils;

public class MathG
{
	public static int clamp(int i, int min, int max)
	{
		if (i >= max)
			return i = max;
		else if (i <= min)
			return i = min;
		else
			return i;
	}
	
	public static int getDistance(int x1, int y1, int x2, int y2)
	{
		int x = x1 - x2;
		int y = y1 - y2;
		
		if (x < 0) x *= -1;
		if (y < 0) y *= -1;
		
		return (int) Math.sqrt(x^2 + y^2);
	}
}
