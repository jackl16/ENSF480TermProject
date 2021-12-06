package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

import Controllers.LandlordController;
import Controllers.ManagerController;

public class Application extends JFrame {
    private Login login;
    private ManagerController mangcont;
    private LandlordController landcont;

    public static CardLayout cardLayout;
    public static JPanel mainPanel;

    public Application() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        login = new Login();

        mangcont = new ManagerController();
        landcont = new LandlordController();


        login.updateView();

        add(mainPanel);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
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
        Application app = new Application();
    }
}