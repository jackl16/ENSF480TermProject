package Controllers;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.text.DecimalFormat;

import Models.Manager;
import Models.Property;
import Views.ManagerView;
import GUI.Button;
import GUI.ButtonObserver;
import Main.Application;
import Exceptions.*;


public class ManagerController extends DatabaseController implements ButtonObserver {
    private Manager model;
    private ManagerView view;
    public static double fee= 50.00;
    public static int feeperiod= 60;
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public ManagerController() {
        this.model = new Manager();
   
        this.view = new ManagerView(this);
        Application.mainPanel.add(this.view, "manager");
    }

    public static void changeFee(double feeA) {
        fee=feeA;
    }

    public static void changeFeePeriod(int day) {
        feeperiod=day;    
    }

    public static double getFee(){
        return fee;
    }

    public static int getFeePeriod(){
        return feeperiod;
    }

    public void getPeriodicalSummary() {
        String sum= summaryProperties();
       

        JDialog d = new JDialog();
 
            // create a label
            JLabel l = new JLabel("<html>Property Listings: "+numProperties("*")+"<br/> Houses Rented during period: "+numProperties("rented")+" <br/>  Active Listings: "+numProperties("active")+" <br/><br/> Houses Rented:<br/>"+sum, SwingConstants.CENTER);
 
            d.add(l);
 
            // setsize of dialog
            d.setSize(300, 500);
            d.setLocationRelativeTo(null);
 
            // set visibility of dialog
            d.setVisible(true);
    }

    public void feeChangeSuccessful(){
        JDialog d = new JDialog();
            // create a label
            JLabel l = new JLabel("<html>Fee change successful!<br/><br/> Fee Amount is now: $"+df.format(getFee())+".<br/> Fee Period is now: "+getFeePeriod()+" days.", SwingConstants.CENTER);
 
            d.add(l);
 
            // setsize of dialog
            d.setSize(200, 100);
            d.setLocationRelativeTo(null);
 
            // set visibility of dialog
            d.setVisible(true);
        
    }

    public void getFeeDetails(){
        JDialog d = new JDialog();
            // create a label
            JLabel l = new JLabel("<html>Current Fee Amount is: $"+df.format(getFee())+".<br/>Current Fee Period is: "+getFeePeriod()+" days.", SwingConstants.CENTER);
 
            d.add(l);
 
            // setsize of dialog
            d.setSize(200, 100);
            d.setLocationRelativeTo(null);
 
            // set visibility of dialog
            d.setVisible(true);
        
    }

    public void changeState(int id, String state) {

        ArrayList<Property> properties= allProperties();

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getId() == id) {
                properties.get(i).setState(state);
            }
        }

        this.view.updateProperties(properties);

    }

    public void viewDatabase() {
        this.view.loadDatabase(allProperties(),allLandlords(),allRenters());
    }

    public void buttonPressed(String btn) {
        if (btn.compareTo(view.findButton("LogoutBtn").getButtonText()) == 0) {
            Application.cardLayout.show(Application.mainPanel, "login");
        }
        //Change fee button pressed
        else if (btn.compareTo(view.findButton("FeeBtn").getButtonText())==0){
            boolean error= false;
                // Make sure that every input is filled in
                try {               
                        double x= Double.parseDouble(view.findTextField("FeeAmountTF").getText());
                        int y= view.findTextField("FeePeriodTF").getInt();

                        System.out.println(x);
                        System.out.println(y);

                        if(x<0|| y<0){
                            System.out.println("neg");
                            throw new NegativeException("Negative number entered");
                        }
                    }
                        catch (Exception e) {
                            //Error with input
                            System.out.println("errors");
                            error=true;
                        }




                    if (error == false){
                        changeFee(Double.parseDouble(view.findTextField("FeeAmountTF").getText()));
                        changeFeePeriod(view.findTextField("FeePeriodTF").getInt());
                        feeChangeSuccessful();
                        view.findTextField("FeeAmountTF").reset();
                        view.findTextField("FeePeriodTF").reset();
                    }
                    else{
                        JDialog d = new JDialog();
                        // create a label
                        JLabel l = new JLabel("<html>Fee change unsuccessful. Invalid input.<br/>", SwingConstants.CENTER);
                     
                        d.add(l);
                     
                        // setsize of dialog
                        d.setSize(200, 100);
                        d.setLocationRelativeTo(null);
                     
                        // set visibility of dialog
                        d.setVisible(true);
                    }


        }
        // View fees button pressed
        else if (btn.compareTo(view.findButton("VFeeBtn").getButtonText())==0){
            getFeeDetails();
        
        }
        // View Summary button pressed
        else if (btn.compareTo(view.findButton("SummaryBtn").getButtonText())==0){
            getPeriodicalSummary();

        }
        // Database button pressed
        else if (btn.compareTo(view.findButton("DatabaseBtn").getButtonText())==0){
        viewDatabase();

         }
         // Change state button pressed
         else if (btn.compareTo(view.findButton("stateCBtn").getButtonText()) == 0) {
            int inputid = view.findTextField("stateidTF").getInt();
            String s = getPropertyState(inputid);
            // the post has to be posted already
            if (s.compareTo("not-posted") != 0) {
                this.view.setText("stateUpdateText", "");
                String newState = view.findDropdown("stateDD").getText();
                changePropertyState(inputid, newState);
                changeState(inputid, newState);
                view.findTextField("stateidTF").reset();
                view.findDropdown("stateDD").reset();
            } else {
                this.view.setText("stateUpdateText", "Property must be posted first.");
            }
        }
    }

    public void updateView() {
        this.view = new ManagerView(this);
        Application.mainPanel.add(this.view, "manager");
    }

}
