package GUI;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;  

public interface Component {
    public void draw(JPanel p, GridBagConstraints gbc);

    public String getLabel();
}
