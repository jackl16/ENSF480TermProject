package GUI;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagConstraints;
import java.lang.reflect.Array;

import Models.Email;
import Models.Property;
import Models.Landlord;
import Models.RegisteredRenter;

import java.awt.Dimension;

public class List implements Component {
    String label;

    int x;
    int y;
    int width;
    int height;
    int gridwidth;

    DefaultTableModel table;
    Object[][] n;
    JScrollPane listScroller;
    JTable t;

    // List for display properties
    public List(String label, ArrayList<Property> list, int x, int y, int gridwidth, int width, int height) {
        table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };

        this.label = label;

        table.addColumn("id");
        table.addColumn("Address");
        table.addColumn("Type");
        table.addColumn("Num of Bedrooms");
        table.addColumn("Num of Bathrooms");
        table.addColumn("Furnished");
        table.addColumn("City Quadrant");
        table.addColumn("State");

        for (int i = 0; i < list.size(); i++) {
            table.addRow(new Object[] {
                    list.get(i).getId(),
                    list.get(i).getAddress(),
                    list.get(i).getType(),
                    list.get(i).getNumBedrooms(),
                    list.get(i).getNumBathrooms(),
                    list.get(i).getFurnished(),
                    list.get(i).getQuadrant(),
                    list.get(i).getState() });
        }

        t = new JTable(table);

        // t.setSize(new Dimension(500, 100));

        listScroller = new JScrollPane(t);
        listScroller.getVerticalScrollBar();

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gridwidth = gridwidth;
        listScroller.setPreferredSize(new Dimension(this.width, this.height));
    }

    // List for displaying emails
    public List(ArrayList<Email> list, String label, int x, int y, int gridwidth, int width, int height) {
        table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };

        this.label = label;

        table.addColumn("sender");
        table.addColumn("content");

        for (int i = 0; i < list.size(); i++) {
            table.addRow(new Object[] {
                    list.get(i).getSendUsername(),
                    list.get(i).getContent() });
        }

        t = new JTable(table);

        // t.setSize(new Dimension(500, 100));

        listScroller = new JScrollPane(t);
        listScroller.getVerticalScrollBar();

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gridwidth = gridwidth;
        listScroller.setPreferredSize(new Dimension(this.width, this.height));
    }

    //List for displaying landlords
    public List(String label,ArrayList<Landlord> list, int x, int y, int gridwidth, int width, int height, int land) {
        table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };

        this.label = label;

        table.addColumn("id");
        table.addColumn("First Name");
        table.addColumn("Last Name");
        table.addColumn("Email Address");

        for (int i = 0; i < list.size(); i++) {
            table.addRow(new Object[]{
                list.get(i).getId(),
                list.get(i).getFirstName(),
                list.get(i).getLastName(),
                list.get(i).getEmailAddress()});
        }

        //t = new JTable(n, columnNames);
        t = new JTable(table);
        //t.setSize(new Dimension(500, 100));

        listScroller = new JScrollPane(t);
        listScroller.getVerticalScrollBar();
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gridwidth = gridwidth;
        listScroller.setPreferredSize(new Dimension(this.width, this.height));
    }

        //List for displaying registered renters
        public List(String label,ArrayList<RegisteredRenter> list, int x, int y, int gridwidth, int width, int height, boolean a) {
            table = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };
    
            this.label = label;
            
            table.addColumn("id");
            table.addColumn("First Name");
            table.addColumn("Last Name");
            //table.addColumn("Email Address");
    
            for (int i = 0; i < list.size(); i++) {
                table.addRow(new Object[]{
                    list.get(i).getId(),
                    list.get(i).getFirstName(),
                    list.get(i).getLastName()});
            }
    
            t = new JTable(table);
 
    
            listScroller = new JScrollPane(t);
            listScroller.getVerticalScrollBar();
            
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.gridwidth = gridwidth;
            listScroller.setPreferredSize(new Dimension(this.width, this.height));
        }

    // add properties
    public void addItem(Property p) {
        this.table.addRow(new Object[] { p.getId(), p.getAddress(), p.getType(), p.getNumBedrooms(),
                p.getNumBathrooms(), p.getFurnished(), p.getQuadrant(), p.getState() });
    }

    //Add landlords
    public void addItem(Landlord p) {
        table.addRow(new Object[]{p.getId(), p.getFirstName(), p.getLastName(), p.getEmailAddress()});
    }

    // Add Registered Renters
    public void addItem(RegisteredRenter p) {
        table.addRow(new Object[]{p.getId(), p.getFirstName(), p.getLastName()});
    }

    public String getLabel() {
        return this.label;
    }

    public void reset() {
        this.table.setRowCount(0);
    }

    public void draw(JPanel p) {
        p.add(listScroller);
    }

    public void draw(JPanel p, GridBagConstraints gbc) {
        if (this.gridwidth == 2) {
            gbc.anchor = GridBagConstraints.CENTER;
        }
        if (this.gridwidth == 1) {
            if (this.x == 0) {
                gbc.anchor = GridBagConstraints.LINE_END;
            } else if (this.x == 1) {
                gbc.anchor = GridBagConstraints.LINE_START;
            }
        }

        gbc.gridwidth = this.gridwidth;
        gbc.gridx = this.x;
        gbc.gridy = this.y;
        p.add(listScroller, gbc);
    }
}
