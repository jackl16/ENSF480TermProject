package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

import Main.Observer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button implements Component {
    private Observer o;
    JButton b;
    int x;
    int y;
    int width;
    int height;
    String text;

    public Button(Observer o, String text) {
        this.o = o;
        this.text = text;
        b = new JButton(text);
    }

    public void addActionListener() {
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                o.update();
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

    public void draw(Graphics g, JFrame f) {
        f.add(b);
    }
}
