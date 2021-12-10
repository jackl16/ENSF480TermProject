package Views;

import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.Dimension;

import GUI.Button;
import GUI.Component;
import GUI.Dropdown;
import GUI.Text;
import GUI.TextArea;
import GUI.TextField;
import Main.Application;

import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;

public class View extends JPanel {
    protected ArrayList<Component> c;

    public View() {
        c = new ArrayList<Component>();
        setLayout(new GridBagLayout());
    }

    @Override
    public Dimension getPreferredSize() {
        setBounds(0, 0, Application.width, Application.height);  
        return new Dimension(Application.width, Application.height);
    }

    public void add(Component c) {
        this.c.add(c);
    }

    public Component findComponent(String label) {
        for (int i = 0; i < c.size(); i++) {
            if (label.compareTo(c.get(i).getLabel()) == 0) {
                return c.get(i);
            }
        }

        return null;
    }

    public Button findButton(String label) {
        return (Button)findComponent(label);
    }

    public TextField findTextField(String label) {
        return (TextField)findComponent(label);
    }

    public Dropdown findDropdown(String label) {
        return (Dropdown)findComponent(label);
    }

    public TextArea findTextArea(String label) {
        return (TextArea)findComponent(label);
    }

    public void setText(String label, String newText) {
        Text t = (Text)findComponent(label);
        t.setText(newText);
    }

    public void addComponentsToJPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.weightx = 0.5;
        for (int i = 0; i < c.size(); i++) {
            c.get(i).draw(this, gbc);
        }
    }
}
