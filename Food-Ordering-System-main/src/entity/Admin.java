package entity;

public class Admin extends Person {
    private double income;

    public void setIncome(double amount) {
        income = amount;
    }

    public double getIncome() {
        return income;
    }

}