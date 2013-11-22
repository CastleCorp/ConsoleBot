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
 
	// THIS FUCKING CLASS...
		// finish interfacing.
			// Responder
			// All the other damn classes...
	// This class is being a bitch...need to figure out how to register and unregister events...uggh. pain in the ass, this one.

	private Responder responder;
	private ConsoleBot plugin;
	private ChatConversation convo;

	public PlayerChatEvent(ConsoleBot plugin, Responder responder, ChatConversation convo) {
		this.responder = responder;
		this.plugin = plugin;
		this.convo = convo;
	}

	@EventHandler
	public void playerChatEvent(AsyncPlayerChatEvent e){


		Player player = (Player)e.getPlayer();

		String prefix = ChatColor.RED+"[@Bot("+plugin.getBotName()+")] ";

		// suppressed for the time begin. Not sure why I made it, but it's here so I'll keep it...
		@SuppressWarnings("unused")
		String prefixEnd = ChatColor.RED+"[@ConsoleBot("+plugin.getBotName()+")] ";

		String[] msg = e.getMessage().toLowerCase().split(" ");
		List message = (List) Arrays.asList(msg);

		e.setCancelled(true);


		boolean finished = false;

		while( finished != true ) {

			e.setCancelled(true);

			if( message.equals("bye")) {

				finished = true;


				// Should I make the beginnings of the messages into variables, or am I good just copying and pasting? FUCK IT! Oh whatever...
				String byeLine1 = ChatColor.RED+"[@Bot("+plugin.getBotName()+")] " +ChatColor.WHITE +"Nice talking to you.";
				String byeLine2 = ChatColor.RED+"[@Bot("+plugin.getBotName()+")] " +ChatColor.WHITE +"Goodbye.";
				String byeLineEnd = ChatColor.RED+"[@ConsoleBot("+plugin.getBotName()+")] " +ChatColor.WHITE +"<---" +ChatColor.RED +"End of ConsoleBat Chat Session" +ChatColor.WHITE+"--->"; 

				// send messages from above
				player.sendMessage(byeLine1);
				player.sendMessage(byeLine2);
				player.sendMessage(byeLineEnd);

				// finish endConvo(). What will it do...?
					convo.endConvo(finished, player);
	
			} else if(!message.equals("bye")) {

				for( int i=0; i < msg.length; i++ ) {
					String tempMsg = msg[i];
					if (responder.map.get(tempMsg) != null)
					{
						String keyValue = responder.map.get(tempMsg);

						player.sendMessage(prefix+keyValue);
						player.sendMessage(prefix +""); 

					}

				} 


			} else {
				
				player.sendMessage(prefix+"I'm sorry, but I couldn't find any keywords in your message..." +
						prefix+"You said:" + ChatColor.WHITE+message +ChatColor.RED+"The keywords are: " +responder.printList());
				
			}


		}
	}
}
