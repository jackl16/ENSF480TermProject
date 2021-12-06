package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextField implements Component {
    int x;
    int y;
    int width;
    int height;
    String text;
    JTextField tf;

    public TextField(String text) {
        this.text = text;
        tf = new JTextField(this.text);
    }

    public void setLocationSize(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        tf.setBounds(this.x, this.y, this.width, this.height);
    }

    public JTextField getTextField() {
        return tf;
    }

    public String getText() {
        return tf.getText();
    }

    public void reset() {
        this.text = "";
        this.tf.setText(this.text);
    }

    public void draw(JPanel p)
    {
        p.add(tf);
    }
}
