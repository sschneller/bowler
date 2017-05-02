package edu.oswego.cs.bowler_owner;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class LaneInfoPanel extends JPanel {

    private MainFrame mainFrame;
    private TopMainFramePanel topPanel;

    LaneInfoPanel(MainFrame root, TopMainFramePanel tPanel){
        setLayout(new MigLayout());
        Color backgroundColor = Color.decode("#B3B3B3");
        setBackground(backgroundColor);
        mainFrame = root;
        topPanel = tPanel;

        NonLaneButtonInPanel back = new NonLaneButtonInPanel("Back");
        back.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) mainFrame.getCardsLayout().getLayout();
            if(tPanel.getLeagueMode().equals("Regular Mode")) {
                cardLayout.show(mainFrame.getCardsLayout(), "NonLeaguePanel");
            }
            else{
                cardLayout.show(mainFrame.getCardsLayout(), "LeaguePanel");
            }
        });
        add(back, "cell 1 0");
    }

}
