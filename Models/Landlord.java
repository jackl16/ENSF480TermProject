package Models;

import java.util.ArrayList;

public class Landlord extends User {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public Landlord(){
        
    }

    public Landlord(int id, String firstName, String lastName, 
                   String emailAddress) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.emailAddress = emailAddress;

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
  
     public String getEmailAddress() {
        return this.emailAddress;
     }
  
  
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void addProperty(Property p) {
        this.properties.add(p);
    }

    public ArrayList<Property> getProperties() {
        return this.properties;
    }

    public void setProperties(ArrayList<Property> p) {
        this.properties = p;
    }

    public void printUsername() {
        System.out.println(this.username);
    }
}
