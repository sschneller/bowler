package edu.oswego.cs.bowler_owner;

import javax.swing.*;
import java.awt.*;

public class LaneButton extends JButton{

    LaneButton(String name){
        this.setText(name);
        Color laneColor = Color.decode("#0829CC");
        this.setBackground(laneColor);
        this.setForeground(Color.white);
    }
}
