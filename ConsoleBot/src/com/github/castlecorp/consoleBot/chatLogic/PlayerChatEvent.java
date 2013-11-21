package com.github.castlecorp.consoleBot.chatLogic;

import java.awt.List;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.github.castlecorp.consoleBot.ConsoleBot;

public class PlayerChatEvent implements Listener {
	
	
	private Responder responder;
	private ConsoleBot plugin;
	private Conversation convo;
	
	public PlayerChatEvent(ConsoleBot plugin, Responder responder, Conversation convo) {
		this.responder = responder;
		this.plugin = plugin;
		this.convo = convo;
	}

	@EventHandler
	public void playerChatEvent(AsyncPlayerChatEvent e){
		Player player = (Player)e.getPlayer();
		
		String[] msg = e.getMessage().toLowerCase().split(" ");
		List message = (List) Arrays.asList(msg);
		
		e.setCancelled(true);
		
		if( message.equals("bye")) {
			
			String byeLine1 = ChatColor.RED+"[@Bot("+plugin.getBotName()+")] " +ChatColor.WHITE +"Nice talking to you.";
			String byeLine2 = ChatColor.RED+"[@Bot("+plugin.getBotName()+")] " +ChatColor.WHITE +"Goodbye.";
			String byeLineEnd = ChatColor.RED+"[@ConsoleBot("+plugin.getBotName()+")]" +ChatColor.WHITE +"<---" +ChatColor.RED +"End of ConsoleBat Chat Session" +ChatColor.WHITE+"--->"; 
			
			
			player.sendMessage(byeLine1);
			player.sendMessage(byeLine2);
			player.sendMessage(byeLineEnd);
			
			// exit conversation by using conv.endConvo() method
			convo.endConvo();
		
			} else if(!message.equals("bye")) {
				for( int i=0; i < msg.length; i++ ) {
					String tempMsg = msg[i];
					if (responder.map.get(tempMsg) != null)
					{
						String keyValue = responder.map.get(tempMsg);
						player.sendMessage(keyValue);
					}
				}
				
			}
	}
}
