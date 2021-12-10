package Views;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Button;
import GUI.ButtonObserver;
import GUI.Component;
import GUI.TextField;
import GUI.Text;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class LoginView extends View {
    public TextField u;
    public TextField p;

    public LoginView(ButtonObserver o) {
        int btnW = 95;
        int btnH = 40;
        int textFieldW = 70;
        int textFieldH = 30;
        int textW = 200;
        int textH = 10;

        add(u = new TextField("usernameTF", "", 1, 0, 1, textFieldW, textFieldH));
        add(new Text("utext", "Username: ", 0, 0, 1, textW, textH));

        add(p = new TextField("passwordTF", "", 1, 1, 1, textFieldW, textFieldH));
        add(new Text("ptext", "Password: ", 0, 1, 1, textW, textH));

        add(new Text("space1", " ", 0, 2, 2, 0, 50)); // SPACE

        add(new Button("LoginBtn", o, "Login", 0, 3, 2, btnW, btnH));
        add(new Text("space2", " ", 0, 4, 2, 0, 50)); // SPACE

        add(new Button("GuestBtn", o, "Guest", 0, 5, 2, btnW, btnH));

        addComponentsToJPanel();
    }

    public void reset() {
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) instanceof TextField) {
                TextField f = (TextField)c.get(i);
                f.reset();
            }
        }
    }
}
