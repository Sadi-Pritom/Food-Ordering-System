package services;

import java.io.FileWriter;

public class OrderSave {
    public OrderSave(String[] s, double total, String type, int token, String[] usr) {
        int count = s.length;
        String newLine = System.getProperty("line.separator");
        int num = 0;
        try {
            FileWriter fw = new FileWriter("res/order/order.txt");
            fw.write("Token : " + token + newLine);
            fw.write("Order type: " + type + newLine);
            for (int i = 0; i < usr.length; i++) {
                fw.write(usr[i] + newLine);
            }
            fw.write("------------------------------------" + newLine);
            for (int i = 0; i < count; i++) {
                num++;
                fw.write(num + "." + s[i] + newLine);
            }
            fw.write("------------------------------------" + newLine);
            fw.write("TOTAL COST:    " + total + "TK" + newLine);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Process p = Runtime.getRuntime().exec("notepad ./res/order/order.txt");
        } catch (Exception e) {

        }
        TotalCostSave tc=new TotalCostSave();
        tc.setTotalCost(total);
    }
}