package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class TextField implements Component {
    String label;
    int x;
    int y;
    int gridwidth;
    int width;
    int height;
    String text;
    JTextField tf;

    public TextField(String label, String text, int x, int y, int gridwidth, int width, int height) {
        this.label = label;
        this.text = text;
        tf = new JTextField(this.text);

        this.x = x;
        this.y = y;
        this.gridwidth = gridwidth;
        this.width = width;
        this.height = height;
        tf.setBounds(this.x, this.y, this.width, this.height);
        tf.setPreferredSize(new Dimension(this.width, this.height));
    }

    public JTextField getTextField() {
        return tf;
    }

    public String getText() {
        return tf.getText();
    }

    public int getInt() {
        if (tf.getText().compareTo("") != 0) {
            return Integer.valueOf(tf.getText());
        } else {
            return -1;
        }
    }

    public void reset() {
        this.text = "";
        this.tf.setText(this.text);
    }

    public String getLabel() {
        return this.label;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void draw(JPanel p) {
        p.add(tf);
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
        p.add(tf, gbc);
    }
}
