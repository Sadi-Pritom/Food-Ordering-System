package ui;

import services.ItemCost;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.LinkedList;

public class PastaUI extends FrameUI implements ActionListener {
    // ItemCost object
    ItemCost db = new ItemCost();
    // amount list
    LinkedList<JComboBox<Integer>> amount = new LinkedList<JComboBox<Integer>>();
    // text lable
    private JLabel textItem;
    private JLabel textPrice;
    private JLabel textQuantity;
    private JLabel textTotalCost;
    LinkedList<JLabel> price = new LinkedList<JLabel>();
    // item number
    int it = 6;
    // done button
    private JButton done = new JButton("DONE");
    // back button
    private JButton back = new JButton("BACK");
    // item list
    // item array
    String[] itemString = new String[] { "Oven Baked Pasta", "Spicy Pasta", "Chilli Sauce Pasta",
            "Beef Oven Baked Pasta", "Tiger Garden Special Pasta", "Cheesy Pasta" };
    // item list
    LinkedList<JCheckBox> item = new LinkedList<JCheckBox>();
    // cost array
    double[] itemCost = new double[] { db.getCost(itemString[0]), db.getCost(itemString[1]), db.getCost(itemString[2]),
            db.getCost(itemString[3]), db.getCost(itemString[4]), db.getCost(itemString[5]) };
    // frame id
    int id = 4;

