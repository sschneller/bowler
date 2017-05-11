package edu.oswego.cs.bowler_owner.containers.panels;

import edu.oswego.cs.bowler_owner.components.JNonLaneButtonInPanel;
import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class LaneInfoPanel extends JPanel {

    private MainFrame mainFrame;
    private TopMainFramePanel topPanel;
    private LaneInfoButtonsPanel infoButtons;

    public LaneInfoPanel(MainFrame root, TopMainFramePanel tPanel) {
        setLayout(new MigLayout("", "[grow,fill]", "[][grow,fill][grow, fill]"));
        Color backgroundColor = Color.decode("#B3B3B3");
        setBackground(backgroundColor);
        mainFrame = root;
        topPanel = tPanel;
        infoButtons = new LaneInfoButtonsPanel(mainFrame,topPanel,this);



        JNonLaneButtonInPanel back = new JNonLaneButtonInPanel("Back");
        back.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout)mainFrame.getCardsLayout().getLayout();
            if(topPanel.getLeagueMode().equals("Regular Mode")) {
                cardLayout.show(mainFrame.getCardsLayout(), "NonLeaguePanel");
            }
            else {
                cardLayout.show(mainFrame.getCardsLayout(), "LeaguePanel");
            }
        });

        add(infoButtons, "wrap");

    }
}
