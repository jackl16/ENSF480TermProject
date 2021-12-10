package Views;

import java.util.ArrayList;

import GUI.Button;
import GUI.ButtonObserver;
import GUI.Dropdown;
import GUI.List;
import GUI.Text;
import GUI.TextField;
import Models.Property;


public class LandlordView extends View {

    public LandlordView(ButtonObserver o, ArrayList<Property> p) {
        int textW = 200;
        int textH = 10;

        int i = 0;

        // Viewing properties
        add(new Text("PropText", "Properties", 0, i++, 2, textW, textH));

        add(new List("propertiesView", p, 0, i++, 2, 800, 100));

        add(new Text("Space1", " ", 0, i++, 2, 0, 50)); // SPACE

        // Registering a new property
        add(new Text("RegPropText", "Register Property", 0, i++, 2, textW, textH));

        add(new Text("AddressText", "Address: ", 0, i, 1, textW, textH)); // Register: Name and textbox
        add(new TextField("AddressTF", "", 1, i++, 1, 95, 20));   

        add(new Text("TypeText", "Type: ", 0, i, 1, textW, textH)); // Register: Type and textbox
        add(new Dropdown("typeDD", new String[]{"Apartment", "Attached House", "Detached House", "Townhouse"}, 
                                    1, i++, 1, 95, 20));

        add(new Text("#BedText", "Num of Bedrooms: ", 0, i, 1, textW, textH)); // Register: # of bedrooms and textbox
        add(new TextField("#BedTF", "", 1, i++, 1, 95, 20));

        add(new Text("#BathText", "Num of Bathrooms: ", 0, i, 1, textW, textH)); // Register: # of bathrooms and textbox
        add(new TextField("#BathTF", "", 1, i++, 1, 95, 20));

        add(new Text("FurnishedText", "Furnished: ", 0, i, 1, textW, textH)); // Register: furnished and textbox
        add(new Dropdown("furnishedDD", new String[]{"false", "true"}, 1, i++, 1, 95, 20));

        add(new Text("QuadrantText", "Quadrant: ", 0, i, 1, textW, textH)); // Register: quadrant and textbox
        add(new Dropdown("quadrantDD", new String[]{"SW", "NW", "NE", "SE"}, 1, i++, 1, 95, 20));

        //c.add(new Text("Space2", " ", 0, i++, 2, 0, 50)); // SPACE

        add(new Button("RegisterBtn", o, "Register", 0, i++, 2, 95, 40));

        add(new Text("Space3", " ", 0, i++, 2, 0, 50)); // SPACE

        // Fee payment
        add(new Text("PayFeeText", "Pay Fee to Post", 0, i++, 2, textW, textH));
        add(new Text("feeIdText", "ID: ", 0, i, 1, textW, textH));
        add(new TextField("feeidTF", "", 1, i++, 1, 95, 20));
        add(new Button("PayfeeBtn", o, "Pay Fee", 0, i++, 2, 95, 40));
        add(new Text("Space4", " ", 0, i++, 2, 0, 50)); // SPACE

        // Change state
        add(new Text("stateText", "Change State", 0, i++, 2, textW, textH));
        add(new Text("stateId", "Id: ", 0, i, 1, textW, textH));
        add(new TextField("stateidTF", "", 1, i++, 1, 95, 20));
        add(new Dropdown("stateDD", new String[]{"active", "rented", "cancelled", "suspended"}, 
                            0, i++, 2, 95, 20));
        add(new Button("stateCBtn", o, "Change State", 0, i++, 2, 95, 40));
        add(new Text("stateUpdateText", "", 0, i++, 2, 0, 50)); // SPACE
        add(new Text("Space5", " ", 0, i++, 2, 0, 50)); // SPACE

        // Email button
        add(new Button("EmailBtn", o, "Email", 0, i++, 2, 95, 40));
        add(new Text("Space6", " ", 0, i++, 2, 0, 50)); // SPACE

        // Logout btn
        add(new Button("LogoutBtn", o, "Logout", 0, i++, 2, 95, 40));

        addComponentsToJPanel();
    }

    public void updateProperties(ArrayList<Property> p) {
        List l = (List)findComponent("propertiesView");
        l.reset();
        for (int i = 0; i < p.size(); i++) {
            l.addItem(p.get(i));
        }
    }

    public void addProperty(Property p) {
        List list = (List)findComponent("propertiesView");
        list.addItem(p); 
    }

    public void resetRegister() {
        findTextField("AddressTF").reset();
        findDropdown("typeDD").reset();
        findTextField("#BedTF").reset();
        findTextField("#BathTF").reset();
        findDropdown("furnishedDD").reset();
        findDropdown("quadrantDD").reset();
    }
}
