// file: PersonClient.java exists only on the client side
public class PersonClient {
    public static void main(String args[]) {
      try {
              // use UPCAST method to initialize the Person object
              Person p = new Person_Stub();
              // return the id of person p
              int id = p.getID();
              // print the id 
              System.out.println("ID = " + id);
              // return the name of person p
              String name = p.getName();
              // print the name and ID number of person p
              System.out.println(name + " has ID number" + id);
      }
      catch(Exception t) {
          t.printStackTrace();
          System.exit(0);
      }
    } 
}      