package com.github.castlecorp.consoleBot.chatLogic;

import org.bukkit.event.Listener;

import com.github.castlecorp.consoleBot.ConsoleBot;

public class Conversation implements Listener {
	
	@SuppressWarnings("unused")
	private Responder responder;
	@SuppressWarnings("unused")
	private ConsoleBot plugin;
	@SuppressWarnings("unused")
	private PlayerChatEvent chat;
	
	public Conversation( ConsoleBot plugin, Responder responder, PlayerChatEvent chat ) {
		this.plugin = plugin;
		this.responder = responder;
		this.chat = chat;
	}
	
	public void startConvo() {
		
		// start a conversation with the player when cb chat is run
	}
	
	public void endConvo() {
		// end the conversation with the player when they say "bye"
		// do not output text for player, taken care of by PlayerChatEvent
	}

}
