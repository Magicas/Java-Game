package net.gammas.lasers.objects.base;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;

public abstract class GameObject
{
	protected int x, y, xSize, ySize;
	protected ID id;
	protected File file;
	protected BufferedImage image;
	protected Handler handler;

	public GameObject(int x, int y, int xSize, int ySize, ID id, String image, Handler handler)
	{
		this.x = x;
		this.y = y;
		this.xSize = xSize;
		this.ySize = ySize;
		this.id = id;
		this.file = new File("res/" + image);
		this.handler = handler;
		
		try
		{
			this.image = ImageIO.read(file);
		}
		catch (IOException e)
		{
			System.out.println("Failed To Load Image For: " + id);
		}
	}

	public abstract void tick();

	public abstract void render(Graphics g);
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, xSize, ySize);
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public ID getId()
	{
		return id;
	}

	public void setId(ID id)
	{
		this.id = id;
	}

	public File getImage()
	{
		return file;
	}

	public void setImage(File file)
	{
		this.file = file;
	}

	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}
	
	

}
