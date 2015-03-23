package net.gammas.lasers.objects.base;

import net.gammas.lasers.utils.Handler;
import net.gammas.lasers.utils.ID;

public abstract class LivingEntity extends Entity
{

	public LivingEntity(int x, int y, int xSize, int ySize, int maxSpeed, int health, int shield, ID id, String image, Handler handler)
	{
		super(x, y, xSize, ySize, maxSpeed, id, image, handler);
	}

}
