package GUI;
import javax.swing.JFrame;
import java.awt.Graphics;

public class Text implements Component {
    int x;
    int y;
    String text;

    public Text(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g, JFrame f)
    {
        g.drawString(this.text, this.x, this.y);
    }
}
