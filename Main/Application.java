package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

import Controllers.LandlordController;
import Controllers.ManagerController;
import Controllers.RegisteredRenterController;
import Controllers.RenterController;

public class Application extends JFrame {
    private Login login;
    private ManagerController mangcont;
    private static LandlordController landcont;
    private static RenterController rentcont;
    private RegisteredRenterController regrentcont;

    public static CardLayout cardLayout;
    public static JPanel mainPanel;

    public static int width = 1000;
    public static int height = 700;

    public Application() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        login = new Login();

        mangcont = new ManagerController();
        landcont = new LandlordController();
        rentcont = new RenterController();
        regrentcont = new RegisteredRenterController();


        login.updateView();

        add(mainPanel);
        setSize(width, height);
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

    public static ManagerController getManagerController() {
        return mangcont;
    }


    public static LandlordController getLandlordController() {
        return landcont;
    }

    public static RenterController getRenterController() {
        return rentcont;
    }

    public static void main(String[] args) {
        Application app = new Application();
    }
}