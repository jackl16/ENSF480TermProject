package GUI;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class TextArea implements Component {
    String label;
    int x;
    int y;
    int gridwidth;
    int width;
    int height;
    String text;
    JTextArea ta;

    public TextArea(String label, String text, int x, int y, int gridwidth, int width, int height) {
        this.label = label;
        this.text = text;
        this.x = x;
        this.y = y;
        this.gridwidth = gridwidth;
        this.width = width;
        this.height = height;

        ta = new JTextArea(this.text);
        ta.setBounds(this.x, this.y, this.width, this.height);
        ta.setPreferredSize(new Dimension(this.width, this.height));
    }

    public String getText() {
        return this.ta.getText();
    }

    public String getLabel() {
        return this.label;
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
        p.add(ta, gbc);
    }
}
