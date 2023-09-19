package entity;

public class Customer {
    private String name, address;
    private double totalCost;

    public Customer() {
    }

    public Customer(String[] s, double c) {
        name = s[0];
        address = s[1];
        totalCost = c;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAddress(String location) {
        address = location;
    }

    public void setTotalCost(double c) {
        totalCost = c;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public double getTotalCost() {
        return totalCost;
    }
}