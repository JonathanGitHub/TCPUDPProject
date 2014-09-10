import java.io.*;
import java.util.*;

public class RequestReplyMessage implements Serializable{
	private int messageType;
	private int requestId;
	private RemoteObjectReference remoteReference;
	private int operationId;
	private byte[] arguments;
	RequestReplyMessage(){
		
	}

	RequestReplyMessage(int messageType, int requestId, RemoteObjectReference remoteReference, 
		int operationId, byte[] arguments){
		this.messageType = messageType;
		this.requestId = requestId;
		this.remoteReference = remoteReference;
		this.operationId = operationId;
		this.arguments = arguments;
	}
	public void setMessageType(int messageType){
		this.messageType = messageType;
	}
	public void setRequestId(int requestId){
		this.requestId = requestId;
	}
	public void setRemoteObjectReference(RemoteObjectReference remoteReference){
		this.remoteReference = remoteReference;
	}
	public void setOperationId(int operationId){
		this.operationId = operationId;
	}
	public void setArguments(byte[] arguments){
		this.arguments = arguments;
	}
	public int getMessageType(){
		return messageType;
	}
	public int getRequestId(){
		return requestId;
	}
	public RemoteObjectReference getRemoteObjectReference(){
		return remoteReference;
	}
	public int getOperationId(){
		return operationId;
	}
	public byte[] getArguments(){
		return arguments;
	}
}