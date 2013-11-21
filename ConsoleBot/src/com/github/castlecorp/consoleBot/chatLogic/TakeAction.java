package com.github.castlecorp.consoleBot.chatLogic;

import com.github.castlecorp.consoleBot.ConsoleBot;

public class TakeAction {
	
	private ConsoleBot plugin;
	
	public TakeAction(ConsoleBot plugin) {
		this.plugin = plugin;
		
	}
	
	// help action and list action both taken care of in Responder class...
	
	public void helloAction() {
		// say hello (done in Responder class)
		// other things to do?
	}
	
	public void nameAction() {
		// give bot name 
		plugin.getBotName();
	}
	
	public void serverStopSlowAction() {
		// broadcast message saying server going down in 10 seconds, 
			// logging?
			// broadcast countdown (wait 1s in between)
			// broadcast server going down now
				// kickall (reason: server going down)
					// stop server
	}
	
	public void serverStopFastAction() {
		// confirm with player (is this possible?)
			// if yes -> broadcast messaeg server going down now... wait 1s
				// logging?
				// kickall
				// stop server
	}
	

}
