package Views;

import java.util.ArrayList;

import javax.swing.JPanel;
import GUI.Button;
import GUI.ButtonObserver;
import GUI.Component;
import GUI.Dropdown;
import GUI.List;
import GUI.Text;
import GUI.TextField;
import Main.Application;
import Models.Property;

import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;

import java.awt.Dimension;

public class RenterView extends View {
    public RenterView(ButtonObserver o, ArrayList<Property> p)    {     
        int textW = 200;
        int textH = 10;
        
        int i = 0;

        c.add(new Text("PropText", "Properties", 0, i++, 2, textW, textH));

        c.add(new List("propertiesView", p, 0, i++, 2, 800, 100));

        c.add(new Text("space1", " ", 0, i++, 2, 0, 50)); // SPACE
        c.add(new Text("searchPropText", "Search Property", 0, i++, 2, textW, textH));

        //c.add(new Text("addressStext", "Address: ", 0, i, 1, textW, textH)); // Register: Name and textbox
        //c.add(new TextField("addSTF", "", 1, i++, 1, 95, 20));   

        c.add(new Text("typeSText", "Type: ", 0, i, 1, textW, textH)); // Register: Type and textbox
        c.add(new Dropdown("typeSDD", new String[]{"All", "Apartment", "Attached House", "Detached House", "Townhouse"}, 
                                    1, i++, 1, 95, 20));

        c.add(new Text("#bedSText", "Num of Bedrooms: ", 0, i, 1, textW, textH)); // Register: # of bedrooms and textbox
        c.add(new TextField("#bedSTF", "", 1, i++, 1, 95, 20));

        c.add(new Text("#bathSText", "Num of Bathrooms: ", 0, i, 1, textW, textH)); // Register: # of bathrooms and textbox
        c.add(new TextField("#bathSTF", "", 1, i++, 1, 95, 20));

        c.add(new Text("fursnishedSText", "Furnished: ", 0, i, 1, textW, textH)); // Register: furnished and textbox
        c.add(new Dropdown("furnishedSDD", new String[]{"All", "false", "true"}, 1, i++, 1, 95, 20));

        c.add(new Text("quadrantSText", "Quadrant: ", 0, i, 1, textW, textH)); // Register: quadrant and textbox
        c.add(new Dropdown("quadrantSDD", new String[]{"All", "SW", "NW", "NE", "SE"}, 1, i++, 1, 95, 20));

        c.add(new Text("Space2", " ", 0, i++, 2, 0, 50)); // SPACE

        c.add(new Button("searchBtn", o, "Search", 0, i++, 2, 95, 40));

        c.add(new Text("Space3", " ", 0, i++, 2, 0, 50)); // SPACE

        // Email button
        add(new Button("EmailBtn", o, "Contact Landlord", 0, i++, 2, 95, 40));
        add(new Text("Space6", " ", 0, i++, 2, 0, 50)); // SPACE

        c.add(new Button("LogoutBtn", o, "Logout", 0, i++, 2, 95, 40));
        
        addComponentsToJPanel();
    }
    
    public void addProperty(Property p) {
        List list = (List)findComponent("propertiesView");
        list.addItem(p);
    }
    
    public void updateRenterView(Component c) {
    	this.c.add(c);
        addComponentsToJPanel();
    }

    public void resetTable() {
        List list = (List)findComponent("propertiesView");
        list.reset();
    }
}