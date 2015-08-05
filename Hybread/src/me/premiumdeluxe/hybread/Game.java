package me.premiumdeluxe.hybread;

import me.premiumdeluxe.hybread.gametype.Gametype;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game
{
	Gametype gametype;
	int gameId, pregameId;
	boolean running;
	boolean setup;
	int pregameTime;
	boolean pregame;
	int ticks;

	public Game(Gametype gametype)
	{
		this.gametype = gametype;
		gameId = -1;
		pregameId = -1;
		running = false;
		setup = false;
		pregameTime = 10;
		pregame = false;
		ticks = 0;
	}

	public void start()
	{
		running = true;
		if(setup)
		{
			gametype.load();
			setup = true;
		}
		gameId = Bukkit.getScheduler().scheduleSyncRepeatingTask(HybreadPlugin.getInstance(), new Runnable()
		{
			public void run()
			{
				if(ticks % 20 == 0)
				{
					if(pregameTime >= 0)
					{
						pregame = true;
						pregameTime--;
						if(pregameTime > 0)
						{
							// make a tick to every player
						}
						if(pregameTime == 0)
						{
							// make a final tick to indicate game has started
							pregame = false;
						}
					}
				}
				if(!pregame && ticks % 2 == 0)
				{
					gametype.update();
				}
				if(ticks/20/60 >= gametype.getTimeLimit())
				{
					end("Time limit reached!");
				}
				if(getLeadingScore() > gametype.getScoreLimit())
				{
					end("Score limit reached");
				}
				ticks++;
			}
		}, 0L, 1L);
	}

	public void end(String cause)
	{
		running = false;
		for(Player player : Bukkit.getOnlinePlayers())
		{
			player.sendMessage("Game over!\n\n" + cause + "\n\n Winner: ");
		}
		Bukkit.getScheduler().cancelTask(gameId);
	}
	
	private int getLeadingScore()
	{
		// TODO: return score of team/player that has the lead 
		return 0;
	}
}
