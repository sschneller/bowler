package edu.oswego.cs.bowler_owner.components;

import javax.swing.*;
import java.awt.*;

public class JLaneButton extends JButton {

    public JLaneButton(String name) {
        this.setText(name);
        Color laneColor = Color.decode("#0829CC");
        this.setBackground(laneColor);
        this.setForeground(Color.white);
    }
}
