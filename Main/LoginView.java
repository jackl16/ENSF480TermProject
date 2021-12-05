package Main;

import GUI.Button;
import GUI.TextField;
import GUI.Text;

public class LoginView {
    public void viewLogin(Button b, TextField u, TextField p)
    {
        Application.t.clear();
        b.setLocationSize(100, 200, 95, 40);
        Application.t.add(b);
        Application.t.add(new Text("Username:", 20, 60));
        u.setLocationSize(70, 50, 70, 30);
        Application.t.add(u);
        Application.t.add(new Text("Password:", 20, 100));
        p.setLocationSize(70, 90, 70, 30);
        Application.t.add(p);
    }
}
