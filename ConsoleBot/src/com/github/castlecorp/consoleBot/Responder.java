package com.github.castlecorp.consoleBot;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
/*
 * TODO 
 * - Finish help page.
 * - Add responses.
 */
public class Responder {
	
	Map<String, String> map = new HashMap<String, String>();
	private String keys = "";

	
	private Responder() {
		addResponses();
	}

	private void addResponses() {
		map.put("--help", printHelp());
		map.put("hello", "Hello there!");
		map.put("your name", "My name is @ConsoleBot"+ConsoleBot.getVersion()+", but you can call me "+ConsoleBot.getBotName());
		map.put("--list", printList());
		map.put("stop the server gracefully", ""/* add method to slowly shutdown server */);
		map.put("crash the server", ""/* add method to crash stop the server*/);
	}

	private String printHelp() {
		String beginHelpPage = "###Begin ConsoleBot Help###\n";
		String helpLines = 
				"# Welcome to ConsoleBot "+ConsoleBot.getVersion()+"! #\n"+
						"# To view this page, type "+ChatColor.RED+"/consolebot help"+"\n or, when in a conversation with the bot, type "+ChatColor.RED+"--help"+" #\n"+
						"# For a list of all the things to say to the bot, type "+ChatColor.RED+"/consolebot list"+"/n, or, when in a conversation with the bot, type "+ChatColor.RED+"--list"+" #\n"+
						"# "+" #\n";
		String endHelpPage = "###End ConsoleBot Help###";

		// Return the strings
		return beginHelpPage + helpLines + endHelpPage;
	}

	public String printList() {
		String beginListPage = "###Begin ConsoleBot Keyword List###\n";
		String endListPage = "###End ConsoleBot Keyword List###\n";

		for (Map.Entry<String, String> entry : map.entrySet()) {
			keys  += "- " + entry.getKey()+"\n";
		}
		return ChatColor.WHITE + beginListPage + ChatColor.AQUA + keys + ChatColor.WHITE + endListPage;
	}

}
