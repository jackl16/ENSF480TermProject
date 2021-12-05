package Controllers;

import Models.Manager;
import Views.ManagerView;
import Main.Application;
import Main.Text;

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
