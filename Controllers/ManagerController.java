package Controllers;

import Models.Manager;
import Models.Property;
import Views.ManagerView;
import GUI.Button;
import GUI.ButtonObserver;
import Main.Application;

public class ManagerController implements ButtonObserver {
    private Manager model;
    private ManagerView view;

    Button logout;

    public ManagerController() {
        this.model = new Manager();
        
        logout = new Button(this, "Logout");
        logout.addActionListener();

        this.view = new ManagerView(logout);
        Application.mainPanel.add(this.view, "manager");
    }

    public void changeFee(Property property, double fee) {

    }

    public void changeFeePeriod(Property property, int fee) {
        
    }

    public String getPeriodicalSummary() {
        return null;
    }

    public void changeState(Property property, String state) {

    }

    public String viewDatabase() {
        return null;
    }

    public void buttonPressed(String btn) {
        if (btn.compareTo(logout.getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "login");
        }
    }

    public void updateView() {
        Application.cardLayout.show(Application.mainPanel, "manager");
        view.viewManager();
    }
}
