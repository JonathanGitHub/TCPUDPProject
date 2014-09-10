public interface Binder{
	public RemoteObjectReference lookup(String argument);
	public void bind(String argument, RemoteObjectReference remoteReference);
}