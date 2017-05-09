package edu.oswego.cs.bowler;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class GUI extends JFrame {

    final ControlFrame cf = new ControlFrame();

    public GUI() {
        setLayout(new MigLayout("", "[grow,fill]", "[grow,fill]"));
        setSize(500, 500);
        cf.setVisible(true);
    }
}
