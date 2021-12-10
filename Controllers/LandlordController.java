package Controllers;

import java.util.ArrayList;

import GUI.ButtonObserver;
import Main.Application;
import Models.Email;
import Models.Landlord;
import Models.Property;
import Views.LandlordView;

public class LandlordController extends DatabaseController implements ButtonObserver {
    private Landlord model;
    private LandlordView view;
    //private Subscription subscriptions;

    InboxController i;

    public LandlordController() {
        this.model = new Landlord();
    }

    public void registerProperty(Property property) {
        this.model.addProperty(property); // adds the property to the model
        addProperty(property, this.model.getUsername()); // adde the property to the db
        this.view.addProperty(property); // adds the property to the view
        this.view.resetRegister();
    }

    public void payFee() {
        int inputid = view.findTextField("feeidTF").getInt();
        String newState = "active";
        changePropertyState(inputid, newState);
        changeState(inputid, newState);
        view.findTextField("feeidTF").reset();
    }

    public void changeState(int id, String state) {
        for (int i = 0; i < this.model.getProperties().size(); i++) {
            if (this.model.getProperties().get(i).getId() == id) {
                this.model.getProperties().get(i).setState(state);
            }
        }

        this.view.updateProperties(this.model.getProperties());
    }

    public void updateView() {
        this.view = new LandlordView(this, model.getProperties());
        Application.mainPanel.add(this.view, "landlord");
    }

    public void sendEmail(Property prop) {

    }

    public ArrayList<Email> recvEmail(String address) {
        return null;
    }

    public void loadLandlord(String username) {
        model.setUsername(username);
        model.setProperties(selectProperties(model.getUsername()));
        this.i = new InboxController(this.model.getUsername(), "landlord");
    }

    public void buttonPressed(String btn) {
        // When the login button is pressed
        if (btn.compareTo(view.findButton("LogoutBtn").getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "login");
        }
        // When the register button is pressed
        else if (btn.compareTo(view.findButton("RegisterBtn").getButtonText()) == 0) {

            int lastId = getLastId(); // get the last id to add one to
            Property newP;

            // Make sure that every input is filled in
            try {
            newP = new Property(++lastId, 
                                view.findTextField("AddressTF").getText(), 
                                view.findDropdown("typeDD").getText(), 
                                view.findTextField("#BedTF").getInt(), 
                                view.findTextField("#BathTF").getInt(), 
                                view.findDropdown("furnishedDD").getBool(), 
                                view.findDropdown("quadrantDD").getText(), "not-posted");
            } catch (Exception e) {
                System.out.println(e);
                return;
            }

            registerProperty(newP);
        }
        // When the pay fee button is pressed
        else if (btn.compareTo(view.findButton("PayfeeBtn").getButtonText()) == 0) {
            try {
                payFee();

            } catch (Exception e) {
                System.out.println(e);
                return;
            }
        }
        // When the state change button is pressed
        else if (btn.compareTo(view.findButton("stateCBtn").getButtonText()) == 0) {
            int inputid = view.findTextField("stateidTF").getInt();
            String s = getPropertyState(inputid);
            // the post has to be posted already
            if (s.compareTo("not-posted") != 0) {
                this.view.setText("stateUpdateText", "");
                String newState = view.findDropdown("stateDD").getText();
                changePropertyState(inputid, newState);
                changeState(inputid, newState);
                view.findTextField("stateidTF").reset();
                view.findDropdown("stateDD").reset();
            } else {
                this.view.setText("stateUpdateText", "Property must be posted first.");
            }
        }
        // When the email button is pressed
        else if (btn.compareTo(view.findButton("EmailBtn").getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "email");
        }
    }
}
