package edu.oswego.cs.bowler_owner.containers.panels;

import edu.oswego.cs.bowler_owner.components.JSideButtonInMainFrame;
import edu.oswego.cs.bowler_owner.containers.dialogs.ControlDialog;
import edu.oswego.cs.bowler_owner.containers.dialogs.PriceDefaultsDialog;
import edu.oswego.cs.bowler_owner.containers.dialogs.SafeModeDialog;
import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class SideMainFramePanel extends JPanel implements ActionListener {

    private MainFrame mainFrame;
    private NonLeagueLanePanel nonPanel;
    private LeagueLanePanel leaguePanel;
    private JSideButtonInMainFrame safeMode, setDefaults, ownerFeatures, cashOut;
    private String userName;

    public SideMainFramePanel(MainFrame mF, NonLeagueLanePanel nlP, LeagueLanePanel llP, String user) {
        setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][grow,fill][grow,fill][grow,fill]"));

        mainFrame = mF;
        nonPanel = nlP;
        leaguePanel = llP;
        userName = user;

        Color backgroundColor = Color.decode("#666666");
        setBackground(backgroundColor);

        add(safeMode = new JSideButtonInMainFrame("Safe Mode"), "pad 0 0 -40 0, wrap");
        add(setDefaults = new JSideButtonInMainFrame("Set Defaults"), "pad 13 0 -27 0, wrap");
        add(ownerFeatures = new JSideButtonInMainFrame("Owner Features"), "pad 27 0 -13 0, wrap");
        add(cashOut = new JSideButtonInMainFrame("Cash Out"), "pad 40 0 0 0");

        safeMode.addActionListener(this);
        setDefaults.addActionListener(this);
        ownerFeatures.addActionListener(this);
        cashOut.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getText().equals("Safe Mode")) {
            final SafeModeDialog safeModeDialog = new SafeModeDialog(mainFrame, userName);
            SwingUtilities.invokeLater(() -> safeModeDialog.setVisible(true));
        }
        else if(((JButton)e.getSource()).getText().equals("Set Defaults")) {
            final PriceDefaultsDialog priceDefaultsDialog = new PriceDefaultsDialog(mainFrame);
            SwingUtilities.invokeLater(() -> priceDefaultsDialog.setVisible(true));
        }
        else if(((JButton)e.getSource()).getText().equals("Owner Features")) {
            final ControlDialog controlDialog = new ControlDialog(mainFrame, nonPanel, leaguePanel);
            SwingUtilities.invokeLater(() -> controlDialog.setVisible(true));
        }
        else if(((JButton)e.getSource()).getText().equals("Cash Out")) {
            if(DB.getPrice("Total") != -1){
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                JOptionPane.showMessageDialog(null, formatter.format(DB.getPrice("Total")) + " in register");
            }else{
                JOptionPane.showMessageDialog(null, "No money in register");
            }
        }
    }
}
