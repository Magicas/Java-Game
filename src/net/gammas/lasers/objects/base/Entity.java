package net.gammas.lasers.objects.base;

import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;

public abstract class Entity extends GameObject
{
	protected int velX, velY, maxSpeed;

	public Entity(int x, int y, int xSize, int ySize, int maxSpeed, ID id, String image, Handler handler)
	{
		super(x, y, xSize, ySize, id, image, handler);
		this.maxSpeed = maxSpeed;
	}

	public int getVelX()
	{
		return velX;
	}

	public void setVelX(int velX)
	{
		this.velX = velX;
	}

	public int getVelY()
	{
		return velY;
	}

	public void setVelY(int velY)
	{
		this.velY = velY;
	}

	public int getMaxSpeed()
	{
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed)
	{
		this.maxSpeed = maxSpeed;
	}

}
