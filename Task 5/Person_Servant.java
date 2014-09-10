// file: Person_Servant.java exists only on the server side
public class Person_Servant implements Person {
  	int id;
  	String name;

    /**
     * This is the contructor of Person_Servant object. 
     * @param  n A string represents the name of object
     * @param  i A integer represents the id of object
     * @return N/A
     */

	  public Person_Servant(String n, int i) {
    	 name = n;
    	 id = i;
  	}

    /**
     * This method returns field id of Person_Servant object. 
     * @param  void
     * @return id of the Person_Servant object
     */
	   public int getID() {
    	   return id;
  	 }

    /**
     * This method returns the field name of Person_Servant object. 
     * @param  void
     * @return name of the Person_Servant object
     */
	   public String getName() {
  		  return name;
	   }
}