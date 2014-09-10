import java.io.*;
import java.util.*;

public class Binder_Servant implements Binder{

	private TreeMap<String, RemoteObjectReference> mapping;
	Binder_Servant(){
		mapping = new TreeMap<String, RemoteObjectReference>();
	}
	public void bind(String argument, RemoteObjectReference remoteReference){
		mapping.put(argument, remoteReference);
	}
	public RemoteObjectReference lookup(String argument){
		return mapping.get(argument);
	}

}