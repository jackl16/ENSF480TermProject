package Models;

import java.util.ArrayList;

public class Inbox {
    String username;
    ArrayList<Email> emails;

    public Inbox(String username, ArrayList<Email> emails) {
        this.username = username;
        this.emails = emails;
    } 

    public void setUsername(String u) {
        this.username = u;
    }

    public String getUsername() {
        return this.username;
    }

    public ArrayList<Email> getEmails() {
        return this.emails;
    }
    
}
