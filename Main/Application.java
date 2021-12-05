package Main;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.ManagerController;

public class Application<E> extends JPanel {
    public static Component t[];
    private Login login;
    private E controller;

    public Application() {
        t = new Component[10];
        Application.t[0] = new Text("YO APP", 60, 80);
    }

    public void paintComponent(Graphics g) {
        int fontSize = 10;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int i = 0; i < t.length; i++) {
            if (t[i] != null)
                t[i].draw(g);
        }
    }

    public void setController(E controller) {
        this.controller = controller;
    }

    public E getController() {
        return controller;
    }

    public static void main(String[] args) {
        Application<ManagerController> app = new Application<ManagerController>();
        ManagerController temp = new ManagerController();
        app.setController(temp);

        JFrame frame = new JFrame("Application");
        frame.getContentPane().add(app);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        app.getController().updateView();
    }
}