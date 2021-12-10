package GUI;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;  

public class Dropdown implements Component {
    String label;

    int x;
    int y;
    int gridwidth;
    int width;
    int height;

    JComboBox<String> cb;
    String[] choices;

    public Dropdown(String label, String[] c, int x, int y, int gridwidth, int width, int height) {
        this.label = label;
        this.choices = c;
        cb = new JComboBox<String>(this.choices);

        this.x = x;
        this.y = y;
        this.gridwidth = gridwidth;
        this.width = width;
        this.height = height;
        cb.setBounds(this.x, this.y, this.width, this.height);
    }
    
    public String getText() {
        return (String)cb.getSelectedItem();
    }

    public Boolean getBool() {
        if (cb.getSelectedItem().toString().compareTo("true") == 0) {
            return true;
        }
        else if (cb.getSelectedItem().toString().compareTo("false") == 0) {
            return false;
        }

        return false;
    }

    public String getLabel() {
        return this.label;
    }

    public void reset() {
        this.cb.setSelectedIndex(0);
    }

    public void draw(JPanel p) {
        p.add(cb);
    }

    public void draw(JPanel p, GridBagConstraints gbc) {
        if (this.gridwidth == 2) {
            gbc.anchor = GridBagConstraints.CENTER;
        }
        if (this.gridwidth == 1) {
            if (this.x == 0) {
                gbc.anchor = GridBagConstraints.LINE_END;
            } else if (this.x == 1) {
                gbc.anchor = GridBagConstraints.LINE_START;
            }
        }
        gbc.gridwidth = this.gridwidth;
        gbc.gridx = this.x;
        gbc.gridy = this.y;
        p.add(cb, gbc);
    }
}
