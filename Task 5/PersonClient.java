// file: PersonClient.java exists only on the client side
public class PersonClient {
    public static void main(String args[]) {
      try {
              Binder b = new Binder_Stub();
              RemoteObjectReference remoteReference = b.lookup("Mike");
              Person p = new Person_Stub(remoteReference);
              int id = p.getID();
              System.out.println("ID = " + id);
              String name = p.getName();
              System.out.println("Name " + name + "has ID number " + id);
              // // use UPCAST method to initialize the Person object
              // Person p = new Person_Stub();
              // // return the id of person p
              // int id = p.getID();
              // // print the id 
              // System.out.println("ID = " + id);
              // // return the name of person p
              // String name = p.getName();
              // // print the name and ID number of person p
              // System.out.println(name + " has ID number" + id);
      }
      catch(Exception t) {
          t.printStackTrace();
          System.exit(0);
      }
    } 
}      