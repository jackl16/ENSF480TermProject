package Views;

import java.util.ArrayList;
import javax.swing.JPanel;
import GUI.Button;
import GUI.Component;
import java.awt.Dimension;

public class LandlordView extends JPanel {
    private ArrayList<Component> c;

    public LandlordView(Button logout) {
        c = new ArrayList<Component>();
        setLayout(null);

        logout.setLocationSize(10, 10, 95, 40);
        c.add(logout);

        viewLandlord();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void viewLandlord() {
        for (int i = 0; i < c.size(); i++) {
            c.get(i).draw(this);
        }
    }
}
