package Controllers;

import java.util.ArrayList;

import GUI.Button;
import GUI.ButtonObserver;
import Main.Application;
import Models.Email;
import Models.Property;
import Models.Renter;
import Views.RenterView;

public class RenterController extends DatabaseController implements ButtonObserver {
    private Renter model;
    private RenterView view;

    Button logout;
    InboxController i;

    public RenterController() {
        this.model = new Renter();
    }

    public ArrayList<Property> search(String type, String numBedrooms, String numBathrooms, String furnished, String quad) {
        return searchProperties(type, numBedrooms, numBathrooms, furnished, quad);
    }

    public void searchProperty(String type, String numBedrooms, String numBathrooms, String furnished, String quad) {
        for (Property x : search(type, numBedrooms, numBathrooms, furnished, quad)) {
            this.model.addProperty(x);
            this.view.addProperty(x);
        }
    }

    public void buttonPressed(String btn) {
        // When the login button is pressed
        if (btn.compareTo(view.findButton("LogoutBtn").getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "login");
        }
        // When the search button is pressed
        else if (btn.compareTo(view.findButton("searchBtn").getButtonText()) == 0) {
            this.view.resetTable();
            int i = 0; // get the last id to add one to
            Property searchP;

            String type;
            String bedrooms;
            String bathrooms;
            String furnished;
            String quad;
            if (view.findDropdown("typeSDD").getText().compareTo("All") == 0) type = "";
            else type = view.findDropdown("typeSDD").getText();
    
            if (view.findTextField("#bedSTF").getText().compareTo("") == 0) bedrooms = "";
            else bedrooms = view.findTextField("#bedSTF").getText();
    
            if (view.findTextField("#bathSTF").getText().compareTo("") == 0) bathrooms = "";
            else bathrooms = view.findTextField("#bathSTF").getText();
    
            if (view.findDropdown("furnishedSDD").getText().compareTo("All") == 0) furnished = "";
            else furnished = view.findDropdown("furnishedSDD").getText();

            if (view.findDropdown("quadrantSDD").getText().compareTo("All") == 0) quad = "";
            else quad = view.findDropdown("quadrantSDD").getText();

            /*
            // Make sure that every input is filled in
            try {
                searchP = new Property(++i,
                        "",
                        view.findDropdown("typeSDD").getText(),
                        view.findTextField("#bedSTF").getInt(),
                        view.findTextField("#bathSTF").getInt(),
                        view.findDropdown("furnsihedSDD").getBool(),
                        view.findDropdown("quadrantSDD").getText(),
                        "active");
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
            */
            searchProperty(type, bedrooms, bathrooms, furnished, quad);
        }
        // Email button
        else if (btn.compareTo(view.findButton("EmailBtn").getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "email");
        }
    }

    public void updateView() {
        this.model.setProperties(new ArrayList<Property>());
        this.view = new RenterView(this, model.getProperties());
        Application.mainPanel.add(this.view, "renter");
        this.i = new InboxController("", "renter");
    }
}
