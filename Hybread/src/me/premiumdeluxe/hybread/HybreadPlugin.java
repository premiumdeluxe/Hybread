package me.premiumdeluxe.hybread;

import org.bukkit.plugin.java.JavaPlugin;

public class HybreadPlugin extends JavaPlugin
{
	private static final HybreadPlugin instance = new HybreadPlugin();
	
	private HybreadPlugin()
	{}
	
	public void onEnable()
	{
	}
	
	public static HybreadPlugin getInstance()
	{
		return instance;
	}
}
