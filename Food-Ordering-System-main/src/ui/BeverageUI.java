package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BeverageUI extends FrameUI implements ActionListener {
    JButton coldDrinksButton = new JButton("Cold Drinks");
    JButton hotDrinksButton = new JButton("Hot Drinks");
    JButton juiceButton = new JButton("Juices");
    JButton back = new JButton("Back");

    public BeverageUI() {
        back.setBackground(Color.WHITE);
        this.setIconImage(img.getImage());
        coldDrinksButton.setIcon(new ImageIcon("res/buttonColdDrinks.jpg"));
        coldDrinksButton.setHorizontalTextPosition(JButton.CENTER);
        coldDrinksButton.setVerticalTextPosition(JButton.CENTER);

        hotDrinksButton.setIcon(new ImageIcon("res/buttonHotDrinks.jpg"));
        hotDrinksButton.setHorizontalTextPosition(JButton.CENTER);
        hotDrinksButton.setVerticalTextPosition(JButton.CENTER);

        juiceButton.setIcon(new ImageIcon("res/buttonJuices.jpeg"));
        juiceButton.setHorizontalTextPosition(JButton.CENTER);
        juiceButton.setVerticalTextPosition(JButton.CENTER);

        coldDrinksButton.setFont(coldDrinksButton.getFont().deriveFont(32.0f));
        hotDrinksButton.setFont(hotDrinksButton.getFont().deriveFont(32.0f));
        juiceButton.setFont(juiceButton.getFont().deriveFont(32.0f));

        coldDrinksButton.setForeground(Color.GREEN);
        hotDrinksButton.setForeground(Color.CYAN);
        juiceButton.setForeground(Color.RED);

        // setting title
        this.setTitle("Beverage");
        // set size
        this.setSize(xAxis, yAxis);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(coldDrinksButton);
        this.add(juiceButton);
        this.add(hotDrinksButton);
        this.add(back);
        this.setLayout(new GridLayout(4, 1));
        this.setVisible(true);
        coldDrinksButton.addActionListener((ActionListener) this);
        hotDrinksButton.addActionListener((ActionListener) this);
        juiceButton.addActionListener((ActionListener) this);
        back.addActionListener((ActionListener) this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == juiceButton) {
            FrameUI b = new JuiceUI();
            b.createFrame();
        } else if (e.getSource() == hotDrinksButton) {
            FrameUI p = new HotDrinksUI();
            p.createFrame();
        } else if (e.getSource() == coldDrinksButton) {
            FrameUI f = new ColdDrinksUI();
            f.createFrame();
        } else {
            WindowManagment.createMainUI();
        }
        this.dispose();
    }
}