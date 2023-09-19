package ui;

public class WindowManagment{
    static CashierUI cashier=null;
    static LoginUI lg=null;
    static FrameUI fu=null;
    
    static public void createCashierUI(String s){
        cashier=new CashierUI(s);
        cashier.createFrame();
    }
    
    static public void createMainUI(){
        fu=new MainUI();
    }
    
    static public void disposeCashierUI(){
        cashier.dispose();
    }
    
    static public void disposeLoginUI(){
        lg.dispose();
    }
    static public void disposeMainUI(){
        fu.dispose();
    }
}