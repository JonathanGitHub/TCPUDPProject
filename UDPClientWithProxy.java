import java.net.*;
import java.io.*;
import java.util.*;

public class UDPClientWithProxy{
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
	public static void performSub(){
		int result = 1;
		for (int i = 2; i <= 100; i++ ) {
			result = add(result, i);
		}
		System.out.println("1 - 2 - 3 - ... - 100 = " + result);
    	
	}
	public static void performMul(){
		int result = 1;
		for (int i = 2; i <= 100; i++ ) {
			result = add(result, i);
		}
		System.out.println("1 * 2 * 3 * ... * 100 = " + result);
    	
	}
	public static void performDiv(){
		int result = 1;
		for (int i = 2; i <= 100; i++ ) {
			result = add(result, i);
		}
		System.out.println("1 / 2 / 3 / ... /100 = " + result);
    	
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
			client.receive(dataPackettoReceive);
			result = new String(buf, 0, dataPackettoReceive.getLength());
			client.close();
			
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
	public static int sub(int x, int y){
		String result = null;
		DatagramSocket client = null;
		String str = x + "-" + y;
		try{
			client = new DatagramSocket();
			DatagramPacket dataPacket = new DatagramPacket(str.getBytes(),str.length(), 
				InetAddress.getByName("localhost"), 9999);
			client.send(dataPacket);
			byte[] buf = new byte[1024];
			DatagramPacket dataPackettoReceive = new DatagramPacket(buf, 1024);
			client.receive(dataPackettoReceive);
			result = new String(buf, 0, dataPackettoReceive.getLength());
			client.close();
			
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
    public static int mul(int x, int y){
		String result = null;
		DatagramSocket client = null;
		String str = x + "X" + y;
		try{
			client = new DatagramSocket();
			DatagramPacket dataPacket = new DatagramPacket(str.getBytes(),str.length(), 
				InetAddress.getByName("localhost"), 9999);
			client.send(dataPacket);
			byte[] buf = new byte[1024];
			DatagramPacket dataPackettoReceive = new DatagramPacket(buf, 1024);
			client.receive(dataPackettoReceive);
			result = new String(buf, 0, dataPackettoReceive.getLength());
			client.close();
			
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
	public static int div(int x, int y){
		String result = null;
		DatagramSocket client = null;
		String str = x + "/" + y;
		try{
			client = new DatagramSocket();
			DatagramPacket dataPacket = new DatagramPacket(str.getBytes(),str.length(), 
				InetAddress.getByName("localhost"), 9999);
			client.send(dataPacket);
			byte[] buf = new byte[1024];
			DatagramPacket dataPackettoReceive = new DatagramPacket(buf, 1024);
			client.receive(dataPackettoReceive);
			result = new String(buf, 0, dataPackettoReceive.getLength());
			client.close();
			
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
	public static int exp(int x, int y){
		String result = null;
		DatagramSocket client = null;
		String str = x + "^" + y;
		try{
			client = new DatagramSocket();
			DatagramPacket dataPacket = new DatagramPacket(str.getBytes(),str.length(), 
				InetAddress.getByName("localhost"), 9999);
			client.send(dataPacket);
			byte[] buf = new byte[1024];
			DatagramPacket dataPackettoReceive = new DatagramPacket(buf, 1024);
			client.receive(dataPackettoReceive);
			result = new String(buf, 0, dataPackettoReceive.getLength());
			client.close();
			
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
