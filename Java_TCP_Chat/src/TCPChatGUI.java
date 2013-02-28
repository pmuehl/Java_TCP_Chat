import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Patrick
 *
 */
public class TCPChatGUI extends JPanel {
	private JButton connect;
	private JButton disconnect;
	private JRadioButton server;
	private JRadioButton client;
	private JButton send;
	private JLabel txt;
	private JTextArea message;
	
	
	public TCPChatGUI() {
		connect= new JButton("Connect");
		disconnect= new JButton ("Disconnect");
		send= new JButton("Nachricht schicken");
		txt= new JLabel("");
		message= new JTextArea("Geben sie hier ihre Nachricht ein");
		this.setLayout(new BorderLayout());
		
		ButtonGroup bg = new ButtonGroup();
	    server = new JRadioButton("Server", true);
	    server.setMnemonic(KeyEvent.VK_H);
	    server.setActionCommand("server");

	    client = new JRadioButton("Client", false);
	    client.setMnemonic(KeyEvent.VK_G);
	    client.setActionCommand("client");

	    bg.add(server);
	    bg.add(client);
	    
	}
}
