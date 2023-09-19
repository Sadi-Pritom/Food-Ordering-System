package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import services.*;
public class OrderInfoUI extends FrameUI implements ActionListener {
    JLabel nameLable = new JLabel("Enter Name");
    JTextField name = new JTextField();
    JLabel addressLabel = new JLabel("Enter Address");
    JTextField address = new JTextField();
    JButton ok = new JButton("OK");
    boolean ad;

    public OrderInfoUI(boolean usr) {
        ok.setBackground(Color.WHITE);
        this.setIconImage(img.getImage());
        this.setTitle("Order Info");
        this.setSize(260, 160);
        ad = usr;
        if (ad) {
            this.setLayout(new GridLayout(5, 1));
            this.add(nameLable);
            this.add(name);
            this.add(addressLabel);
            this.add(address);
            this.add(ok);
        } else {
            this.setLayout(new GridLayout(3, 1));
            this.add(nameLable);
            this.add(name);
            this.add(ok);
        }
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        ok.addActionListener((ActionListener) this);
    }

    public void actionPerformed(ActionEvent e) {
        if (ad) {
            queue.usr = new String[2];
            queue.usr[0] = "Name: " + name.getText();
            queue.usr[1] = "Address: " + address.getText();
        } else {
            queue.usr = new String[1];
            queue.usr[0] = "Name: " + name.getText();
        }
        CashierUI cu = new CashierUI();
        uiQueue q = queue;
        cu.addOrder(q);
        queue.token++;
        JOptionPane.showMessageDialog(this, "Your Token is : " + queue.token);
        queue.clear();
        WindowManagment.createMainUI();
        this.dispose();
    }
}