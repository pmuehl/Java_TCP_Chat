package logic;

import java.net.*;
import java.lang.*;
import java.io.*;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * Klasse für die Funktionalität des Multicast- Chats
 * 
 * @author Patrick Muehl
 *
 */
public class ChatLogic {
	private MulticastSocket socket;
	private int port= 6789;
	private InetAddress group;
	private String username;
	private String text_encoding="UTF-8";

	/**
	 * Konstruktor.
	 * Hier wird der Socket gestartet und eine Verbindung aufgebaut
	 * @param username Benutzername des Benutzers, wird im Chat angezeigt
	 */
	public ChatLogic(String username){
		this.username= username;
		try	{
			socket= new MulticastSocket(port);
			group= InetAddress.getByName("224.1.3.5");
			socket.joinGroup(group);
		}catch(IOException e){
			e.printStackTrace();
		}catch(SecurityException e){
			e.printStackTrace();
		}

		JOptionPane.showInputDialog("Gib einen Text ein zum senden!");

		Thread sendThread = new Thread(new sendThread(username));
		sendThread.start();

		Thread recieveThread = new Thread(new recieveThread(socket));
		System.out.println("Thread Recieve gestartet!");
		recieveThread.start();
	}
	/**
	 * Methode zum Senden von Nachrichten 
	 * @param message die vom Benutzer eingegebene Nachricht, welche verschickt wird
	 */

	/**
	 * Methode zum Empfangen von Nachrichten
	 */


	/**
	 * Methode zum Trennen der Verbindung
	 */
	public void disconnect(){
		try{	
			socket.leaveGroup(group);
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}


	/**
	 * Thread zum Senden einer Nachricht
	 * @author Patrick Muehl
	 *
	 */
	public class sendThread implements Runnable{

		String username = null;

		public sendThread(String username){
			this.username = username;

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				sendMessage(JOptionPane.showInputDialog("Gib einen Text zum senden ein!"));
			}
		}

		public void sendMessage(String message){

			byte [] buffer;
			DatagramPacket dp;
			String nachricht= this.username+": "+ message+ "\n";
			buffer= (nachricht).getBytes();
			dp= new DatagramPacket(buffer, buffer.length, group, port);
			try{
				socket.send(dp);
			}catch(IOException e) {
				e.printStackTrace();
			}catch(SecurityException e){
				e.printStackTrace();
			}
			System.out.println(nachricht);
		}
	}
	/**
	 * Thread zum empfangen einer Nachricht
	 * @author Patrick Muehl
	 *
	 */
	public class recieveThread implements Runnable{

		MulticastSocket ms;

		public recieveThread(MulticastSocket ms){
			this.ms = ms;
		}

		@Override
		public void run() {
			while(true) {

				String message="";
				byte[] buffer = null;
				try {
					buffer = new byte[ms.getReceiveBufferSize()];
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DatagramPacket dp= new DatagramPacket(buffer, buffer.length);
				try{
					ms.receive(dp);
					message = new String(dp.getData(),0,dp.getLength(), text_encoding);
					System.out.println(message);
					//				            return message;
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}

	}

}