package net.gammas.lasers.objects.base;

import net.gammas.lasers.Game;
import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;

public abstract class Projectile extends Entity
{

	protected int damage, direction;

	public Projectile(int x, int y, int xSize, int ySize, int maxSpeed, int damage, int direction, ID id, String image, Handler handler)
	{
		super(x, y, xSize, ySize, maxSpeed, id, image, handler);
		this.damage = damage;
		this.direction = direction;
	}

	public void tick()
	{

		// --- Directions --- \\
		// --- 1 - Up, 2 - Right, 3 - Down, 4 - Left --- \\

		if (direction == 1)
			velY = -maxSpeed;
		else if (direction == 2)
			velX = maxSpeed;
		else if (direction == 3)
			velY = maxSpeed;
		else if (direction == 4)
			velX = -maxSpeed;
		else
		{
			System.out.println("Projectile at X: " + x + " Y: " + y + " Had An Invalid Direction, And Has Been Removed From The Game!");
			handler.removeObject(this);
		}

		if (x < 0 || x > Game.WIDTH * Game.SCALE || y < 0 || y > Game.HEIGHT * Game.SCALE) handler.removeObject(this);

		x += velX;
		y += velY;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getDirection()
	{
		return direction;
	}

	public void setDirection(int direction)
	{
		this.direction = direction;
	}

}
