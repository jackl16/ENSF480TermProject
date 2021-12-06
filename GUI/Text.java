package GUI;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;

public class Text implements Component {
    int x;
    int y;
    int width;
    int height;
    String text;
    JLabel l;

    public Text(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        l = new JLabel(text);
        l.setBounds(this.x, this.y, this.width, this.height);
    }

    public void draw(JPanel p)
    {
        p.add(l);
    }
}
