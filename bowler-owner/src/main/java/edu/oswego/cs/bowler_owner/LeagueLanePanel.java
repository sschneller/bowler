package edu.oswego.cs.bowler_owner;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeagueLanePanel extends JPanel implements ActionListener {

    private LaneButton lane1;
    private NonLaneButtonInPanel lanesControl, pinsettersControl, absentTeams;

    LeagueLanePanel() {
        setLayout(new MigLayout());
        Color backgroundColor = Color.decode("#B3B3B3");
        setBackground(backgroundColor);

        add(lane1 = new LaneButton("Lane 1"), "wrap");

        add(lanesControl = new NonLaneButtonInPanel("Turn Lanes On"));
        add(pinsettersControl = new NonLaneButtonInPanel("Pinsetters On"));
        add(absentTeams = new NonLaneButtonInPanel("Absent Teams"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
