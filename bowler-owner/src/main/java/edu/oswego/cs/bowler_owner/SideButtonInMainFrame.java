package edu.oswego.cs.bowler_owner;

import javax.swing.*;
import java.awt.*;

public class SideButtonInMainFrame extends JButton {

    SideButtonInMainFrame(String name){
        this.setText(name);
        Color buttonColors = Color.decode("#006666");
        this.setBackground(buttonColors);
        this.setForeground(Color.WHITE);
    }
}
