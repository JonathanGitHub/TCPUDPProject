import java.net.*;
import java.io.*;
import java.util.*;

public class UDPClient{
    public static void main(String args[]){ 
    	
    		client();
    	
    	
	}
	public static void client(){
		DatagramSocket client = null;
		try{	
			client = new DatagramSocket();
			while(true){
				Scanner reader=new Scanner(System.in);
				String str = null;
				if(reader.hasNextLine()){
					str = reader.nextLine();
				}
				DatagramPacket dataPacket = new DatagramPacket(str.getBytes(),str.length(), 
					InetAddress.getByName("localhost"), 9999);
				client.send(dataPacket);
				byte[] buf = new byte[1024];
				DatagramPacket dataPackettoReceive = new DatagramPacket(buf, 1024);
				client.receive(dataPackettoReceive);
				System.out.println(new String(buf, 0, dataPackettoReceive.getLength()));
			}
			
			//client.close();
		}
		catch(SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } 
        catch(IOException e){
            System.out.println("IO: " + e.getMessage());
        }
        finally{
            if (client != null) {
                client.close();
            }
        }   
		
	}
	
}
