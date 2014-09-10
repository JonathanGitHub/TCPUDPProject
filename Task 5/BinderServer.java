public class BinderServer{
	public static void main(String args[]){
  		// Create a Person object using UPCAST method 
  		Binder b = new Binder_Servant();
  		// create a new Person_Skeleton object which receives a Person param
    	Binder_Skeleton bs = new Binder_Skeleton(b);
    	// call the method server
		bs.server();
  	}
}