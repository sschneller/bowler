package edu.oswego.cs.bowler_owner;


import javax.swing.*;
import java.awt.*;

public class TopMainFrameButtons extends JButton {

    TopMainFrameButtons(String name){
        this.setText(name);
        Color topScreenColors = Color.decode("#000000");
        this.setBackground(topScreenColors);
        this.setForeground(Color.WHITE);
    }
}
