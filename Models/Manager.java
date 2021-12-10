package Models;

public class Manager extends User {
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void addProperty(Property p) {
        this.properties.add(p);
    }

    public void printUsername() {
        System.out.println(this.username);
    }
}
