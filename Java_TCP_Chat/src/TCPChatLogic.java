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
public class TCPChatLogic implements Runnable{
	private MulticastSocket socket;
	private int port= 6789;
	
	
	public TCPChatLogic(){
		try	{
			socket= new MulticastSocket(port);
		}catch(IOException e){
			e.getStackTrace();
		}catch(SecurityException e){
			e.getStackTrace();
		}
		
		
	}
	

	@Override
	public void run() {
		
		
	}
	
	public void serverStart() {
	}
}
