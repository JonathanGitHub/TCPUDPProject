// file: Person_Skeleton.java exists only on the server side
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.ServerSocket;
public class Person_Skeleton {
    Person myServer;
    /**
     * Constructor of Person_Skeleton
     * @param s A Person object that is used to initialise the field myServer
     * @return N/A
     */
    public Person_Skeleton(Person s){
      myServer = s;
    }
    /**
     * This is the method serve. The serve() method will return a different response to 
     * Person_Stub according to what kind of param the stub has sent to it. For example, if
     * a stub program send "ID" to skeleton, then the skeleton would call the method getID()
     * and return the value of id and send it back to the stub.
     * @param N/A
     * @return void
     */
    public void serve(){   
      try{          
          // create a server socket that binds with the port 9000
          ServerSocket s = new ServerSocket(9000);
          // a while loop, which set the server always listen to any request from client
          while(true) {
              // dispatch a new socket for newly connected client 
              Socket socket = s.accept();
              // create an ObjectInputStream
              ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
              // read what does the stub says
              String method = (String)i.readObject();
              // if stub says "ID", then return ID value 
              if(method.equals("ID")) {
                  // call getID() to return integer value of ID
                  int a = myServer.getID(); 
                  // create an objectoutputstream
                  ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                  // send the ID value to the client
                  o.writeInt(a);
                  o.flush();
              } 
              // if stub says "name", return name value
              else if(method.equals("name")) {
                  // call getName() method to return the String type value of name
                  String n = myServer.getName();
                  // create a new ObjectOutputStream
                  ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                  // send the value of n, which contains the String value of name to client
                  o.writeObject(n);
                  o.flush();
              }
          }
      }
      catch(Exception t){
          System.out.println("Error " + t);
          System.exit(0);
      }
    }
}