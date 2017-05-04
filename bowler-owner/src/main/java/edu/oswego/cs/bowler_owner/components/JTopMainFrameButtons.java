package edu.oswego.cs.bowler_owner.components;


import javax.swing.*;
import java.awt.*;

public class JTopMainFrameButtons extends JButton {

    public JTopMainFrameButtons(String name){
        this.setText(name);
        Color topScreenColors = Color.decode("#000000");
        this.setBackground(topScreenColors);
        this.setForeground(Color.WHITE);
    }
}
