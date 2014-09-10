import java.io.*;
import java.util.*;

public class RemoteObjectReference implements Serializable{
	private byte[] Internet_Address;
	private int portNumber;
	private int time;
	private int objectNumber;
	private String interfaceof_remote_object;
	RemoteObjectReference(){

	}
	RemoteObjectReference(byte[] Internet_Address, int portNumber, int time, int objectNumber, String interfaceof_remote_object){
		this.Internet_Address = Internet_Address;
		this.portNumber = portNumber;
		this.time = time;
		this.objectNumber = objectNumber;
		this.interfaceof_remote_object = interfaceof_remote_object;
	}
	public void setInternet_Address(byte[] Internet_Address){
		this.Internet_Address = Internet_Address;
	}
	public void setPortNumber(int portNumber){
		this.portNumber = portNumber;
	}
	public void setTime(int time){
		this.time = time;
	}
	public void setObjectNumber(int objectNumber){
		this.objectNumber = objectNumber;
	}
	public void setInterfaceof_remote_object(String interfaceof_remote_object){
		this.interfaceof_remote_object = interfaceof_remote_object;
	}
	public byte[] getInternet_Address(){
		return Internet_Address;
	}
	public int getPortNumber(){
		return portNumber;
	}
	public int getOjectNumber(){
		return objectNumber;
	}
	public int getTime(){
		return time;
	}
	public String getInterfaceof_remote_object(){
		return interfaceof_remote_object;
	}
}