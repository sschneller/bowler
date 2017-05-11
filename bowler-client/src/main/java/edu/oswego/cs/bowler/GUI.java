package edu.oswego.cs.bowler;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    final ControlFrame cf = new ControlFrame();

    public GUI() {
        setLayout(new MigLayout("", "[grow,fill]", "[grow,fill]"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setResizable(false);
        cf.setVisible(true);
        setUndecorated(true);
    }
}