    // method to set order choices if there are any
    private void initChoise() {
        node[] n = queue.getItems(id);
        if (n != null) {
            int size = n.length;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < it; j++) {
                    if (n[i].item == item.get(j).getText()) {
                        item.get(j).setSelected(true);
                        amount.get(j).setSelectedItem(n[i].quantity);
                    }
                }
            }

        }
    }

    // Frame creation method
    public void createFrame() {
        done.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);
        this.setIconImage(img.getImage());
        int xi = 40, xa = 540, xl = 700;
        // set size
        this.setSize(xAxis, yAxis);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // adding image backgroung
        String loc = "res/pasta.jpg";
        this.setContentPane(new JLabel(new ImageIcon(loc)));
        // setting title
        this.setTitle("Pasta");
        // this is this frames layout
        this.setLayout(null);
        // setting comobox
        for (int i = 0; i < it; i++) {
            JComboBox<Integer> temp = new JComboBox<Integer>(
                    new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 });
            amount.add(temp);
        }
        // setting items
        for (int i = 0; i < it; i++) {
            JCheckBox temp = new JCheckBox(itemString[i]);
            item.add(temp);
        }
        // text to show in the top
        textItem = new JLabel("ITEMS");
        textPrice = new JLabel("PRICE");
        textQuantity = new JLabel("QUANTITY");
        textTotalCost = new JLabel("TOTAL COST:   " + queue.totalCost);
        // price lebel
        for (int i = 0; i < it; i++) {
            JLabel temp = new JLabel("@" + Double.toString(itemCost[i]) + "TK");
            price.add(temp);
        }
        // text bound
        textItem.setBounds(xi, 20, 200, 30);
        textItem.setForeground(Color.WHITE);
        textPrice.setBounds(xa, 20, 200, 30);
        textPrice.setForeground(Color.WHITE);
        textQuantity.setBounds(xl, 20, 200, 30);
        textQuantity.setForeground(Color.WHITE);
        textTotalCost.setBounds(xi, 440, 200, 30);
        textTotalCost.setForeground(Color.WHITE);

        //
        price.get(0).setBounds(xa, 80, 200, 30);
        price.get(0).setForeground(Color.WHITE);
        price.get(1).setBounds(xa, 140, 200, 30);
        price.get(1).setForeground(Color.WHITE);
        price.get(2).setBounds(xa, 200, 200, 30);
        price.get(2).setForeground(Color.WHITE);
        price.get(3).setBounds(xa, 260, 200, 30);
        price.get(3).setForeground(Color.WHITE);
        price.get(4).setBounds(xa, 320, 200, 30);
        price.get(4).setForeground(Color.WHITE);
        price.get(5).setBounds(xa, 380, 200, 30);
        price.get(5).setForeground(Color.WHITE);

        // item bounds
        item.get(0).setBounds(xi, 80, 300, 30);
        item.get(1).setBounds(xi, 140, 300, 30);
        item.get(2).setBounds(xi, 200, 300, 30);
        item.get(3).setBounds(xi, 260, 300, 30);
        item.get(4).setBounds(xi, 320, 300, 30);
        item.get(5).setBounds(xi, 380, 300, 30);

        // amount bounds
        amount.get(0).setBounds(xl, 80, 80, 30);
        amount.get(1).setBounds(xl, 140, 80, 30);
        amount.get(2).setBounds(xl, 200, 80, 30);
        amount.get(3).setBounds(xl, 260, 80, 30);
        amount.get(4).setBounds(xl, 320, 80, 30);
        amount.get(5).setBounds(xl, 380, 80, 30);
        // done button bounds
        done.setBounds(xi, 600, 80, 30);
        // back button bounds
        back.setBounds(800, 600, 80, 30);
        // adding items to the frame
        this.add(item.get(0));
        this.add(item.get(1));
        this.add(item.get(2));
        this.add(item.get(3));
        this.add(item.get(4));
        this.add(item.get(5));
        // adding amounts to the frame
        this.add(amount.get(0));
        this.add(amount.get(1));
        this.add(amount.get(2));
        this.add(amount.get(3));
        this.add(amount.get(4));
        this.add(amount.get(5));
        // setting prewious value if there any
        this.initChoise();
        // adding buttons
        this.add(textItem);
        this.add(textPrice);
        this.add(textQuantity);
        this.add(textTotalCost);
        this.add(price.get(0));
        this.add(price.get(1));
        this.add(price.get(2));
        this.add(price.get(3));
        this.add(price.get(4));
        this.add(price.get(5));
        this.add(done);
        this.add(back);
        this.setVisible(true);

        // adding actionListener
        back.addActionListener(this);
        done.addActionListener(this);
        item.get(0).addActionListener(this);
        item.get(1).addActionListener(this);
        item.get(2).addActionListener(this);
        item.get(3).addActionListener(this);
        item.get(4).addActionListener(this);
        item.get(5).addActionListener(this);
        amount.get(0).addActionListener(this);
        amount.get(1).addActionListener(this);
        amount.get(2).addActionListener(this);
        amount.get(3).addActionListener(this);
        amount.get(4).addActionListener(this);
        amount.get(5).addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            WindowManagment.createMainUI();
            this.dispose();
        } else if (e.getSource() == back) {
            FrameUI f = new FastFoodUI();
            this.dispose();
        } else if (e.getSource() == item.get(0)) {
            if (item.get(0).isSelected()) {
                int q = 1;
                if ((Integer) amount.get(0).getSelectedItem() != null) {
                    q = (Integer) amount.get(0).getSelectedItem();
                }
                queue.pushItem(id, itemString[0], q, itemCost[0]);
            } else {
                queue.removeItem(itemString[0]);
            }
        }
        if (e.getSource() == item.get(1)) {
            if (item.get(1).isSelected()) {
                int q = 1;
                if ((Integer) amount.get(1).getSelectedItem() != null) {
                    q = (Integer) amount.get(1).getSelectedItem();
                }
                queue.pushItem(id, itemString[1], q, itemCost[1]);
            } else {
                queue.removeItem(itemString[1]);
            }
        }
        if (e.getSource() == item.get(2)) {
            if (item.get(2).isSelected()) {
                int q = 1;
                if ((Integer) amount.get(2).getSelectedItem() != null) {
                    q = (Integer) amount.get(2).getSelectedItem();
                }
                queue.pushItem(id, itemString[2], q, itemCost[2]);
            } else {
                queue.removeItem(itemString[2]);
            }
        }
        if (e.getSource() == item.get(3)) {
            if (item.get(3).isSelected()) {
                int q = 1;
                if ((Integer) amount.get(3).getSelectedItem() != null) {
                    q = (Integer) amount.get(3).getSelectedItem();
                }
                queue.pushItem(id, itemString[3], q, itemCost[3]);
            } else {
                queue.removeItem(itemString[3]);
            }
        }
        if (e.getSource() == item.get(4)) {
            if (item.get(4).isSelected()) {
                int q = 1;
                if ((Integer) amount.get(4).getSelectedItem() != null) {
                    q = (Integer) amount.get(4).getSelectedItem();
                }
                queue.pushItem(id, itemString[4], q, itemCost[4]);
            } else {
                queue.removeItem(itemString[4]);
            }
        }
        if (e.getSource() == item.get(5)) {
            if (item.get(5).isSelected()) {
                int q = 1;
                if ((Integer) amount.get(5).getSelectedItem() != null) {
                    q = (Integer) amount.get(5).getSelectedItem();
                }
                queue.pushItem(id, itemString[5], q, itemCost[5]);
            } else {
                queue.removeItem(itemString[5]);
            }
        }
        if (e.getSource() == amount.get(0)) {
            queue.changeQuantity(itemString[0], (Integer) amount.get(0).getSelectedItem());
        }
        if (e.getSource() == amount.get(1)) {
            queue.changeQuantity(itemString[1], (Integer) amount.get(1).getSelectedItem());
        }
        if (e.getSource() == amount.get(2)) {
            queue.changeQuantity(itemString[2], (Integer) amount.get(2).getSelectedItem());
        }
        if (e.getSource() == amount.get(3)) {
            queue.changeQuantity(itemString[3], (Integer) amount.get(3).getSelectedItem());
        }
        if (e.getSource() == amount.get(4)) {
            queue.changeQuantity(itemString[4], (Integer) amount.get(4).getSelectedItem());
        }
        if (e.getSource() == amount.get(5)) {
            queue.changeQuantity(itemString[5], (Integer) amount.get(5).getSelectedItem());
        }
        textTotalCost.setText("TOTAL COST:   " + queue.totalCost + "TK");
    }
}
