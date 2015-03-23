package net.gammas.lasers.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import net.gammas.lasers.Game;
import net.gammas.lasers.objects.base.Entity;
import net.gammas.lasers.objects.base.LivingEntity;
import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;
import net.gammas.lasers.utils.MathG;

public class PlayerFighter extends LivingEntity
{

	private static String sprite = "playerShips/Fighter.png";

	// --- Stats --- \\
	private static int health = 35;
	private static int shield = 10;
	private static int speed = 15;
	private static int width = 51;
	private static int height = 54;

	public PlayerFighter(int x, int y, Handler handler)
	{
		super(x, y, width, height, speed, health, shield, ID.PlayerFighter, sprite, handler);
	}

	public void tick()
	{
		x += velX;
		y += velY / 2;

		x = MathG.clamp(x, 0, Game.WIDTH * Game.SCALE - xSize);
		y = MathG.clamp(y, 0, Game.HEIGHT * Game.SCALE - ySize);
	}

	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.GREEN);
		g2d.draw(getBounds());

		g.drawImage(image, x, y, null);
	}

}
