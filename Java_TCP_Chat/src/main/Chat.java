package main;

import logic.ChatLogic;
import gui.TCPChatSwtGui;


/**
 * Hauptklasse um alles zu starten
 * @author Patrick Muehl, Stefan Pitirut
 *
 */
public class Chat {
	
	
	public static void main (String [] args){
		//int port= Integer.parseInt(args[0]);
		//port, args[1], args[2]
		new ChatLogic();

	}
}
