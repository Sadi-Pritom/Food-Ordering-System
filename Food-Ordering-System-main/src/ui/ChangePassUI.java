package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import database.UserData;
import entity.Admin;
import entity.Cashier;
import entity.Person;

public class ChangePassUI extends JFrame implements ActionListener {
    String unique;
    JLabel prePassLabel = new JLabel("Enter Old Password");
    JLabel newPassLabel = new JLabel("Enter New Password");
    JLabel confPassLabel = new JLabel("Enter Confirm New Password");
    JTextField prePass = new JTextField();
    JTextField newPass = new JTextField();
    JTextField confPass = new JTextField();
    JButton ok = new JButton("DONE");
    static boolean admin = false;

    public ChangePassUI(boolean a, String u) {
        ImageIcon img=new ImageIcon("res/icon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Password Change");
        ok.setBackground(Color.WHITE);
        unique = u;
        admin = a;
        this.setSize(400, 350);
        this.setLayout(new GridLayout(7, 1));
        this.setLocationRelativeTo(null);
        this.add(prePassLabel);
        this.add(prePass);
        this.add(newPassLabel);
        this.add(newPass);
        this.add(confPassLabel);
        this.add(confPass);
        this.add(ok);
        ok.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {

            Person c = null;
            if (admin) {
                c = new Admin();
            } else {
                c = new Cashier();
            }
            UserData ud = new UserData();
            if (admin) {
                c = ud.getAdminFromDb();
            } else {
                int id = Integer.parseInt(unique);
                c = ud.getCashierFromDb(id);
            }
            boolean x = prePass.getText().equals(c.getPassword().toString());
            if (x) {
                if (newPass.getText().equals(confPass.getText())) {
                    c.setPassword(newPass.getText());
                    if (admin) {
                        ud.updateToDb((Admin) c);
                    } else {
                        ud.updateToDb((Cashier) c);
                    }
                    JOptionPane.showMessageDialog(this, "Password Updated");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Password Didn't match");
                    ChangePassUI cp = new ChangePassUI(admin, unique);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Old Password");
                ChangePassUI cp = new ChangePassUI(admin, unique);
                this.dispose();
            }
        }
        this.dispose();
    }
}