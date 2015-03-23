package net.gammas.lasers.utils;

import java.util.Random;

import net.gammas.lasers.Game;
import net.gammas.lasers.objects.EnemyFighter;
import net.gammas.lasers.objects.PlayerFighter;

public class ObjectList
{
	Random random = new Random();

	public ObjectList(Handler handler)
	{
		handler.addObject(new PlayerFighter(Game.WIDTH * Game.SCALE / 2 + 32, Game.HEIGHT * Game.SCALE / 2 + 32, handler));
		handler.addObject(new EnemyFighter(1180, 360, handler));
	}
}
