package database;

import java.util.*;
import java.sql.*;

public class Database {
    Connection con;
    Statement stm;
    ResultSet rs;

    public Database() {
        try {
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String url = "jdbc:mysql://localhost:3306/project";
            Connection con = DriverManager.getConnection(url, "root", "root");
            

            stm = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public double getCostFromDb(String name) {
        try {
            rs = stm.executeQuery("SELECT * FROM items WHERE name like '" + name + "'");
            if (rs.next()) {
                double price = rs.getDouble("price");
                return price;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }

    public int getOrderCountFromDb(String name) {
        try {
            rs = stm.executeQuery("SELECT ordered from items WHERE name LIKE '" + name + "'");
            if (rs.next()) {
                int order = rs.getInt("ordered");
                System.out.println(order);
                return order;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void setOrderCountToDb(String name, int val) {
        try {
            int i = stm.executeUpdate("UPDATE items SET ordered=" + val + " WHERE name like '" + name + "'");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}