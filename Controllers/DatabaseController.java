package Controllers;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            ResultSet rs = stmt.executeQuery(sql))
        {
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
            ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                //System.out.println(rs.getString("username") + " " + rs.getString("password"));
                return rs.getString("type");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
