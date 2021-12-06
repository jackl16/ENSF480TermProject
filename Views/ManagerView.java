package Views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;

import GUI.Button;
import GUI.Text;
import Main.Application;

public class ManagerView extends JPanel {

    public ManagerView() {
        setSize(400, 400);
        add(new JLabel("Manager"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void viewManager() {
        
    }
}
