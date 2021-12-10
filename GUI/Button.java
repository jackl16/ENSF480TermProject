package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;  

public class Button implements Component {
    private ButtonObserver o;

    String label;

    JButton b;
    int x;
    int y;
    int gridwidth;
    int width;
    int height;
    String text;

    public Button(String label, ButtonObserver o, String text, int x, int y, int gridwidth, int width, int height) {
        this.label = label;
        this.o = o;
        this.text = text;
        b = new JButton(text);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gridwidth = gridwidth;
        b.setBounds(this.x, this.y, this.width, this.height);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                o.buttonPressed(text);
            }
        });
    }
    
    public JButton getButton() {
        return b;
    }

    public String getButtonText() {
        return text;
    }

    public String getLabel() {
        return label;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void draw(JPanel p) {
        p.add(b);
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
        p.add(b, gbc);
    }
}
