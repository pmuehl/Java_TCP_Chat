import java.net.*;
import java.lang.*;
import java.io.*;

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
	}
/**
 * Methode zum Senden von Nachrichten 
 * @param message die vom Benutzer eingegebene Nachricht, welche verschickt wird
 */
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
	}
/**
 * Methode zum Empfangen von Nachrichten
 */
	public String receiveMessage(){
		String message="";
		byte[] buffer= new byte[65536];
		DatagramPacket dp= new DatagramPacket(buffer, buffer.length);
		while(true){
			try{
				socket.receive(dp);
	            message = new String(dp.getData(),0,dp.getLength(), text_encoding);
	            return message;
	        }catch(IOException e){
	        	e.printStackTrace();
	        }
		}
		
	}
	
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




}