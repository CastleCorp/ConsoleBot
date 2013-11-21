package com.github.castlecorp.consoleBot;

/*
 * ConsoleBot
 * @author ParkerT
 * @version 0.1
 * <License>
 */

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConsoleBot extends JavaPlugin implements Listener {

	public String version;
    private CmdConsoleBot consoleBot;
    private Responder responder;

    public ConsoleBot(){

    }

	public void logger(String msg) {
		getLogger().info("[@ConsoleBot] "+msg);

		getLogger().info("[@ConsoleBot] "+msg);
	}

	public void Msg (CommandSender sender, String msg) {
		if(sender instanceof Player) {

			sender.sendMessage(ChatColor.AQUA+msg);
		}
		else getLogger().info("[@ConsoleBot] " +msg);
	}

	/**
	 * void onEnable()
	 * What will happen when the plugin is enabled.
	 * @Override
	 */
	@Override
	public void onEnable() {

        this.responder = new Responder(this);
        this.consoleBot = new CmdConsoleBot(this,responder);


		loadConfiguration();

		// Commands
		getCommand("consolebot").setExecutor(new CmdConsoleBot(this,responder));

		// Events

		// Logging

		// Other
		version = getDescription().getVersion();
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

	public String getBotName() {
		return this.getConfig().getString("Bot Name (What it calls itself)");
	}

	public String getVersion() {
		return this.getDescription().getVersion();
	}


}
