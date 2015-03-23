package net.gammas.lasers.utils;

import java.awt.Graphics;
import java.util.LinkedList;

import net.gammas.lasers.objects.base.GameObject;

public class Handler
{
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();

	public void tick()
	{
		for (int i = 0; i < objects.size(); i++)
		{
			GameObject tempObject = objects.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics g)
	{

		for (int i = 0; i < objects.size(); i++)
		{
			GameObject tempObject = objects.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(GameObject object)
	{
		objects.add(object);
	}

	public void removeObject(GameObject object)
	{
		objects.remove(object);
	}
}
