package net.gammas.lasers.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import net.gammas.lasers.objects.base.Entity;
import net.gammas.lasers.objects.weapons.Laser;
import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;

public class Keyboard implements KeyListener
{
	public boolean W, A, S, D;

	private Handler handler;

	public Keyboard(Handler handler)
	{
		this.handler = handler;
	}

	public void tick()
	{

	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		for (int i = 0; i < handler.objects.size(); i++)
		{
			Entity tempObject = (Entity) handler.objects.get(i);

			if (tempObject.getId() == ID.PlayerFighter)
			{
				// --- Player Controls Here --- \\
				if (key == KeyEvent.VK_W) tempObject.setVelY(-tempObject.getMaxSpeed());
				if (key == KeyEvent.VK_A) tempObject.setVelX(-tempObject.getMaxSpeed());
				if (key == KeyEvent.VK_S) tempObject.setVelY(tempObject.getMaxSpeed());
				if (key == KeyEvent.VK_D) tempObject.setVelX(tempObject.getMaxSpeed());
				if (key == KeyEvent.VK_SPACE) handler.addObject(new Laser(tempObject.getX() + 35, tempObject.getY() + 13, 32, 1, 60, 3, 2, ID.PlayerLaser, handler));
				if (key == KeyEvent.VK_SPACE) handler.addObject(new Laser(tempObject.getX() + 35, tempObject.getY() + 40, 32, 1, 60, 3, 2, ID.PlayerLaser, handler));
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();

		for (int i = 0; i < handler.objects.size(); i++)
		{
			Entity tempObject = (Entity) handler.objects.get(i);

			if (tempObject.getId() == ID.PlayerFighter)
			{
				// --- Player Controls Here --- \\
				if (key == KeyEvent.VK_W) tempObject.setVelY(0);
				if (key == KeyEvent.VK_A) tempObject.setVelX(0);
				if (key == KeyEvent.VK_S) tempObject.setVelY(0);
				if (key == KeyEvent.VK_D) tempObject.setVelX(0);
			}
		}
	}

	public void keyTyped(KeyEvent e)
	{

	}

}
