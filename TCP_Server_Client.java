import java.io.*;
import java.net.*;

public class TCP_Server_Client extends Thread{
	private Socket socket;
	TCP_Server_Client(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try{
			//get outputstream
			OutputStream outputStream = socket.getOutputStream();
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
			InputStream inputStream = socket.getInputStream();
			//outputStream.write("Hello, Welcome! This is Server!".getBytes());
			bufferedOutputStream.write("Hello, Welcome! This is Server!".getBytes());//use buffered stuff when sending big chunk
			//bufferedOutputStream.flush();
			bufferedOutputStream.close();
			byte[] buffer = new byte[1024];
			int length = inputStream.read(buffer);
			System.out.println(new String(buffer, 0, length));

			// outputStream.close();
			// bufferedOutputStream.close();
			inputStream.close();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
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
			ServerSocket serverSocket = new ServerSocket(8888);
			while(true){
				Socket socket = serverSocket.accept();
				new TCP_Server_Client(socket).start();
			}
			
			//get outputstream
			// OutputStream outputStream = socket.getOutputStream();
			// InputStream inputStream = socket.getInputStream();
			// outputStream.write("Hello, Welcome! This is Server!".getBytes());
			// byte[] buffer = new byte[1024];
			// int length = inputStream.read(buffer);
			// System.out.println(new String(buffer, 0, length));
			// outputStream.close();
			// inputStream.close();
			// socket.close();
			//serverSocket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void client(){
		try{
			Socket socket = new Socket(InetAddress.getByName("localhost"), 8888);//or "127.0.0.1" or getByName(null)
			OutputStream outputStream = socket.getOutputStream();
			InputStream inputStream = socket.getInputStream();
			byte[] buffer = new byte[1024];
			int length = inputStream.read(buffer);
			System.out.println(new String(buffer, 0, length));
			outputStream.write("Hello, this is client Jonathan".getBytes());
			outputStream.close();
			inputStream.close();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}