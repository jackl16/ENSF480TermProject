package Main;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.SwingUtilities;

import Controllers.ManagerController;
import GUI.Component;
import GUI.Text;

public class Application<E> extends JFrame {
    private Login login;
    private E controller;

    public static CardLayout cardLayout;
    public static JPanel mainPanel;

    public Application() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        login = new Login();

        login.updateView();

        add(mainPanel);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void setController(E controller) {
        this.controller = controller;
    }

    public E getController() {
        return controller;
    }

    public JPanel getJPanel() {
        return mainPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public Login getLogin() {
        return login;
    }

    public static void main(String[] args) {
        Application<ManagerController> app = new Application<ManagerController>();
        ManagerController temp = new ManagerController();
        app.setController(temp);
    }
}