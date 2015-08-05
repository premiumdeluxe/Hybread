package me.premiumdeluxe.hybread.util;

import org.bukkit.entity.Player;

public class Team
{
	String name;
	Player[] members;
	
	public Team(String name, Player[] members)
	{
		this.name = name;
		this.members = members;
	}
}
