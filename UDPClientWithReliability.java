import java.net.*;
import java.io.*;
import java.util.*;

public class UDPClientWithReliability{
    public static void main(String args[]){ 
   
    	performAdd();
    	
	}
	public static void performAdd(){
		int result = 1;
		for (int i = 2; i <= 100; i++ ) {
			result = add(result, i);
		}
		System.out.println("1 + 2 + 3 + ... + 100 = " + result);
    	
	}
	public static int add(int x, int y){
		String result = null;
		DatagramSocket client = null;
		String str = x + "+" + y;

		try{
			client = new DatagramSocket();
			DatagramPacket dataPacket = new DatagramPacket(str.getBytes(),str.length(), 
				InetAddress.getByName("localhost"), 9999);
			client.send(dataPacket);
			byte[] buf = new byte[1024];
			DatagramPacket dataPackettoReceive = new DatagramPacket(buf, 1024);
			//while(true){
			// client.setSoTimeout(2000);
			// client.receive(dataPackettoReceive);
            client.setSoTimeout(2000);
			boolean continueSending = true;
			//int counter = 0;
			while(continueSending ){
				//counter ++;
				try{
					client.receive(dataPackettoReceive);
					continueSending = false;
				}
				catch(SocketTimeoutException e){
					System.out.println(e.getMessage());
					client.send(dataPacket);
				}
			}
			result = new String(buf, 0, dataPackettoReceive.getLength());
			client.close();
			
		}
		catch(SocketTimeoutException e){
			System.out.println("Feting data from server is timed out");
			//client.send(dataPacket);
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
		return Integer.parseInt(result);
	}
}
