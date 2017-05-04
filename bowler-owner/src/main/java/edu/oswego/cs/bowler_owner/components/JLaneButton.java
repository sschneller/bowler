package edu.oswego.cs.bowler_owner.components;

import javax.swing.*;
import java.awt.*;

public class JLaneButton extends JButton {

    public String ip;

    public JLaneButton(String name, String ip) {
        this.ip = ip;
        this.setText(name);
        Color laneColor = Color.decode("#0829CC");
        this.setBackground(laneColor);
        this.setForeground(Color.white);
    }
}
