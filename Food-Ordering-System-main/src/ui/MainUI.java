package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

public class MainUI extends FrameUI implements ActionListener {
    JButton fastFoodButton = new JButton("FAST FOOD");
    JButton beverageButton = new JButton("BEVERAGE");
    JButton confirmButton = new JButton("CONFIRM ORDER");
    JLabel textTotalCost = new JLabel("TOTAL COST:   " + queue.totalCost + "TK");
    public MainUI() {
        confirmButton.setBackground(Color.WHITE);
        this.setIconImage(img.getImage());
        beverageButton.setIcon(new ImageIcon("res/buttonBeverage.jpg"));
        beverageButton.setHorizontalTextPosition(JButton.CENTER);
        beverageButton.setVerticalTextPosition(JButton.CENTER);

        fastFoodButton.setIcon(new ImageIcon("res/fastFood.jpg"));
        fastFoodButton.setHorizontalTextPosition(JButton.CENTER);
        fastFoodButton.setVerticalTextPosition(JButton.CENTER);

        fastFoodButton.setFont(fastFoodButton.getFont().deriveFont(40.0f));
        beverageButton.setFont(beverageButton.getFont().deriveFont(40.0f));

        fastFoodButton.setForeground(Color.WHITE);
        beverageButton.setForeground(Color.BLACK);

        // setting title
        this.setTitle("Food Ordering System");
        // set size
        this.setSize(xAxis, yAxis);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(textTotalCost);
        this.add(fastFoodButton);
        this.add(beverageButton);
        this.add(confirmButton);
        this.setLayout(new GridLayout(4, 1));
        textTotalCost.setFont(textTotalCost.getFont().deriveFont(64.0f));
        this.setBackground(Color.BLUE);
        this.setVisible(true);
        fastFoodButton.addActionListener((ActionListener) this);
        beverageButton.addActionListener((ActionListener) this);
        confirmButton.addActionListener((ActionListener) this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fastFoodButton) {
            FrameUI f = new FastFoodUI();
        } else if (e.getSource() == beverageButton) {
            FrameUI b = new BeverageUI();
        } else if (e.getSource() == confirmButton) {
            DileveryUI d = new DileveryUI();
            d.createFrame();
        }
        this.dispose();
    }
}