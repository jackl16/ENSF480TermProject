package Main;

import Controllers.DatabaseController;
import Controllers.ManagerController;
import GUI.Button;
import GUI.ButtonObserver;
import GUI.TextField;

public class Login implements ButtonObserver {
    Boolean loggedIn;
    private LoginView view;
    Button b;
    TextField u;
    TextField p;
    DatabaseController db;

    public Login() {
        db = new DatabaseController();

        b = new Button(this, "Login");
        b.addActionListener();

        u = new TextField("");
        p = new TextField("");

        view = new LoginView(b, u, p);
        loggedIn = false;

        Application.mainPanel.add(view, "login");
    }

    public void reset() {
        u.reset();
        p.reset();
    }

    public void buttonPressed(String btn) {
        tryLogin();
    }

    public void tryLogin() {
        String realPass = db.selectUserPassword(u.getText());
        if (realPass.compareTo(p.getText()) == 0) {
            loggedIn = true;
            String type = db.selectUserType(u.getText());
            System.out.println(type);

            if (type.compareTo("manager") == 0) {
                reset();
                Application.cardLayout.show(Application.mainPanel, "manager");
            }
            else if (type.compareTo("landlord") == 0) {
                reset();
                Application.cardLayout.show(Application.mainPanel, "landlord");
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
