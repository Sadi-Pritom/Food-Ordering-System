package services;

import database.*;

public class OrderCount {
    Database db = new Database();

    public void setOrderCount(String name, int q) {
        int preVal = db.getOrderCountFromDb(name);
        db.setOrderCountToDb(name, preVal + q);
    }
}