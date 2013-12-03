package com.github.castlecorp.consoleBot.chatLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.github.castlecorp.consoleBot.ConsoleBot;
/*
 * TODO 
 * - Finish help page.
 * - Add responses.
 */
public class Responder {

	private ConsoleBot plugin;
	@SuppressWarnings("unused")
	private TakeAction doAction;
	Map<String, String> map;

	public Responder(ConsoleBot plugin, TakeAction doAction){
		this.plugin = plugin;
		this.doAction = doAction;
		this.map = new HashMap<String, String>();
		addResponses();
	}


	// add action methods from TakeAction to do things on map.get(keyValue) from PlayerChatEvent

	public void addResponses() {
		map.put("--help", printHelp());
		map.put("--list", printList());
		map.put("hello", "Hello there!");
		map.put("your name", "My name is @ConsoleBot"+plugin.getVersion()+", but you can call me "+plugin.getBotName());
		map.put("stop the server gracefully", ""/* add method to slowly shutdown server */);
		map.put("crash the server", ""/* add method to crash stop the server*/);
	}
	
	public void removeResponse(String key, Player senderName){
		String msg = "Removed Keyword: " + key + " and the response that corresponds with it.";
		plugin.Msg(senderName, msg);
		
		map.remove(key);
	}
	
	public void addToResponses(String key, String value, Player senderName) {
		// some shit that helps the reader blah blah blah
		String msg = "Added Keyword: " + key + ", Response: " + value;
		
		plugin.Msg(senderName, msg);
		
		map.put(key, value);
		
		
	}

	private String printHelp() {
		String beginHelpPage = "###Begin ConsoleBot Help###\n";
		String helpLines = 
				"# Welcome to ConsoleBot "+plugin.getVersion()+"! #\n"+
						"# To view this page, type "+ChatColor.RED+"/consolebot help"+"\n or, when in a conversation with the bot, type "+ChatColor.RED+"--help"+" #\n"+
						"# For a list of all the things to say to the bot, type "+ChatColor.RED+"/consolebot list"+"/n, or, when in a conversation with the bot, type "+ChatColor.RED+"--list"+" #\n"+
						"# "+" #\n";
		String endHelpPage = "###End ConsoleBot Help###";

		// Return the strings
		return beginHelpPage + helpLines + endHelpPage;
	}


	public String printList() {
		Set<String> keySet = map.keySet();
		String output = " ";
		for( String s : keySet ) {
			output += s + "\n"; 
		}

		return output;
	}

	
}

