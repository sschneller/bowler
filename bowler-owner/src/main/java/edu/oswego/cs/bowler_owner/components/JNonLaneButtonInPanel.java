package edu.oswego.cs.bowler_owner.components;

import javax.swing.*;
import java.awt.*;

public class JNonLaneButtonInPanel extends JButton {

    public JNonLaneButtonInPanel(String name) {
        this.setText(name);
        Color nonLaneButtons = Color.decode("#009999");
        this.setBackground(nonLaneButtons);
        this.setForeground(Color.white);
    }
}
