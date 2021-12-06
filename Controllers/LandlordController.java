package Controllers;

import GUI.Button;
import GUI.ButtonObserver;
import Main.Application;
import Models.Landlord;
import Models.Property;
import Views.LandlordView;

public class LandlordController implements ButtonObserver {
    private Landlord model;
    private LandlordView view;
    //private Subscription subscriptions;

    Button logout;

    public LandlordController() {
        this.model = new Landlord();

        logout = new Button(this, "Logout");
        logout.addActionListener();

        this.view = new LandlordView(logout);
        Application.mainPanel.add(this.view, "landlord");
    }

    public void registerProperty(Property property) {

    }

    public void payFee(Property proptery) {
        
    }

    public void changeState(Property property, String state) {

    }

    public void updateView() {

    }

    public void sendEmail(Property prop) {

    }

    public String recvEmail(String address) {
        return null;
    }

    public void buttonPressed(String btn) {
        if (btn.compareTo(logout.getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "login");
        }
    }
}
