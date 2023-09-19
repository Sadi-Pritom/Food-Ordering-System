package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FastFoodUI extends FrameUI implements ActionListener {
    JButton burgerButton = new JButton("Burger");
    JButton pizzaButton = new JButton("Pizza");
    JButton pastaButton = new JButton("Pasta");
    JButton sandwichButton = new JButton("Sandwich");
    JButton fryButton = new JButton("Fry");
    JButton cakesButton = new JButton("Cakes");
    JButton back = new JButton("Back");

    public FastFoodUI() {
        back.setBackground(Color.WHITE);
        this.setIconImage(img.getImage());
        burgerButton.setIcon(new ImageIcon("res/buttonBurger.jpg"));
        burgerButton.setHorizontalTextPosition(JButton.CENTER);
        burgerButton.setVerticalTextPosition(JButton.CENTER);

        cakesButton.setIcon(new ImageIcon("res/buttonCake.jpg"));
        cakesButton.setHorizontalTextPosition(JButton.CENTER);
        cakesButton.setVerticalTextPosition(JButton.CENTER);

        fryButton.setIcon(new ImageIcon("res/buttonFry.jpg"));
        fryButton.setHorizontalTextPosition(JButton.CENTER);
        fryButton.setVerticalTextPosition(JButton.CENTER);

        pastaButton.setIcon(new ImageIcon("res/buttonPasta.jpg"));
        pastaButton.setHorizontalTextPosition(JButton.CENTER);
        pastaButton.setVerticalTextPosition(JButton.CENTER);

        pizzaButton.setIcon(new ImageIcon("res/buttonPizza.jpg"));
        pizzaButton.setHorizontalTextPosition(JButton.CENTER);
        pizzaButton.setVerticalTextPosition(JButton.CENTER);

        sandwichButton.setIcon(new ImageIcon("res/buttonSandwich.jpg"));
        sandwichButton.setHorizontalTextPosition(JButton.CENTER);
        sandwichButton.setVerticalTextPosition(JButton.CENTER);

        burgerButton.setFont(burgerButton.getFont().deriveFont(32.0f));
        pizzaButton.setFont(pizzaButton.getFont().deriveFont(32.0f));
        pastaButton.setFont(pastaButton.getFont().deriveFont(32.0f));
        fryButton.setFont(fryButton.getFont().deriveFont(32.0f));
        sandwichButton.setFont(sandwichButton.getFont().deriveFont(32.0f));
        cakesButton.setFont(cakesButton.getFont().deriveFont(32.0f));
        burgerButton.setForeground(Color.YELLOW);
        pizzaButton.setForeground(Color.ORANGE);
        pastaButton.setForeground(Color.BLUE);
        fryButton.setForeground(Color.RED);
        sandwichButton.setForeground(Color.GREEN);
        cakesButton.setForeground(Color.CYAN);

        // set size
        this.setSize(xAxis, yAxis);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(burgerButton);
        this.add(pizzaButton);
        this.add(pastaButton);
        this.add(sandwichButton);
        this.add(cakesButton);
        this.add(fryButton);
        this.add(back);
        this.setLayout(new GridLayout(7, 1));
        // setting title
        this.setTitle("FAST FOOD");
        this.setVisible(true);
        burgerButton.addActionListener((ActionListener) this);
        pizzaButton.addActionListener((ActionListener) this);
        fryButton.addActionListener((ActionListener) this);
        cakesButton.addActionListener((ActionListener) this);
        sandwichButton.addActionListener((ActionListener) this);
        pastaButton.addActionListener((ActionListener) this);
        back.addActionListener((ActionListener) this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == burgerButton) {
            FrameUI b = new BurgerUI();
            b.createFrame();
        } else if (e.getSource() == pizzaButton) {
            FrameUI p = new PizzaUI();
            p.createFrame();
        } else if (e.getSource() == fryButton) {
            FrameUI f = new FryUI();
            f.createFrame();
        } else if (e.getSource() == pastaButton) {
            FrameUI f = new PastaUI();
            f.createFrame();
        } else if (e.getSource() == sandwichButton) {
            FrameUI f = new SandwichUI();
            f.createFrame();
        } else if (e.getSource() == cakesButton) {
            FrameUI f = new CakesUI();
            f.createFrame();
        } else {
            WindowManagment.createMainUI();
        }
        this.dispose();
    }
}