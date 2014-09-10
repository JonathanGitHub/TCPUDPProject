import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.ServerSocket;


public class Binder_Skeleton{
	private Binder binder;
	public Binder_Skeleton(Binder binder){
		this.binder = binder;
	}
	public void server(){
		try{
			 // create a server socket that binds with the port 9000
          ServerSocket s = new ServerSocket(9090);
          // a while loop, which set the server always listen to any request from client
          while(true) {
               // dispatch a new socket for newly connected client 
              Socket socket = s.accept();
              // create an ObjectInputStream
              ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
              // read what does the client says
              RequestReplyMessage requestMsg = (RequestReplyMessage)i.readObject();

              String method = requestMsg.getArguments().toString();
              // if client says "ID", then return ID value 
              if(method.equals("bind")) {
                  RemoteObjectReference remoteReference = requestMsg.getRemoteObjectReference();
                  String argument = (String)i.readObject();
                  binder.bind(argument, remoteReference);
                  // // create an objectoutputstream
                  // ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                  // RequestReplyMessage replyMsg = new RequestReplyMessage();
                  // replyMsg.setArgument((byte)a);
                  // // send the ID value to the client
                  // o.writeObject(replyMsg);
                  // o.flush();
              } 
              // if client says "name", return name value
              else if(method.equals("lookup")) {
                  String argument = (String)i.readObject();
                  RemoteObjectReference remoteReference = binder.lookup(argument);
                  // create a new ObjectOutputStream
                  ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                  RequestReplyMessage replyMsg = new RequestReplyMessage();
                  replyMsg.setRemoteObjectReference(remoteReference);
                  //replyMsg.setArgument(n.getBytes());
                  // send the value of n, which contains the String value of name to client
                  o.writeObject(replyMsg);
                  o.flush();
              }
              // // dispatch a new socket for newly connected client 
              // Socket socket = s.accept();
              // // create an ObjectInputStream
              // ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
              // // read what does the client says
              // RequestReplyMessage requestReplyMessage = i.readObject();
              // String method = requestReplyMessage.getArguments();
              // RemoteObjectReference remoteReference = requestReplyMessage.getRemoteObjectReference();
              // // if client says "ID", then return ID value 
              // if(method.equals("lookup")) {
              //     // call getID() to return integer value of ID
              //     RemoteObjectReference remoteReference = binder.lookup(method); 
              //     // create an objectoutputstream
              //     ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
              //     // send the ID value to the client
              //     o.writeObject(remoteReference);
              //     o.flush();
              // } 
              // // if client says "name", return name value
              // else if(method.equals("bind")) {
              //     // call getName() method to return the String type value of name
              //     binder.bind(method, remoteReference);
              //     // // create a new ObjectOutputStream
              //     // ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
              //     // // send the value of n, which contains the String value of name to client
              //     // o.writeObject(n);
              //     // o.flush();
              // }
          }

		}
		catch(Exception t){
          System.out.println("Error " + t);
          System.exit(0);
      }
	}
}