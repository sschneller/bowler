package edu.oswego.cs.bowler_owner;

import javax.swing.*;
import java.awt.*;

public class NonLaneButtonInPanel extends JButton{

    NonLaneButtonInPanel(String name){
        this.setText(name);
        Color nonLaneButtons = Color.decode("#009999");
        this.setBackground(nonLaneButtons);
        this.setForeground(Color.white);
    }
}
