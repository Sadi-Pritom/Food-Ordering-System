package database;

import java.sql.*;

import entity.*;

public class AdminData {
    String name;
    Connection con;
    Statement stm;
    ResultSet rs;

    public AdminData(String n) {
        name = n;
        try {
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
                      String url = "jdbc:mysql://localhost:3306/project";
                        Connection con = DriverManager.getConnection(url, "root", "root");
                        

            stm = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void setIncome(double amount) {
        Admin admin = new Admin();
        try {
            rs = stm.executeQuery("SELECT * FROM admin where name like '" + name + "'");
            if (rs.next()) {
                admin.setIncome((rs.getDouble("income")) + amount);
                admin.setName((rs.getString("name")));
                admin.setEmail((rs.getString("email")));
                admin.setPassword((rs.getString("password")));
                admin.setNumber((rs.getString("number")));
                System.out.println(admin.getName());
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        UserData ud = new UserData();
        ud.updateToDb(admin);
    }

    public double getIncome() {
        try {
            rs = stm.executeQuery("SELECT * FROM admin where name like '" + name + "'");
            if (rs.next()) {
                double re;
                re = rs.getDouble("income");
                return re;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;

    }

    public Item getMostSoldItem() {
        Item i = new Item();
        try {
            rs = stm.executeQuery("SELECT * FROM items WHERE ordered=(SELECT max(ordered) FROM items)");
            if (rs.next()) {
                i.setName(rs.getString("name"));
                i.setOrdered(rs.getInt("ordered"));
                i.setPrice(rs.getDouble("price"));
                System.out.println(i.getName());
                return i;
            } else {
                return i;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return i;
        }
    }
}