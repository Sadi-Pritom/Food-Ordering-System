package entity;

public class Item{
    String name="";
    double price=0;
    int ordered=0;
    public void setName(String n){
        name=n;
    }
    public void setPrice(double p){
        price=p;
    }
    public void setOrdered(int o){
        ordered=o;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getOrdered(){
        return ordered;
    }

}