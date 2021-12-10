package Views;

import java.util.ArrayList;

import GUI.Button;
import GUI.ButtonObserver;
import GUI.Component;
import GUI.Dropdown;
import GUI.List;
import GUI.Text;
import GUI.TextArea;
import GUI.TextField;
import Models.Email;

public class InboxView extends View {
    public InboxView(ButtonObserver o, ArrayList<Email> E, String type) {
        int textW = 200;
        int textH = 10;

        int i = 0;

        // Any type of user except for renter
        if (type.compareTo("renter") != 0) {
            add(new Text("inboxText", "Inbox", 0, i++, 2, textW, textH));
            add(new List(E, "emailsView", 0, i++, 2, 800, 100));

            add(new Text("Space1", " ", 0, i++, 2, 0, 50)); // SPACE

            add(new Text("sendText", "Send Email", 0, i++, 2, textW, textH));
            add(new Text("tosendText", "To: ", 0, i, 1, textW, textH));
            add(new TextField("sendusernameTF", "", 1, i++, 1, 95, 20));
            add(new TextArea("sendcontentTA", "", 0, i++, 2, 400, 200));
            add(new Button("sendBtn", o, "Send Email", 0, i++, 2, 95, 40));

            add(new Text("Space2", " ", 0, i++, 2, 0, 50)); // SPACE

            // Logout btn
            add(new Button("LogoutBtn", o, "Back", 0, i++, 2, 95, 40));
        }
        // Renter view of the inbox
        else {

            add(new Text("contactText", "Contact Landlord", 0, i++, 2, textW, textH));

            add(new Text("namecontactText", "Email: ", 0, i, 1, textW, textH));
            add(new TextField("contactnameTF", "", 1, i++, 1, 95, 20));

            add(new Text("idcontactText", "Property ID: ", 0, i, 1, textW, textH));
            add(new TextField("contactidTF", "", 1, i++, 1, 95, 20));

            add(new TextArea("contactcontentTA", "", 0, i++, 2, 400, 200));
            add(new Button("sendBtn", o, "Send", 0, i++, 2, 95, 40));

            add(new Text("Space2", " ", 0, i++, 2, 0, 50)); // SPACE
            // Logout btn
            add(new Button("LogoutBtn", o, "Back", 0, i++, 2, 95, 40));
        }
        addComponentsToJPanel();
    }

    public void reset() {

    }
}
