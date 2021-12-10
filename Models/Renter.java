package Models;

import java.util.ArrayList;

public class Renter extends User {
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
