package Controllers;

import GUI.Button;
import GUI.ButtonObserver;
import Main.Application;
import Models.RegisteredRenter;
import Views.RegisteredRenterView;

public class RegisteredRenterController extends RenterController implements ButtonObserver {
    private RegisteredRenter model;
    private RegisteredRenterView view;


    public RegisteredRenterController() {
        this.model = new RegisteredRenter();

        this.view = new RegisteredRenterView(this);
        Application.mainPanel.add(this.view, "registeredrenter");
    }

    public void subscribe(String type, int numBedrooms, int numBathrooms, Boolean furnished, String quadrant) {

    }

    public void buttonPressed(String text) {
        if (text.compareTo(logout.getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "login");
        }
    }

    public void notify(String newListing) {

    }

    public void unsubscribe() {

    }
}
