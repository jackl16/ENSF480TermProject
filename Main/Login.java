package Main;

import Controllers.DatabaseController;
import GUI.Button;
import GUI.ButtonObserver;
import GUI.TextField;
import Views.LoginView;

public class Login implements ButtonObserver {
    Boolean loggedIn;
    private LoginView view;

    DatabaseController db;

    public Login() {
        db = new DatabaseController();

        view = new LoginView(this);
        loggedIn = false;

        Application.mainPanel.add(view, "login");
    }

    public void buttonPressed(String btn) {
        if (btn.compareTo("Login") == 0) {
            tryLogin();
        } else if (btn.compareTo("Guest") == 0) {
            this.view.reset();
            Application.getRenterController().updateView();
            Application.cardLayout.show(Application.mainPanel, "renter");
        }
    }

    public void tryLogin() {
        if (view.u.getText().compareTo("") != 0 && view.p.getText().compareTo("") != 0) {
            String realPass = db.selectUserPassword(view.u.getText());
            if (realPass.compareTo(view.p.getText()) == 0) {
                loggedIn = true;
                String type = db.selectUserType(view.u.getText());
                System.out.println(type);

                if (type.compareTo("manager") == 0) {
                    this.view.reset();
                    Application.cardLayout.show(Application.mainPanel, "manager");
                } else if (type.compareTo("landlord") == 0) {
                    Application.getLandlordController().loadLandlord(view.u.getText());
                    Application.getLandlordController().updateView();
                    this.view.reset();
                    Application.cardLayout.show(Application.mainPanel, "landlord");
                } else if (type.compareTo("renter") == 0) {
                    this.view.reset();
                    Application.cardLayout.show(Application.mainPanel, "registeredrenter");
                }
            }
        }
    }

    public Boolean loggedIn() {
        return loggedIn;
    }

    public void updateView() {

        Application.cardLayout.show(Application.mainPanel, "login");
    }
}
