package ui;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import database.*;

public class LoginUI extends JFrame implements ActionListener {
    UserData db = new UserData();
    //x boolean to separate admin and cashier login call
    static boolean x = false;
    static String cashierId = null;
    JButton adminLogin = new JButton("ADMIN LOGIN");
    JButton cashierLogin = new JButton("CASHIER LOGIN");
    JButton login = new JButton("LOGIN");
    JLabel idLable = new JLabel("Enter ID");
    JLabel nameLabel = new JLabel("Enter Name");
    JLabel passwardJLabel = new JLabel("Enter Passward");
    JTextField id = new JTextField();
    JTextField name = new JTextField();
    JPasswordField password = new JPasswordField();
    //default constructor
    public LoginUI() {
        adminLogin.setBackground(Color.WHITE);
        cashierLogin.setBackground(Color.WHITE);
        ImageIcon img=new ImageIcon("res/icon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Login");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2, 1));
        this.add(adminLogin);
        this.add(cashierLogin);
        adminLogin.addActionListener(this);
        cashierLogin.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.CYAN);
        this.setVisible(true);
    }
    //clear function
    private void Clear() {
        this.remove(adminLogin);
        this.remove(cashierLogin);
        this.setVisible(false);
    }
    //admin login frame
    private void Admin() {
        login.setBackground(Color.WHITE);
        this.setTitle("Admin Login");
        this.setLayout(new GridLayout(5, 1));
        this.add(nameLabel);
        this.add(name);
        this.add(passwardJLabel);
        this.add(password);
        this.add(login);
        login.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.CYAN);
        this.setVisible(true);
    }
    //cashier login frame
    private void Cashier() {
        login.setBackground(Color.WHITE);
        this.setTitle("Cashier Login");
        this.setLayout(new GridLayout(5, 1));
        this.add(idLable);
        this.add(id);
        this.add(passwardJLabel);
        this.add(password);
        this.add(login);
        login.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.CYAN);
        this.setVisible(true);
    }
    //action listener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminLogin) {
            x = true;
            Clear();
            Admin();
        } else if (e.getSource() == cashierLogin) {
            Clear();
            Cashier();
        } else if (e.getSource() == login) {
            if (x) {
                if (db.aloginValidation(name.getText(), password.getPassword())) {
                    AdminUI ad = new AdminUI();
                    ad.createFrame();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong name or password");
                    LoginUI li = new LoginUI();
                    li.Clear();
                    li.Admin();
                    this.dispose();
                }
            } else {
                if (db.cloginValidation(id.getText(), password.getPassword())) {
                    WindowManagment.createCashierUI(id.getText());
                    WindowManagment.createMainUI();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong id or password");
                    LoginUI li = new LoginUI();
                    li.Clear();
                    li.Cashier();
                    this.dispose();
                }
            }
        }
    }

    public static void main(String[] args) {
        // LoginUI l = new LoginUI();
    }
}