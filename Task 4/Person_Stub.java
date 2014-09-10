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
	  public Person_Stub() throws Exception {      
	  }

   /**
     * This is the method getID of Person_Stub object. 
     * It writes/sends an string "ID" to the skeleton and receives
     * a response from the skeleton, the response is stored
     * in the integer ret. The response is the id in integer format
     * @return integer id (from server)
     */
	  public int getID() throws Exception {
            // create a socket that is binded to the port 9000  
            // it only communicates with skeleton identified with "localhost"
     	    socket = new Socket("localhost",9000);
            // wrapp the outputstream object into ObjectOutputStream 
		    o = new ObjectOutputStream(socket.getOutputStream());
            // send the String "ID" to the skeleton
		    o.writeObject("ID");
            // flush the buffer
     	    o.flush();
            // create a new ObjectInputStream wrapping InputStream object
		    i = new ObjectInputStream(socket.getInputStream());
            // read an integer from the response and store the value into integer ret
		    int ret = i.readInt();
            // close the socket
		    socket.close();
            // return the integer from the skeleton
            return ret;
  	}
  	/**
     * This is the method getName of Person_Stub object. 
     * It writes/sends an string "name" to the skeleton and receives
     * a response from the skeleton, the response is stored
     * in the String ret. The response is the name in string format
     * @return String ret (from skeleton)
     */
  	public String getName() throws Exception { 
            // create a socket that is binded to the port 9000  
            // it only communicates with skeleton identified with "localhost"
     	    socket = new Socket("localhost",9000);
            // wrapp the outputstream object into ObjectOutputStream 
		    o = new ObjectOutputStream(socket.getOutputStream());
            // send the String "name" to the skeleton
		    o.writeObject("name");
            // in order to avoid "delay" on network, you must use flush method
		    o.flush();
            // create a new ObjectInputStream wrapping InputStream object
		    i = new ObjectInputStream(socket.getInputStream());
            // store the response from the skeleton
		    String ret = (String)(i.readObject());
            // close the socket
		    socket.close();
            // return the response from skeleton
		    return (String)ret;
    }
}   