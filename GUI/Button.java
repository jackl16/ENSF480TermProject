package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button implements Component {
    private ButtonObserver o;
    JButton b;
    int x;
    int y;
    int width;
    int height;
    String text;

    public Button(ButtonObserver o, String text) {
        this.o = o;
        this.text = text;
        b = new JButton(text);
    }

    public void addActionListener() {
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                o.buttonPressed(text);
            }
        });
    }

    public void setLocationSize(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        b.setBounds(this.x, this.y, this.width, this.height);
    }

    public JButton getButton() {
        return b;
    }

    public String getButtonText() {
        return text;
    }

    public void draw(JPanel p) {
        p.add(b);
    }
}
