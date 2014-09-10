// file: Person_Stub.java found only on the client side
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
public class Person_Stub implements Person {
	  // define a socket field
  	  Socket socket;
  	  // define an ObjectOutputStream
	  ObjectOutputStream o;
	  // define an ObjectInputStream
	  ObjectInputStream i; 
	  // This is the contructor of Person_Stub object. 
      RemoteObjectReference remoteReference;
	  public Person_Stub() throws Exception {      
	  }
      public Person_Stub(RemoteObjectReference remoteReference) throws Exception{
            this.remoteReference = remoteReference;
      }

   /**
     * This is the method getID of Person_Stub object. 
     * It writes/sends an string "ID" to the server and receives
     * a response from the server, the response is stored
     * in the integer ret. The response is the id in integer format
     * @return integer id (from server)
     */
	  public int getID() throws Exception {
            // create a socket that is binded to the port 9000  
            // it only communicates with server identified with "localhost"
     	    socket = new Socket("localhost",9000);
            // wrapp the outputstream object into ObjectOutputStream 
		    o = new ObjectOutputStream(socket.getOutputStream());
            RequestReplyMessage requestMsg = new RequestReplyMessage();
            requestMsg.setRemoteObjectReference(remoteReference);
            requestMsg.setArguments("ID".getBytes());
            // send the String "ID" to the server
		    o.writeObject(requestMsg);
            // flush the buffer
     	    o.flush();
            // create a new ObjectInputStream wrapping InputStream object
		    i = new ObjectInputStream(socket.getInputStream());
            // read an integer from the response and store the value into integer ret
		    RequestReplyMessage replyMsg  = (RequestReplyMessage)i.readObject();
            int id = Integer.parseInt(new String(replyMsg.getArguments()));
            // close the socket
		    socket.close();
            // return the integer from the server
            return id;
  	}
  	/**
     * This is the method getName of Person_Stub object. 
     * It writes/sends an string "name" to the server and receives
     * a response from the server, the response is stored
     * in the String ret. The response is the name in string format
     * @return String ret (from server)
     */
  	public String getName() throws Exception { 
            // create a socket that is binded to the port 9000  
            // it only communicates with server identified with "localhost"
            socket = new Socket("localhost",9000);
            // wrapp the outputstream object into ObjectOutputStream 
            o = new ObjectOutputStream(socket.getOutputStream());
            RequestReplyMessage requestMsg = new RequestReplyMessage();
            requestMsg.setRemoteObjectReference(remoteReference);
            requestMsg.setArguments("name".getBytes());
            // send the String "ID" to the server
            o.writeObject(requestMsg);
            // flush the buffer
            o.flush();
            // create a new ObjectInputStream wrapping InputStream object
            i = new ObjectInputStream(socket.getInputStream());
            // read an integer from the response and store the value into integer ret
            RequestReplyMessage replyMsg  = (RequestReplyMessage)i.readObject();
            String name = replyMsg.getArguments().toString();
            // close the socket
            socket.close();
            return name;
    }
}   