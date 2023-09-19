package ui;

import javax.swing.*;
import entity.*;
import database.AdminData;
import database.UserData;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class AdminUI extends JFrame implements ActionListener {
    static UserData ud = new UserData();
    static Admin admin = ud.getAdminFromDb();
    static String name = admin.getName();
    int type = 0;
    AdminData ad = new AdminData(name);
    LinkedList<JLabel> cashierLable = new LinkedList<JLabel>();
    LinkedList<Cashier> cashier = new LinkedList<Cashier>();
    JMenu menu = new JMenu("Menu");
    JMenuItem changePassword = new JMenuItem("Change Password");
    JMenuItem logout = new JMenuItem("Logout");
    JButton back = new JButton("Back");
    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");
    JButton add = new JButton("Add");
    JButton load = new JButton("Load");
    JLabel enterName = new JLabel("Enter Name:");
    JLabel enterEmail = new JLabel("Enter Email:");
    JLabel enterNumber = new JLabel("Enter Number:");
    JLabel enterPass = new JLabel("Enter Password");
    JLabel enterSalary = new JLabel("Enter Salary:");
    JTextField nameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField passField = new JTextField();
    JTextField salaryField = new JTextField();
    JTextField numberField = new JTextField();
    JButton showAllCashierButton = new JButton("Show All Cashier");
    JLabel enterIdLabel = new JLabel("Enter Cashier ID");
    JTextField idField = new JTextField();
    JButton done = new JButton("Done");
    JButton refresh = new JButton("Refresh");
    JButton backtoPane = new JButton("Back");
    JLabel cashierText = new JLabel("All Cashiers Names and ID: ");
    JLabel incomeLabel = new JLabel("Total product sold: " + ad.getIncome() + "TK");
    JLabel mostSoldItemLabel = new JLabel("Most sold item: '" + ad.getMostSoldItem().getName() + "' sold "
            + ad.getMostSoldItem().getOrdered() + " times.");

    public AdminUI() {
        ImageIcon img=new ImageIcon("res/icon.png");
        add.setBackground(Color.WHITE);
        load.setBackground(Color.WHITE);
        done.setBackground(Color.WHITE);
        update.setBackground(Color.WHITE);
        refresh.setBackground(Color.WHITE);
        delete.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);
        backtoPane.setBackground(Color.WHITE);
        this.setIconImage(img.getImage());
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
    }

    public String getName() {
        return name;
    }

    public void createFrame() {
        this.setTitle("Admin");
        JMenuBar bar = new JMenuBar();
        menu.add(changePassword);
        menu.add(logout);
        bar.add(menu);
        showAllCashierButton.setBackground(Color.WHITE);
        this.setJMenuBar(bar);
        this.setLayout(new GridLayout(3, 1));
        mostSoldItemLabel.setFont(mostSoldItemLabel.getFont().deriveFont(25.0f));
        incomeLabel.setFont(incomeLabel.getFont().deriveFont(25.0f));
        this.add(mostSoldItemLabel);
        this.add(incomeLabel);
        this.add(showAllCashierButton);
        showAllCashierButton.addActionListener(this);
        changePassword.addActionListener(this);
        logout.addActionListener(this);
        this.setVisible(true);
    }

    public void showAllCashier() {
        this.setTitle("Cashier Pane");
        this.setLayout(null);
        this.remove(mostSoldItemLabel);
        this.remove(incomeLabel);
        this.remove(showAllCashierButton);
        this.setSize(450, 600);
        this.remove(showAllCashierButton);
        this.setBackground(Color.CYAN);
        UserData ud = new UserData();
        cashier = ud.getAllUser();
        int count = cashier.size();
        for (int i = 0; i < count; i++) {
            JLabel temp = new JLabel((i + 1) + ". " + cashier.get(i).getName() + "[" + cashier.get(i).getId() + "]");
            cashierLable.add(temp);
        }
        int x = 30, y = 30;
        cashierText.setBounds(x, y, 200, 30);
        this.add(cashierText);
        for (int i = 0; i < count; i++) {
            y += 40;
            cashierLable.get(i).setBounds(x, y, 200, 30);
            this.add(cashierLable.get(i));
        }
        back.setBounds(300, 30, 80, 30);
        add.setBounds(300, 90, 80, 30);
        update.setBounds(300, 150, 80, 30);
        delete.setBounds(300, 210, 80, 30);
        refresh.setBounds(300, 270, 80, 30);
        this.add(back);
        this.add(add);
        this.add(update);
        this.add(delete);
        this.add(refresh);
        refresh.addActionListener(this);
        back.addActionListener(this);
        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        this.setVisible(true);
    }

    public void deleteCashier() {
        this.setTitle("Delete Cashier");
        this.setSize(250, 200);
        this.setLayout(new GridLayout(3, 1));
        this.add(enterIdLabel);
        this.add(idField);
        this.add(done);
        type = 3;
        done.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void addCashier() {
        this.setTitle("Add Cashier");
        type = 1;
        this.setSize(250, 600);
        this.setLayout(new GridLayout(13, 1));
        this.add(enterIdLabel);
        this.add(idField);
        this.add(enterName);
        this.add(nameField);
        this.add(enterPass);
        this.add(passField);
        this.add(enterEmail);
        this.add(emailField);
        this.add(enterNumber);
        this.add(numberField);
        this.add(enterSalary);
        this.add(salaryField);
        this.add(done);
        done.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void updateCashier() {
        this.setTitle("Update Cashier");
        type = 2;
        this.setSize(250, 600);
        this.setLayout(new GridLayout(14, 1));
        this.add(enterIdLabel);
        this.add(idField);
        this.add(load);
        this.add(enterName);
        this.add(nameField);
        this.add(enterPass);
        this.add(passField);
        this.add(enterEmail);
        this.add(emailField);
        this.add(enterNumber);
        this.add(numberField);
        this.add(enterSalary);
        this.add(salaryField);
        this.add(done);
        done.addActionListener(this);
        load.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showAllCashierButton) {
            this.setVisible(false);
            this.showAllCashier();
        } else if (e.getSource() == logout) {
            LoginUI li = new LoginUI();
            li.x = false;
            this.dispose();
        } else if (e.getSource() == back) {
            AdminUI ad = new AdminUI();
            ad.createFrame();
            this.dispose();
        } else if (e.getSource() == changePassword) {
            ChangePassUI cp = new ChangePassUI(true, name);
        } else if (e.getSource() == delete) {
            AdminUI ad = new AdminUI();
            ad.deleteCashier();
        } else if (e.getSource() == done) {
            if (type == 1) {
                Cashier c = new Cashier();
                c.setName(nameField.getText());
                c.setId(Integer.parseInt(idField.getText()));
                c.setPassword(passField.getText());
                c.setNumber(numberField.getText());
                c.setEmail(emailField.getText());
                c.setSalary(Double.parseDouble(salaryField.getText()));
                UserData ud = new UserData();
                if (ud.insertToDb(c)) {
                    JOptionPane.showMessageDialog(this, "Added");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Info");
                    AdminUI ad = new AdminUI();
                    ad.addCashier();
                    this.dispose();
                }
            } else if (type == 2) {
                Cashier c = new Cashier();
                c.setId(Integer.parseInt(idField.getText()));
                c.setEmail(emailField.getText());
                c.setName(nameField.getText());
                c.setPassword(passField.getText());
                c.setNumber(numberField.getText());
                c.setSalary(Double.parseDouble(salaryField.getText()));
                UserData ud = new UserData();
                if (ud.updateToDb(c)) {
                    JOptionPane.showMessageDialog(this, "Updated");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Info");
                    AdminUI ad = new AdminUI();
                    ad.addCashier();
                    this.dispose();
                }
            } else if (type == 3) {
                int id = Integer.parseInt(idField.getText());
                UserData ud = new UserData();
                if (ud.removeFromDb(id)) {
                    JOptionPane.showMessageDialog(this, "Deleted");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong ID");
                    AdminUI ad = new AdminUI();
                    ad.deleteCashier();
                    this.dispose();
                }
            }
        } else if (e.getSource() == refresh) {
            AdminUI ad = new AdminUI();
            ad.showAllCashier();
            this.dispose();
        } else if (e.getSource() == add) {
            AdminUI ad = new AdminUI();
            ad.addCashier();
        } else if (e.getSource() == load) {
            UserData ud = new UserData();
            Cashier c = new Cashier();
            c = ud.getCashierFromDb(Integer.parseInt(idField.getText()));
            nameField.setText(c.getName());
            emailField.setText(c.getEmail());
            salaryField.setText("" + c.getSalary());
            numberField.setText(c.getNumber());
        } else if (e.getSource() == update) {
            AdminUI ad = new AdminUI();
            ad.updateCashier();
        }
    }
}