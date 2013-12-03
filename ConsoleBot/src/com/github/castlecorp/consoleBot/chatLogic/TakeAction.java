package com.github.castlecorp.consoleBot.chatLogic;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.github.castlecorp.consoleBot.ConsoleBot;

public class TakeAction {
	
	private ConsoleBot plugin;
	
	public TakeAction(ConsoleBot plugin) {
		this.plugin = plugin;
		
	}
	
	public void msgAllPlayers(Player[] onlinePlayers, String msg) {
		for(int i = 0; i < onlinePlayers.length; i++){
		onlinePlayers[i].sendMessage(ChatColor.RED+"[@ConsoleBot("+ChatColor.WHITE+plugin.getBotName()+ChatColor.RED+")] "+ChatColor.AQUA+msg);
		}
	}
	
	// help action and list action both taken care of in Responder class...
	
	public void helloAction() {
		// say hello (done in Responder class)
		// other things to do?
		// what the fuck did I want this method to do...? Damn...forgetful...and talking to yourself...about yourself nonetheless...
			// seriously though. this is fucking useless. 
	}
	
	public void nameAction() {
		// give bot name 
		plugin.getBotName();
	}
	
	public void serverStopSlowAction() throws InterruptedException {
		// this had better fucking work...
		
		// broadcast message saying server going down in 10 seconds, 
			// logging?
			// broadcast countdown (wait 1s in between)
			// broadcast server going down now
				// kickall (reason: server going down)
					// stop server
		Player[] onlinePlayers = Bukkit.getOnlinePlayers();
		String prefix = "[@ConsoleBot] ";
		int waitTime = plugin.getDownTimeSlow();
		
		this.msgAllPlayers(onlinePlayers, plugin.getDownMsgSlow());
		
		try {
		TimeUnit.SECONDS.sleep( waitTime );
		} catch( InterruptedException ex ) {
			Thread.currentThread().interrupt();
		}
		
		this.msgAllPlayers(onlinePlayers, plugin.getDownNowMsg());
		for(int i = 0; i < onlinePlayers.length; i++) {
			onlinePlayers[i].kickPlayer(ChatColor.RED+prefix + plugin.getDownKickMsg());
		}
		try {
			TimeUnit.SECONDS.sleep( (long) .25 );
		} catch( InterruptedException ex ) {
			Thread.currentThread().interrupt();
		}
		Bukkit.getServer().shutdown();
	}
	
	public void serverStopFastAction() {
		// confirm with player (is this possible?)
			// if yes -> broadcast message server going down now... wait 1s
				// logging?
				// kickall
				// stop server
	}
	

}
