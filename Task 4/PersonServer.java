// file: PersonServer.java exists only on the server side
public class PersonServer{
  	public static void main(String args[]){
  		// Create a Person object using UPCAST method 
  		Person p = new Person_Servant("Mike",23);
  		// create a new Person_Skeleton object which receives a Person param
    	Person_Skeleton ps = new Person_Skeleton(p);
    	// call the method server
		ps.serve();
  	}
}