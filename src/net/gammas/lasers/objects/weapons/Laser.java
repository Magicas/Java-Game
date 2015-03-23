package net.gammas.lasers.objects.weapons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import net.gammas.lasers.objects.base.Projectile;
import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;

public class Laser extends Projectile
{

	private static String sprite = "projectiles/Laser.png";

	public Laser(int x, int y, int xSize, int ySize, int maxSpeed, int damage, int direction, ID id, Handler handler)
	{
		super(x, y, xSize, ySize, maxSpeed, damage, direction, id, sprite, handler);
	}

	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.GREEN);
		g2d.draw(getBounds());
		
		g.drawImage(image, x, y, null);
	}

}
