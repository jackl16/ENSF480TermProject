package Views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;

import GUI.Button;
import GUI.Component;
import GUI.Text;
import Main.Application;

public class ManagerView extends JPanel {
    private ArrayList<Component> c;

    public ManagerView(Button logout) {
        c = new ArrayList<Component>();
        setLayout(null);

        logout.setLocationSize(10, 10, 95, 40);
        c.add(logout);
        //add(new JLabel("Manager"));
        viewManager();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void viewManager() {
        for (int i = 0; i < c.size(); i++) {
            c.get(i).draw(this);
        }
    }
}
