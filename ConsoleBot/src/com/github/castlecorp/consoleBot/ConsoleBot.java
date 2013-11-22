package com.github.castlecorp.consoleBot;

/*
 * ConsoleBot
 * @author ParkerT
 * @version 0.1
 * Please check out LICENSE.md for information on the use of this repo.
 * Contact me with any questions. I'm active in some of the forums. (Reddit /u/CastleCorp, PMC CastleCorp)
 */

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.castlecorp.consoleBot.chatLogic.ChatConversation;
import com.github.castlecorp.consoleBot.chatLogic.PlayerChatEvent;
import com.github.castlecorp.consoleBot.chatLogic.Responder;
import com.github.castlecorp.consoleBot.chatLogic.TakeAction;

// TODO: 
// - add command to add/remove keys and values for the bot (method call responder.map.put(String, String)
// - add wildcards %playername%, %botname%, etc
// - finish config.yml
// - add comments to config.yml
// - add actions to TakeAction
// FINISH THE MOTHER FUCKING CHAT SYSTEM!
// seriously. DO IT!
// DAMN!


public final class ConsoleBot extends JavaPlugin implements Listener {


	public String version;

	@SuppressWarnings("unused")
	private CmdConsoleBot consoleBot;
	private Responder responder;
	private PlayerChatEvent chatListener;
	private ChatConversation convo;
	private TakeAction doAction;

	public ConsoleBot(){

	}

	public void logger(String msg) {
		getLogger().info("[@ConsoleBot] "+msg);

		getLogger().info("[@ConsoleBot] "+msg);
	}

	public void Msg (CommandSender sender, String msg) {

		if(sender instanceof Player) {
			sender.sendMessage(ChatColor.RED+"[@ConsoleBot("+ChatColor.WHITE+getBotName()+ChatColor.RED+")] "+ChatColor.AQUA+msg);

		} else getLogger().info("[@ConsoleBot("+getBotName()+")]" +msg);
	}

	/**
	 * void onEnable()
	 * What will happen when the plugin is enabled.
	 * @Override
	 */
	@Override
	public void onEnable() {

		this.responder = new Responder(this, doAction);
		this.consoleBot = new CmdConsoleBot(this,responder, convo);
		this.convo = new ChatConversation(this, chatListener, responder);
		this.doAction = new TakeAction(this);
		this.chatListener = new PlayerChatEvent(this, responder, convo);

		loadConfiguration();

		// Commands
		getCommand("consolebot").setExecutor(new CmdConsoleBot(this,responder, convo));

		// Events
		//getServer().getPluginManager().registerEvents(chatListener, this);
		
		

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
		config.addDefault("Server Shutdown (slow) warning", "ATTENTION: The server will be shutting down in %seconds% seconds!");
		config.addDefault("Server Shutdown (slow) wait time", 30);
		config.addDefault("Server shutdown (fast) warning", "ATTENTION: The server is shutting down NOW!");
		config.addDefault("Server Shutdown (fast) wait time", 2);
		config.addDefault("Shutdown message", "Server Shutting Down NOW!");
		config.addDefault("Shutdown Kick Message", "The Server is Shutting Down.");

		// End path and value pairs

		config.options().copyDefaults(true);

		saveConfig();

	}

	public String getDownKickMsg() {
		return this.getConfig().getString("Shutdown Kick Message");
	}

	public String getDownNowMsg() {
		return this.getConfig().getString("Shutdown Message");
	}

	public String getDownMsgSlow() {
		if(this.getConfig().getString("Server Shutdown (slow) warning").contains("%seconds%")) {
			int seconds = this.getConfig().getInt("Server Shutdown (slow) wait time");
			String sec = Integer.toString(seconds);
			return this.getConfig().getString("Server Shutdown (slow) warning").replaceAll("%seconds%", sec);
		} else { return this.getConfig().getString("Server Shutdown (slow) warning");
		}
	}

	public int getDownTimeSlow() {
		return this.getConfig().getInt("Server Shutdown (slow) wait time"); 
	}

	public String getDownMsgFast() {
		return this.getConfig().getString("Server Shutdown (fast) warning");
	}

	public int getDownTimeFast() {
		return this.getConfig().getInt("Server Shutdown (fast) wait time");
	}

	public String getBotName() {
		return this.getConfig().getString("Bot Name (What it calls itself)");
	}

	public String getVersion() {
		return this.getDescription().getVersion();
	}
	
}
