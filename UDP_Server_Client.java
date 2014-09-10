import java.io.*;
import java.net.*;

public class UDP_Server_Client{
	public static void main(String[] args){
		if (args.length > 0) {
			server();
		}
		else{
			client();
		}
			

	}
	public static void server(){
		try{
			DatagramSocket server = new DatagramSocket(9999);
			byte[] buf = new byte[1024];
			DatagramPacket dataPacket = new DatagramPacket(buf, 1024);
			server.receive(dataPacket);
			System.out.println(new String(buf, 0, dataPacket.getLength()));
			String str = "Welcome to the UPD Server!";
			DatagramPacket dataPackettoSend = new DatagramPacket(str.getBytes(), str.length(),
				dataPacket.getAddress(), dataPacket.getPort());
			server.send(dataPackettoSend);
			server.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void client(){
		try{
			DatagramSocket client = new DatagramSocket();
			String str = "Hello, this is a message from Jonathan!";
			DatagramPacket dataPacket = new DatagramPacket(str.getBytes(),str.length(), 
				InetAddress.getByName("localhost"), 9999);
			client.send(dataPacket);
			byte[] buf = new byte[1024];
			DatagramPacket dataPackettoReceive = new DatagramPacket(buf, 1024);
			client.receive(dataPackettoReceive);
			System.out.println(new String(buf, 0, dataPackettoReceive.getLength()));
			client.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}