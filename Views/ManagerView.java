package Views;

import GUI.Button;
import GUI.Text;
import Main.Application;

public class ManagerView {
    public void viewManager() {
        Application.t.clear();
        Application.t.add(new Text("YO MV", 60, 80));
        Application.t.add(new Text("YO MV2", 100, 80));
        //Button b = new Button(this, "btn lol", 100, 200, 95, 40);
        //b.addActionListener();
       // Application.t[2] = b;
    }
}
