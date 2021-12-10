package Views;

import java.util.ArrayList;
import java.text.DecimalFormat;
import javax.swing.JPanel;

import Controllers.ManagerController;
import GUI.Button;
import GUI.ButtonObserver;
import GUI.Component;
import GUI.Dropdown;
import GUI.List;
import GUI.Text;
import GUI.TextField;
import Main.Application;
import Models.Property;
import Models.Landlord;
import Models.RegisteredRenter;

import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;

import java.awt.Dimension;

public class ManagerView extends View {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private Boolean dbLoaded= false;


    List properties;
    List landlords;
    List rrenters;

    public ManagerView(ButtonObserver o) {   
        int textW = 200;
        int textH = 10;

        int i = 0;

        ArrayList<Property> p = new ArrayList<>();
        ArrayList<Landlord> l = new ArrayList<>();
        ArrayList<RegisteredRenter> r = new ArrayList<>();
        
        //viewing properties
        add(new Text("PropText","Properties", 0, i++, 2, textW, textH));

        add(properties = new List("propertiesView",p, 0, i++, 2, 800, 100));

        //add(new Text("Space1"," ", 0, i++, 2, 0, 50)); // SPACE 

        //viewing landlords
        add(new Text("LandlordText","Landlords", 0, i++, 2, textW, textH));

        add(landlords = new List("landlordsView",l, 0, i++, 2, 600, 100,1)); 

        //add(new Text("Space2"," ", 0, i++, 2, 0, 50)); // SPACE 

        //viewing registered renters
        add(new Text("RenterText","Registered Renters", 0, i++, 2,textW, textH)); 
        add(rrenters= new List("rentersView",r, 0, i++, 2, 400, 100,true));

        //add(new Text("Space3"," ", 0, i++, 2, 0, 50)); // SPACE 

        // load database
        add(new Button("DatabaseBtn", o, "Load Database", 0, i++, 2, 95, 40)); 
 
        add(new Text("Space4"," ", 0, i++, 2, 0, 50)); // SPACE 

        // changing fee amount/period and viewing fee
        add(new Text("FeeText1","Fee Amount: ($) ", 0, i, 1, textW, textH)); 
        add(new TextField("FeeAmountTF","", 1, i++, 1, 95, 20)); 

        add(new Text("FeeText2","Fee Period: (days) ", 0, i,1, textW, textH)); 
        add(new TextField("FeePeriodTF","", 1, i++, 1, 95, 20)); 

        add(new Button("FeeBtn",o, "Change Fee", 0, i++, 2, 95, 40)); 
        add(new Button("VFeeBtn",o, "View Fees", 0, i++, 2, 95, 40)); 

        add(new Text("Space5"," ", 0, i++, 2, 0, 50)); // SPACE 

        // summary
        add(new Button("SummaryBtn",o, "Summary", 0, i++, 2, 95, 40)); 
        add(new Text("Space6", " ", 0, i++, 2, 0, 50)); // SPACE

        // change state
        add(new Text("stateText", "Change State", 0, i++, 2, textW, textH));
        add(new Text("stateId", "Id: ", 0, i, 2, textW, textH));
        add(new TextField("stateidTF", "", 1, i++, 1, 50, 20));

        add(new Dropdown("stateDD", new String[]{"active", "rented", "cancelled", "suspended"}, 
                            0, i++, 2, 95, 20));
        add(new Button("stateCBtn", o, "Change State", 0, i++, 2, 95, 40));
        add(new Text("stateUpdateText", "", 0, i++, 2, 0, 50)); // SPACE
        add(new Text("Space7", " ", 0, i++, 2, 0, 50)); // SPACE

        // logout button
        add(new Button("LogoutBtn",o, "Logout", 0, i++, 2, 95, 40)); 

    
        addComponentsToJPanel();
    }

    public void loadDatabase(ArrayList<Property> p, ArrayList<Landlord>l, ArrayList<RegisteredRenter>r){
        if (Boolean.TRUE.equals(dbLoaded)==false)
        {
            for (int i=0;i<p.size(); i++){
                properties.addItem(p.get(i));
            }

            for (int i=0;i<l.size(); i++){
                landlords.addItem(l.get(i));
            }

            for (int i=0;i<r.size(); i++){
                rrenters.addItem(r.get(i));
            }


            dbLoaded=true;
        }

    }

    public void updateProperties(ArrayList<Property> p) {
        List l = (List)findComponent("propertiesView");
        l.reset();
        for (int i = 0; i < p.size(); i++) {
            l.addItem(p.get(i));
        }
    }



}
