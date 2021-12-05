package Main;

import Controllers.DatabaseController;
import GUI.Button;
import GUI.TextField;
import Controllers.DatabaseController;

public class Login implements Observer {
    private LoginView view;
    Button b;
    TextField u;
    TextField p;
    DatabaseController db;

    public Login() {
        view = new LoginView();
        db = new DatabaseController();

        b = new Button(this, "Login");
        b.addActionListener();

        u = new TextField("");
        p = new TextField("");
    }

    public void update() {
        tryLogin();
    }

    public void tryLogin() {
        db.selectUser();
    }

    public void updateView() {
        view.viewLogin(this.b, this.u, this.p);
    }
}
