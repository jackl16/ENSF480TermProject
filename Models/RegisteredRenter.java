package Models;

public class RegisteredRenter extends Renter {
    private int id;
    private String firstName;
    private String lastName;


    public RegisteredRenter(){
        
    }

    public RegisteredRenter(int id, String firstName, String lastName) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;

    }

    public int getId() {
        return this.id;
     }
  
     public String getFirstName() {
        return this.firstName;
     }
  
     public String getLastName() {
        return this.lastName;
     }

    
}
