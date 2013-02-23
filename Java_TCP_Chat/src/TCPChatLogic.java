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
	private ServerSocket serverSocket= null;
	private Socket socket= null;
	private Thread prozess=null;
	private BufferedReader inStream = null;
	private PrintWriter outStream = null;
	
	public TCPChatLogic(){
		
	}
	

	@Override
	public void run() {
		
		
	}
	
	public void serverStart() {
		try{
		serverSocket= new ServerSocket(4321);
		socket= serverSocket.accept();
		inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    outStream = new PrintWriter(socket.getOutputStream(), true);
		
		}catch(Exception e){
			e.getMessage();
		}
	}
}
