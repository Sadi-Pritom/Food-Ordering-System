package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import services.*;

public class DileveryUI extends FrameUI implements ActionListener {
    JButton parcel = new JButton("Parcel");
    JButton here = new JButton("Eat Here");
    JButton home = new JButton("Home Delivery");
    JPanel prcAndEat = new JPanel();
    JPanel dilevery = new JPanel();

    public DileveryUI() {
        parcel.setBackground(Color.WHITE);
        here.setBackground(Color.WHITE);
        home.setBackground(Color.WHITE);
        this.setIconImage(img.getImage());
        this.setTitle("Dilevery Options");
    }
    public void createFrame(){
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // setting title
        this.setTitle("DELIVERY");
        this.add(here);
        this.add(parcel);
        this.add(home);
        this.setLayout(new GridLayout(3, 1));
        this.setVisible(true);
        here.addActionListener(this);
        parcel.addActionListener(this);
        home.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == here) {
            queue.type = "Eat Here";
            OrderInfoUI u = new OrderInfoUI(false);
        } else if (e.getSource() == home) {
            queue.type = "Home Delivery";
            OrderInfoUI u = new OrderInfoUI(true);
        } else {
            queue.type = "Parcel";
            OrderInfoUI u = new OrderInfoUI(false);
        }
        this.dispose();
    }
}