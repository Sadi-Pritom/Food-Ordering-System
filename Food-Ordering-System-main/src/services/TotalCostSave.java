package services;

import database.*;
import ui.AdminUI;

public class TotalCostSave {
    AdminData ad=new AdminData(new AdminUI().getName());

    public void setTotalCost(double a) {
        ad.setIncome(a);
    }
}