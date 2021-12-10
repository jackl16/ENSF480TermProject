package Views;

import java.util.ArrayList;

import GUI.Button;
import GUI.ButtonObserver;
import GUI.Component;
import Main.Application;


public class RegisteredRenterView extends View {    
    public Button logout;

    public RegisteredRenterView(ButtonObserver o) {
        add(new Button("LogoutBtn", o, "Logout", 0, 0, 1, 95, 40));   
        
        addComponentsToJPanel();
    }
}
