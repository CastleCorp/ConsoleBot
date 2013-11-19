package com.gmail.pthomas1997consoleBotPlugin;

import java.util.HashMap;

import org.bukkit.ChatColor;
/*
 * TODO 
 * - Finish help page.
 * - Add responses.
 */
public class Responder {
	private HashMap<String, String> responseMap;
	
	public Responder() {
		responseMap = new HashMap<String, String>();
		addResponses();
	}
	
	private void addResponses() {
		responseMap.put("--help", printHelp());
		responseMap.put("hello", "Hello there!");
		responseMap.put("your name", "My name is @ConsoleBot"+ConsoleBotPlugin.getVersion()+", but you can call me "+ConsoleBotPlugin.getBotName());
	}
	
	private String printHelp() {
		String beginHelpPage = "###Begin ConsoleBot Help###\n";
		String helpLines = 
				"# Welcome to ConsoleBot "+ConsoleBotPlugin.getVersion()+"! #\n"+
				"# To view this page, type "+ChatColor.RED+"/consolebot help"+"\n or, when in a conversation with the bot, type "+ChatColor.RED+"--help"+" #\n"+
				"# For a list of all the things to say to the bot, type "+ChatColor.RED+"/consolebot list"+"/n, or, when in a conversation with the bot, type "+ChatColor.RED+"--list"+" #\n"+
				"# "+" #\n";
		String endHelpPage = "###End ConsoleBot Help###";
		
		// Return the strings
		return beginHelpPage + helpLines + endHelpPage;
	}
	
}
