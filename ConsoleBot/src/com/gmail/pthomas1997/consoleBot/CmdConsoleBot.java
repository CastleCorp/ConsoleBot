package com.gmail.pthomas1997.consoleBot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;




public class CmdConsoleBot implements CommandExecutor {

	public ConsoleBot plugin;
	public CmdConsoleBot(ConsoleBot plugin){
		this.plugin = plugin;
	}

	public Responder responder;
	public CmdConsoleBot(Responder responder){
		this.responder = responder;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

		if( sender.hasPermission("consolebot.use") ) {
			if( args.length !=0) {
				if( args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("--help") ) {
					plugin.Msg(sender, "ConsoleBot is a chat robot that");
					plugin.Msg(sender, "will talk to you, using keywords from your messages to it.");
					plugin.Msg(sender, "ConsoleBot also can do things for you, like gracefully shutdown the server.");
					plugin.Msg(sender, "ConsoleBot can be named, configured, and much more.");
					plugin.Msg(sender, "There is a full suite of permissions to control who can use ConsoleBot.");
					plugin.Msg(sender, "To view more help, use"+ChatColor.RED+" /consolebot help <topic>");
					plugin.Msg(sender, "Available help topics are:");
					plugin.Msg(sender, ChatColor.WHITE+" - "+ChatColor.AQUA+"commands");
					plugin.Msg(sender, ChatColor.WHITE+" - "+ChatColor.AQUA+"keywords");

				} else if( args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("keywords") ) {
					plugin.Msg(sender, "ConsoleBot Help Topic: Keyword List");
					plugin.Msg(sender, "This is the list of keywords that ConsoleBot will recognize.");
					plugin.Msg(sender, responder.printList());
					plugin.Msg(sender, "###End Help Topic###");
					
				} else if(args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("commands")) {
					plugin.Msg(sender, "ConsoleBot Help Topic: Commands List");
					plugin.Msg(sender, "/consolebot [help] [topic] - View the help page, or specific topics.");
					plugin.Msg(sender, "/consolebot chat - Start chatting with the ConsoleBot.");
					plugin.Msg(sender, "/consolebot list - View all of the keywords that the bot recognizes.");
					plugin.Msg(sender, "###End Topic Help###");

				} else {
					plugin.Msg(sender, ChatColor.RED+"###ConsoleBot V"+plugin.version+"###");
					plugin.Msg(sender, "");
					plugin.Msg(sender, "Available commands are:");
					plugin.Msg(sender, "/consolebot help [topic]");
					plugin.Msg(sender, "/consolebot chat");
					plugin.Msg(sender, "/consolebot list");
					plugin.Msg(sender, "For more info on commands, do /consolebot help commands");
					plugin.Msg(sender, "###End###");

				}
				return true;
				
			}
		}
		return false;

	}
}


