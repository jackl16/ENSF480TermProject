package Main;

import Controllers.DatabaseController;
import GUI.Button;
import GUI.TextField;

public class Login implements Observer {
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

    public void update() {
        tryLogin();
    }

    public void tryLogin() {
        db.selectUser();
        loggedIn = true;
        Application.cardLayout.show(Application.mainPanel, "manager");
    }

    public Boolean loggedIn() {
        return loggedIn;
    }

    public void updateView() {
        
        Application.cardLayout.show(Application.mainPanel, "login");
    }
}
