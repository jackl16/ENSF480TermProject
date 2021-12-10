package Controllers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Email;
import Models.Property;
import Models.RegisteredRenter;
import Models.Landlord;

public class DatabaseController {

    public DatabaseController() {

    }

    private Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:tpdb.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public String selectUserPassword(String usern) {
        String sql = "SELECT username, password FROM logins WHERE username = ";
        usern = "'" + usern + "'";
        sql = sql + usern;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("username") + " " + rs.getString("password"));
                return rs.getString("password");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String selectUserType(String usern) {
        String sql = "SELECT username, type FROM logins WHERE username = ";
        usern = "'" + usern + "'";
        sql = sql + usern;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // System.out.println(rs.getString("username") + " " +
                // rs.getString("password"));
                return rs.getString("type");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Property> selectProperties(String usern) {
        String sql = "SELECT id, landlord, address, type, numBedrooms, numBathrooms, furnished, quadrant, state FROM properties WHERE landlord = ";
        usern = "'" + usern + "'";
        sql = sql + usern;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            ArrayList<Property> p = new ArrayList<Property>();
            while (rs.next()) {
                // System.out.println(rs.getString("username") + " " +
                // rs.getString("password"));
                p.add(new Property(
                        rs.getInt("id"),
                        rs.getString("address"),
                        rs.getString("type"),
                        rs.getInt("numBedrooms"),
                        rs.getInt("numBathrooms"),
                        rs.getBoolean("furnished"),
                        rs.getString("quadrant"),
                        rs.getString("state")));
                // return rs.getString("type");
            }

            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Property selectPropertyByID(int id) {
        String sql = "UPDATE properties SET state = ";
        sql = sql + id;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            Property p = new Property(0, "", "", 0, 0, false, "", "");
            while (rs.next()) {
                // System.out.println(rs.getString("username") + " " +
                // rs.getString("password"));
                p = new Property(
                        rs.getInt("id"),
                        rs.getString("address"),
                        rs.getString("type"),
                        rs.getInt("numBedrooms"),
                        rs.getInt("numBathrooms"),
                        rs.getBoolean("furnished"),
                        rs.getString("quadrant"),
                        rs.getString("state"));
                // return rs.getString("type");
            }

            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String selectLandlordByID(int id) {
        String sql = "SELECT landlord FROM properties WHERE id = ";
        sql = sql + id;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                return rs.getString("landlord");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void changePropertyState(int id, String s) {
        String sql = "UPDATE properties SET state = ";
        sql = sql + "'" + s + "'";
        sql = sql + " WHERE id = " + id;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getPropertyState(int id) {
        String sql = "SELECT state FROM properties WHERE id = ";
        sql = sql + id;

        String s = "";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // i = conn.prepareStatement(INSERT_SQL);
            s = rs.getString("state");
            // stmt.executeQuery(v);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return s;
    }

    public void addProperty(Property p, String landlord) {
        String sql = "INSERT INTO properties (id, landlord, address, type, numBedrooms, numBathrooms, furnished, quadrant, state)"
                +
                "VALUES(" + p.getId() + ", '" + landlord + "', '" + p.getAddress() + "', '" + p.getType() + "', " +
                p.getNumBedrooms() + ", " + p.getNumBathrooms() + ", " + p.getFurnished() + ", '" + p.getQuadrant() +
                "', '" + p.getState() + "');";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // i = conn.prepareStatement(INSERT_SQL);

            // stmt.executeQuery(v);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Property> searchProperties(String type, String numBedrooms, String numBathrooms, String furnished,
            String quad) {

        String where = "";

        if (type.compareTo("") != 0) {
            where += "AND type = '" + type + "'";
        }

        if (numBedrooms.compareTo("") != 0) {
            where += "AND numBedrooms = " + numBedrooms;
        }

        if (numBathrooms.compareTo("") != 0) {
            where += "AND numBathrooms = " + numBathrooms;
        }

        if (furnished.compareTo("") != 0) {
            where += "AND furnished = " + furnished;
        }

        if (quad.compareTo("") != 0) {
            where += "AND quadrant = '" + quad + "'";
        }

        String sql = "SELECT [id], [type], [address]"
                + ", [numBedrooms]"
                + ", [numBathrooms]"
                + ", [furnished]"
                + ", [quadrant], [state] "
                + "FROM properties WHERE state = 'active' "
                + where;
        /*
         * String sql = "SELECT * FROM properties WHERE "
         * + "type = '" + type + "' AND "
         * + "numBedrooms = " + numBedrooms + " AND "
         * + "numBathrooms = " + numBathrooms + " AND "
         * + "furnished = " + furnished + " AND "
         * + "quadrant = '" + quad + "' AND "
         * + "state = 'active'";
         */
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            ArrayList<Property> search = new ArrayList<Property>();
            while (rs.next()) {
                // System.out.println(rs.getString("username") + " " +
                // rs.getString("password"));
                search.add(new Property(
                        rs.getInt("id"),
                        rs.getString("address"),
                        rs.getString("type"),
                        rs.getInt("numBedrooms"),
                        rs.getInt("numBathrooms"),
                        rs.getBoolean("furnished"),
                        rs.getString("quadrant"),
                        rs.getString("state")));
                // return rs.getString("type");
            }
            return search;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public int getLastId() {
        String sql = "SELECT id FROM properties";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("id");
            }

            return id;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public void sendEmail(Email E) {
        String sql = "INSERT INTO emails (sendusername, recvusername, content)"
                + " VALUES('" + E.getSendUsername() + "', '" + E.getRecvUsername() + "', '" + E.getContent() + "');";


        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {               

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Email> recvEmail(String recvusername) {
        ArrayList<Email> emails = new ArrayList<Email>();
        String sql = "SELECT sendusername, content FROM emails WHERE recvusername = '" + recvusername + "'"; 

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {               

                while(rs.next()) {
                    emails.add(new Email(rs.getString("sendusername"), recvusername, rs.getString("content")));
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return emails;
    }


    public String summaryProperties() {
        String sql = "SELECT landlord, id, address FROM properties WHERE state = 'rented'";


        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            StringBuffer p= new StringBuffer();
            p.append("Landlord | House Id | Address<br/>------------------------------------------<br/>");
            while (rs.next()) {
                //System.out.println(rs.getString("username") + " " + rs.getString("password"));
                p.append(
                    rs.getString("landlord")+" |     "+
                    rs.getString("id")+"    | "+
                    rs.getString("address"));
                //return rs.getString("type");
                p.append( "<br/>");
            }

            return p.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String numProperties(String stat) {
        String sql;
        if (stat !="*"){
            sql = "SELECT * FROM properties WHERE state = '"+stat+"'";
        }
        else{
            sql = "SELECT * FROM properties";

        }


        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            int num=0;
           
            while (rs.next()) {
                num++;
            }

            return String.valueOf(num);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Property> allProperties() {
        String sql = "SELECT id, landlord, address, type, numBedrooms, numBathrooms, furnished, quadrant, state FROM properties";

        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            ArrayList<Property> p = new ArrayList<Property>();
            while (rs.next()) {
                //System.out.println(rs.getString("username") + " " + rs.getString("password"));
                p.add(new Property(
                    rs.getInt("id"),
                    rs.getString("address"), 
                    rs.getString("type"), 
                    rs.getInt("numBedrooms"), 
                    rs.getInt("numBathrooms"), 
                    rs.getBoolean("furnished"), 
                    rs.getString("quadrant"),
                    rs.getString("state")));
                //return rs.getString("type");
            }

            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Landlord> allLandlords() {
        String sql = "SELECT id, firstname, lastname, email FROM users where type = 'landlord'";

        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            ArrayList<Landlord> p = new ArrayList<Landlord>();
            while (rs.next()) {
                //System.out.println(rs.getString("username") + " " + rs.getString("password"));
                p.add(new Landlord(
                    rs.getInt("id"),
                    rs.getString("firstname"), 
                    rs.getString("lastname"), 
                    rs.getString("email")));
                //return rs.getString("type");
            }

            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<RegisteredRenter> allRenters() {
        String sql = "SELECT id, firstname, lastname FROM users where type = 'renter'";

        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            ArrayList<RegisteredRenter> p = new ArrayList<RegisteredRenter>();
            while (rs.next()) {
                //System.out.println(rs.getString("username") + " " + rs.getString("password"));
                p.add(new RegisteredRenter(
                    rs.getInt("id"),
                    rs.getString("firstname"), 
                    rs.getString("lastname")));
                //return rs.getString("type");
            }

            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }




}
