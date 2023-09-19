package ui;

import javax.swing.*;
import services.*;

public class FrameUI extends JFrame {
    // global x-axis,y-axis
    protected int xAxis = 1024;

    protected int yAxis = 720;
    //icon
    ImageIcon img=new ImageIcon("res/icon.png");
    // cost variable to hold the ordered values
    public static uiQueue queue = new uiQueue();
    // frame id
    int id = 0;

    // method to construct this frame
    public void createFrame() {
    }

}