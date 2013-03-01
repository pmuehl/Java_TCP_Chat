import java.net.*;
import java.lang.*;
import java.io.*;

/**
 * 
 */

/**
 * @author Patrick Mühl
 *
 */
public class TCPChatLogic {
	private MulticastSocket socket;
	private int port= 6789;
	private InetAddress group;
	private String username;


	public TCPChatLogic(String username){
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
	public String receiveMessage(){
		String message="";
		byte buffer[]= new byte[1000];
		DatagramPacket dp= new DatagramPacket(buffer, buffer.length);
		try{			
			socket.receive(dp);
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(SecurityException e){
			e.printStackTrace();
		}
		return message;
	}
	public void disconnect(){
		try{	
			socket.leaveGroup(group);
		}catch(IOException e){
			e.printStackTrace();
		}
	}




}