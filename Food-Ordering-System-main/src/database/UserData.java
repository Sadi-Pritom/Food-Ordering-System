package database;

import entity.*;
import java.sql.*;
import java.util.*;

public class UserData {
    Connection con;
    Statement stm;
    ResultSet rs;
    Cashier cashier = new Cashier();
    Admin admin = new Admin();
    Customer customer = new Customer();
    LinkedList<Cashier> cashierList = new LinkedList<Cashier>();

    // creating connection through constructor

    public UserData() {
        try {
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String url = "jdbc:mysql://localhost:3306/project";
                        Connection con = DriverManager.getConnection(url, "root", "root");
                        
            stm = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // inserting cashier information on cashier table in database

    public boolean insertToDb(Cashier cashier) {
        int i = 0;
        try {
            i = stm.executeUpdate("INSERT INTO cashier(name,id,email,password,number,salary) VALUES('"
                    + cashier.getName() + "','" + cashier.getId() + "','" + cashier.getEmail() + "','"
                    + cashier.getPassword() + "','" + cashier.getNumber() + "','" + cashier.getSalary() + "')");

        } catch (SQLException e) {
            System.out.println(e);
        }
        if (i == 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insertToDb(Admin admin) {
        int i = 0;
        try {
            i = stm.executeUpdate("INSERT INTO admin(name,email,password,number,income) VALUES('" + admin.getName()
                    + "','" + admin.getEmail() + "','" + admin.getPassword() + "','" + admin.getNumber() + "','"
                    + admin.getIncome() + "')");

        } catch (SQLException e) {
            System.out.println(e);
        }
        if (i == 1) {
            return true;
        } else {
            return false;
        }

    }

    // updating cashier information on cashier table in database

    public boolean updateToDb(Cashier cashier) {
        int i = 0;
        try {
            i = stm.executeUpdate("UPDATE cashier SET name='" + cashier.getName() + "',id=" + cashier.getId()
                    + ",email='" + cashier.getEmail() + "',password='" + cashier.getPassword() + "',number='"
                    + cashier.getNumber() + "',salary=" + cashier.getSalary() + " WHERE id=" + cashier.getId());

        } catch (SQLException e) {
            System.out.println(e);
        }
        if (i == 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean updateToDb(Admin admin) {
        int i = 0;
        try {
            i = stm.executeUpdate("UPDATE admin SET name='" + admin.getName() + "',email='" + admin.getEmail()
                    + "',password='" + admin.getPassword() + "',number='" + admin.getNumber() + "',income="
                    + admin.getIncome() + " WHERE name like '" + admin.getName() + "'");

        } catch (SQLException e) {
            System.out.println(e);
        }
        if (i == 1) {
            return true;
        } else {
            return false;
        }

    }

    // deleting cashier information on cashier table in database

    public boolean removeFromDb(int id) {
        int i = 0;
        try {
            i = stm.executeUpdate("DELETE FROM cashier WHERE id=" + id);

        } catch (SQLException e) {
            System.out.println(e);
        }
        if (i == 1) {
            return true;
        } else {
            return false;
        }

    }

    // storing a single cashier information through a cashier object

    public Cashier getCashierFromDb(int id) {

        try {
            rs = stm.executeQuery("SELECT * FROM cashier WHERE id=" + id);
            if (rs.next()) {
                cashier.setId(Integer.parseInt(rs.getString("id")));
                cashier.setName((rs.getString("name")));
                cashier.setSalary((rs.getDouble("salary")));
                cashier.setEmail((rs.getString("email")));
                cashier.setPassword((rs.getString("password")));
                cashier.setNumber((rs.getString("number")));
                System.out.println(cashier.getName());
                return (Cashier) cashier;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    public Admin getAdminFromDb() {

        try {
            rs = stm.executeQuery("SELECT * FROM admin");
            if (rs.next()) {
                admin.setIncome(rs.getDouble("income"));
                admin.setName((rs.getString("name")));
                admin.setEmail((rs.getString("email")));
                admin.setPassword((rs.getString("password")));
                admin.setNumber((rs.getString("number")));
                System.out.println(admin.getName());
                return (Admin) admin;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    public Customer getCustomerFromDb(int id) {

        try {
            rs = stm.executeQuery("SELECT * FROM cashier WHERE id=" + id);
            if (rs.next()) {
                customer.setName((rs.getString("name")));
                customer.setAddress((rs.getString("address")));
                customer.setTotalCost((rs.getDouble("totalCost")));
                return (Customer) customer;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    // storing information of every cashier on a cashier list

    public LinkedList<Cashier> getAllUser() {

        try {
            rs = stm.executeQuery("SELECT * FROM cashier ");
            while (rs.next()) {
                cashier = new Cashier();
                cashier.setId(Integer.parseInt(rs.getString("id")));
                cashier.setName((rs.getString("name")));
                cashier.setSalary(rs.getDouble("salary"));
                cashier.setEmail((rs.getString("email")));
                cashier.setPassword((rs.getString("password")));
                cashier.setNumber((rs.getString("number")));
                cashierList.add(cashier);

            }
            // System.out.println(cashierList);
            return cashierList;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    // admin login validation

    public boolean aloginValidation(String name, String password) {
        try {
            rs = stm.executeQuery("SELECT * FROM admin WHERE name='" + name + "' AND password='" + password + "'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException d) {
            System.out.println(d);
        }
        return false;
    }

    // cashier login validation

    public boolean cloginValidation(String id, String password) {
        try {
            rs = stm.executeQuery("SELECT * FROM cashier WHERE id='" + id + "' AND password='" + password + "'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException d) {
            System.out.println(d);
        }
        return false;
    }

}
