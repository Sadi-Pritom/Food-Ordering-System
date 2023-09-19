package entity;

public class Cashier extends Person {
    private int id;
    private double salary;

    public void setId(int x) {
        id = x;
    }

    public void setSalary(double amount) {
        salary = amount;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

}