import java.net.*;
import java.io.*;
public class TCPClient {
	public static void main (String[] args) {
		client(args);
    }
    public static void client(String[] args){
    	// arguments supply message and hostname
		Socket s = null;
		try{
			int serverPort = 7896;
			int length = args.length;
			s = new Socket(args[length - 1], serverPort);    
			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out =new DataOutputStream( s.getOutputStream());
			StringBuffer sb = new StringBuffer(""); 
			for (int i = 0; i < length - 1; i++) {
				sb.append(args[i] + " ");
			}
			out.writeUTF(sb.toString());      	// UTF is a string encoding see Sn. 4.4
			String data = in.readUTF();	    // read a line of data from the stream
			CaesarCipher cc = new CaesarCipher();
			String decryptedData = cc.decryption(data);
			System.out.println("The encrypted reply from headquarters is: "+ data); 
			System.out.println("The decrypted reply from headquarters is: " +  decryptedData);
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
    }
}
