package edu.oswego.cs.bowler_owner;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideMainFramePanel extends JPanel implements ActionListener {

    private MainFrame mainFrame;
    private NonLeagueLanePanel nonPanel;
    private LeagueLanePanel leaguePanel;
    private SideButtonInMainFrame safeMode, setDefaults, ownerFeatures, cashOut;
    private String userName;

    SideMainFramePanel(MainFrame mF, NonLeagueLanePanel nlP, LeagueLanePanel llP, String user){
        setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][grow,fill][grow,fill][grow,fill]"));

        mainFrame = mF;
        nonPanel = nlP;
        leaguePanel = llP;
        userName = user;

        Color backgroundColor = Color.decode("#666666");
        setBackground(backgroundColor);

        add(safeMode = new SideButtonInMainFrame("Safe Mode"), "pad 0 0 -40 0, wrap");
        add(setDefaults = new SideButtonInMainFrame("Set Defaults"), "pad 13 0 -27 0, wrap");
        add(ownerFeatures = new SideButtonInMainFrame("Owner Features"), "pad 27 0 -13 0, wrap");
        add(cashOut = new SideButtonInMainFrame("Cash Out"), "pad 40 0 0 0");

        safeMode.addActionListener(this);
        setDefaults.addActionListener(this);
        ownerFeatures.addActionListener(this);
        cashOut.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getText().equals("Safe Mode")){
            final SafeFrame safeFrame = new SafeFrame(mainFrame, userName);
            SwingUtilities.invokeLater(() -> safeFrame.setVisible(true));
        }
        else if(((JButton)e.getSource()).getText().equals("Set Defaults")){
            final PriceDefaultsFrame priceDefaultsFrame = new PriceDefaultsFrame(mainFrame);
            SwingUtilities.invokeLater(() -> priceDefaultsFrame.setVisible(true));
        }
        else if(((JButton)e.getSource()).getText().equals("Owner Features")){
            final ControlFrame controlFrame = new ControlFrame(mainFrame, nonPanel, leaguePanel);
            SwingUtilities.invokeLater(() -> controlFrame.setVisible(true));
        }
        else if(((JButton)e.getSource()).getText().equals("Cash Out")){

        }
    }
}
