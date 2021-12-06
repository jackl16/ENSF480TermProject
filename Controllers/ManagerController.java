package Controllers;

import Models.Manager;
import Views.ManagerView;
import Main.Application;

public class ManagerController {
    private Manager model;
    private ManagerView view;

    public ManagerController() {
        this.model = new Manager();
        this.view = new ManagerView();

        Application.mainPanel.add(this.view, "manager");
    }

    public void updateView() {
        Application.cardLayout.show(Application.mainPanel, "manager");
        view.viewManager();
    }
}
