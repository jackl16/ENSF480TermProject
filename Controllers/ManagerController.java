package Controllers;

import Models.Manager;
import Views.ManagerView;
import GUI.Text;
import Main.Application;

public class ManagerController {
    private Manager model;
    private ManagerView view;

    public ManagerController() {
        this.model = new Manager();
        this.view = new ManagerView();
    }

    public void updateView() {
        view.viewManager();
    }
}
