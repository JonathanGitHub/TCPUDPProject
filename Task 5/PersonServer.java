// file: PersonServer.java exists only on the server side
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.ServerSocket;

public class PersonServer{
  	public static void main(String args[]){
  		try{
  			// Create a Person object using UPCAST method 
  			Person p = new Person_Servant("Mike",23);
  			// create a RemoteObjectReference
  			RemoteObjectReference remoteReference = new RemoteObjectReference();
  			// set the Internet_Address as "localhost"
  			byte[] ADD={127,0,0,1};
  			remoteReference.setInternet_Address(ADD);
  			// set the PortNumber as 9000
  			remoteReference.setPortNumber(9000);
  			// set the objectNumber as 0
  			remoteReference.setObjectNumber(0);
  			// create a Binder_Stub object to register remoteReference in the registry
  			Binder b = new Binder_Stub();
  			// define the unique name of this remoteReference to the registry
  			b.bind(p.getName(), remoteReference);
  			// create a Person_Skeleton object which receives a Person param
    		Person_Skeleton ps = new Person_Skeleton(p);
    		// call the method server
			ps.serve();
  		}
  		catch(Exception e){
  			e.printStackTrace();
  		}
  		
  	}
}