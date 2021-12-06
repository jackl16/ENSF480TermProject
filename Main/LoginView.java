package Main;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Button;
import GUI.Component;
import GUI.TextField;
import GUI.Text;

public class LoginView extends JPanel {
    private ArrayList<Component> c;

    public LoginView(Button b, TextField u, TextField p) {
        c = new ArrayList<Component>();
        setLayout(null);

        b.setLocationSize(100, 200, 95, 40);
        c.add(b);
        u.setLocationSize(100, 50, 70, 30);
        c.add(u);
        c.add(new Text("Username:", 20, 60, 200, 10));
        p.setLocationSize(100, 90, 70, 30);
        c.add(p);
        c.add(new Text("Password:", 20, 100, 200, 10));

        viewLogin();
    }
   
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void viewLogin()
    {
        for (int i = 0; i < c.size(); i++) {
            c.get(i).draw(this);
        }
    }
}
