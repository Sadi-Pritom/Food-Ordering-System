package services;

import database.*;

public class ItemCost {
    Database db = new Database();

    public double getCost(String x) {
        double val = db.getCostFromDb(x);
        return val;
    }
}