import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.ServerSocket;


public class Binder_Stub implements Binder{

	
	// define a socket field
  	Socket socket;
  	// define an ObjectOutputStream
	ObjectOutputStream o;
	// define an ObjectInputStream
	ObjectInputStream i; 
	// This is the contructor of Person_Stub object. 
	public Binder_Stub() throws Exception{ 
             
	}

	

	public RemoteObjectReference lookup(String argument){
		RemoteObjectReference remoteReference = new RemoteObjectReference();
		try{
			// create a socket that is binded to the port 9000  
            // it only communicates with server identified with "localhost"
     	    socket = new Socket("localhost",9000);
            // wrapp the outputstream object into ObjectOutputStream 
		    o = new ObjectOutputStream(socket.getOutputStream());
		    RequestReplyMessage requestMsg = new RequestReplyMessage();

		    requestMsg.setArguments("lookup".getBytes());
		    o.writeObject(requestMsg);
		    o.writeObject(argument);
            // flush the buffer
     	    o.flush();
            // create a new ObjectInputStream wrapping InputStream object
		    i = new ObjectInputStream(socket.getInputStream());
            // read an integer from the response and store the value into integer ret
		    RequestReplyMessage replyMsg = (RequestReplyMessage)i.readObject();
		    remoteReference = replyMsg.getRemoteObjectReference();
            // close the socket
		    socket.close();
		    // return the integer from the server
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
		    return remoteReference;
            
	}
	public void bind(String argument, RemoteObjectReference remoteReference){
		try{
			// create a socket that is binded to the port 9000  
            // it only communicates with server identified with "localhost"
     	    socket = new Socket("localhost",9090);
            // wrapp the outputstream object into ObjectOutputStream 
		    o = new ObjectOutputStream(socket.getOutputStream());
		    RequestReplyMessage requestMsg = new RequestReplyMessage();
		    requestMsg.setArguments("bind".getBytes());//???
		    o.writeObject(requestMsg);
		    o.writeObject(argument);
            // flush the buffer
     	    o.flush();
     	    socket.close();

		}
		catch(Exception e){
			e.printStackTrace();
		}
		    
      //       // create a new ObjectInputStream wrapping InputStream object
		    // i = new ObjectInputStream(socket.getInputStream());
      //       // read an integer from the response and store the value into integer ret
		    // RequestReplyMessage replyMsg = (RequestReplyMessage)i.readObject();
		    // RemoteObjectReference remoteReference = replyMsg.getRemoteObjectReference();
      //       // close the socket
		    // socket.close();
            // return the integer from the server
            //return remoteReference;
	}
}