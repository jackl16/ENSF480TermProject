package Main;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.ManagerController;
import GUI.Component;
import GUI.Text;

public class Application<E> extends JPanel {
    public static ArrayList<Component> t;
    private JFrame f;
    private Login login;
    private E controller;

    public Application() {
        f = new JFrame("Application");
        t = new ArrayList<Component>();
        Application.t.clear();
        Application.t.add(new Text("YO APP", 60, 80));
        login = new Login();
    }

    public void paintComponent(Graphics g) {
        int fontSize = 10;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int i = 0; i < t.size(); i++) {
                t.get(i).draw(g, f);
        }
    }

    public void setController(E controller) {
        this.controller = controller;
    }

    public E getController() {
        return controller;
    }

    public JFrame getJFrame() {
        return f;
    }

    public Login getLogin() {
        return login;
    }

    public static void main(String[] args) {
        Application<ManagerController> app = new Application<ManagerController>();
        ManagerController temp = new ManagerController();
        app.setController(temp);

        app.getJFrame().getContentPane().add(app);
        app.getJFrame().setSize(400, 400);
        app.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.getJFrame().setLocationRelativeTo(null);
        app.getJFrame().setVisible(true);
        
        app.getLogin().updateView();
    }
}