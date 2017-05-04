package edu.oswego.cs.bowler_owner.components;

import javax.swing.*;
import java.awt.*;

public class JSideButtonInMainFrame extends JButton {

    public JSideButtonInMainFrame(String name){
        this.setText(name);
        Color buttonColors = Color.decode("#006666");
        this.setBackground(buttonColors);
        this.setForeground(Color.WHITE);
    }
}
