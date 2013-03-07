package main;

import gui.TCPChatSwtGui;
import controller.ChatController;

/**
 * 
 * @author Patrick Muehl
 *
 */
public class Chat {
	static ChatController controller;
	
	public static void main (String [] args){
		//controller = new ChatController();
		//controller.showView();
		
		//ChatLogic c = new ChatLogic("Patrick");
		TCPChatSwtGui b = new TCPChatSwtGui();

	}
}
