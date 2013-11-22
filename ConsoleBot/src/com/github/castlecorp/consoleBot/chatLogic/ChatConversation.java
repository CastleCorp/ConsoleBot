package com.github.castlecorp.consoleBot.chatLogic;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.github.castlecorp.consoleBot.ConsoleBot;

public class ChatConversation implements Listener {

	private ConsoleBot plugin;
	private PlayerChatEvent chatEvent;
	private Responder responder;

	public ChatConversation(ConsoleBot plugin, PlayerChatEvent chatEvent, Responder responder) {
		this.chatEvent = chatEvent;
		this.plugin = plugin;
		this.responder = responder;


	}

	public void startConvo() {
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerChatEvent(plugin, responder, this), plugin);

	}

	public boolean endConvo(boolean finished, Player player) {
		Player playerName = player;

		if ( finished == true ){
			
			plugin.Msg(playerName, "");
			AsyncPlayerChatEvent.getHandlerList().unregister(chatEvent);
			
			// in some way either unregister playerchatevent or do something else. i don't fucking know.
			return finished;
		}
		return false;
	}


}
