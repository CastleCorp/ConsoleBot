package com.gmail.pthomas1997consoleBotPlugin;

/*
 * ConsoleBot
 * @author ParkerT
 * @version 0.1
 * <License>
 */

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class ConsoleBotPlugin extends JavaPlugin implements Listener {

	// Declares instance...Don't touch.
	public static ConsoleBotPlugin instance;

	// Gets instance
	public static ConsoleBotPlugin getInstance(){
		return instance;
	}

	/**
	 * void onEnable()
	 * What will happen when the plugin is enabled.
	 * @Override
	 */
	@Override
	public void onEnable() {
		instance = this;

		loadConfiguration();

		// Commands

		// Events

		// Logging

	}

	/**
	 * void onDisable()
	 * What will happen when the plugin is disabled.
	 * It just logs those messages. Again, I was bored.
	 */
	@Override
	public void onDisable() {

		// Do Something...

	}

	/**
	 * void loadConfiguration()
	 * The settings/paths and value pairs for the config.yml file.
	 * Probably shouldn't mess with this unless you know what you are doing...
	 */
	public void loadConfiguration() {

		org.bukkit.configuration.file.FileConfiguration config = getConfig();

		//Paths and Value pairs
		config.addDefault("Version", "V0.1");
		config.addDefault("Bot Name (What it calls itself)", "Jim");
		
		// End path and value pairs

		config.options().copyDefaults(true);

		saveConfig();

	}

	public static String getBotName() {
		return getInstance().getConfig().getString("Bot Name (What it calls itself)");
	}

	public static String getVersion() {
		return getInstance().getConfig().getString("Version");
	}
	
}
