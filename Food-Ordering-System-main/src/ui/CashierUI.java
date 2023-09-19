package ui;

import javax.swing.*;
import services.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class CashierUI extends JFrame implements ActionListener {
    private static String cashierId = null;
    private static Queue<String[]> sq = new LinkedList<String[]>();
    private static Queue<String[]> usrq = new LinkedList<String[]>();
    private static Queue<String> typeq = new LinkedList<String>();
    private static Queue<Double> totalcostq = new LinkedList<Double>();
    private static Queue<Integer> tokenq = new LinkedList<Integer>();
    int count = sq.size();
    JMenu menu = new JMenu("Menu");
    JMenuItem changePassword = new JMenuItem("Change Password");
    JMenuItem logout = new JMenuItem("Logout");
    JLabel countLable = new JLabel("Number of Order pending: " + count);
    JButton refresh = new JButton("Refresh");
    JButton print = new JButton("Print and Finish Order");

    public CashierUI() {
        print.setBackground(Color.WHITE);
        refresh.setBackground(Color.WHITE);
        ImageIcon img=new ImageIcon("res/icon.png");
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        this.setTitle("Cashier");
    }

    public CashierUI(String id) {
        print.setBackground(Color.WHITE);
        refresh.setBackground(Color.WHITE);
        ImageIcon img=new ImageIcon("res/icon.png");
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        cashierId = id;
        this.setTitle("Cashier");
    }

    public void createFrame() {
        this.setSize(400, 300);
        countLable.setFont(countLable.getFont().deriveFont(25.0f));
        this.setLayout(new GridLayout(3, 1));
        JMenuBar bar = new JMenuBar();
        this.add(countLable);
        this.add(print);
        this.add(refresh);
        menu.add(changePassword);
        menu.add(logout);
        bar.add(menu);
        this.setJMenuBar(bar);
        changePassword.addActionListener(this);
        logout.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        refresh.addActionListener(this);
        print.addActionListener(this);
        this.setBackground(Color.CYAN);
        this.setVisible(true);
    }

    public void addOrder(uiQueue order) {
        usrq.add(order.usr);
        typeq.add(order.type);
        totalcostq.add(order.totalCost);
        tokenq.add(order.token);
        // System.out.println(order.peek().totalCost);
        int x = order.count;
        String[] s = new String[x];
        node n;
        OrderCount oc = new OrderCount();
        for (int i = 0; i < x; i++) {
            n = order.popItem();
            oc.setOrderCount(n.item, n.quantity);
            s[i] = n.item + "(" + n.quantity + ")    :   " + n.cost + "TK";
        }
        sq.add(s);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePassword) {
            ChangePassUI cp = new ChangePassUI(false, cashierId);
        } else if (e.getSource() == logout) {
            LoginUI lg=new LoginUI();
            WindowManagment.disposeMainUI();
            this.dispose();
        } else if (e.getSource() == refresh) {
            CashierUI cu = new CashierUI();
            cu.createFrame();
            this.dispose();
        } else {
            OrderSave os = new OrderSave(sq.remove(), totalcostq.remove(), typeq.remove(), tokenq.remove(),
                    usrq.remove());
            CashierUI cu = new CashierUI();
            cu.createFrame();
            this.dispose();
        }
    }
}