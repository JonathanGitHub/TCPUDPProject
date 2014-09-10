import java.net.*;
import java.io.*;
import java.util.*;

public class TCPServer {
	public static void main (String args[]) {
		server();
	}
	public static void server(){
		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} 
		catch(IOException e) {
			System.out.println("Listen socket:"+e.getMessage());
		}
	}

}

class Connection extends Thread {
	
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
		try {			     
		                                 // an echo server
            Random rnd = new Random();//Returns a ramdom number
			String data = in.readUTF();	                  // read a line of data from the stream
			CaesarCipher cc = new CaesarCipher();
			String approvedData = "The plan to " + data + "has been approved!";
			String rejectedData = "The plan to " + data + "has been rejected!";
			String appr_encry_data = cc.encryption(approvedData);
			String rej_encry_data = cc.encryption(rejectedData);
			if (rnd.nextInt(2) == 0) {
				out.writeUTF(appr_encry_data);
			}
			else{
				out.writeUTF(rej_encry_data);
			}
			
		} catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		
	}
}
