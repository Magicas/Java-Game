package net.gammas.lasers.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import net.gammas.lasers.objects.base.GameObject;
import net.gammas.lasers.objects.base.LivingEntity;
import net.gammas.lasers.objects.base.Projectile;
import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;

public class EnemyFighter extends LivingEntity
{

	private static String sprite = "enemyShips/Fighter.png";

	// --- Stats --- \\
	private static int health = 10;
	private static int shield = 10;
	private static int speed = 7;
	private static int width = 51;
	private static int height = 35;

	public EnemyFighter(int x, int y, Handler handler)
	{
		super(x, y, width, height, speed, health, shield, ID.EnemyFighter, sprite, handler);
	}

	public void tick()
	{

		velX = -maxSpeed;
		x += velX;

		for (int i = 0; i < handler.objects.size(); i++)
		{
			if (handler.objects.get(i) != this)
			{
				if (handler.objects.get(i).getId() == ID.PlayerLaser)
				{
					Projectile tempObject = (Projectile) handler.objects.get(i);
					if (getBounds().intersects(tempObject.getBounds()))
					{
						if (shield > 0)
						{
							shield -= tempObject.getDamage();
						}
						else
						{
							health -= tempObject.getDamage();
						}
						
						handler.removeObject(tempObject);
						
					}
				}
			}
		}
		
		if (health <= 0)
		{
			handler.removeObject(this);
		}
		
	}

	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.GREEN);
		g2d.draw(getBounds());

		g.drawImage(image, x, y, null);
	}

}
