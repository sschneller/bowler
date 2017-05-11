package edu.oswego.cs.bowler_owner.containers.panels;

import edu.oswego.cs.bowler_owner.components.JNonLaneButtonInPanel;
import edu.oswego.cs.bowler_owner.containers.dialogs.CheckOutDialog;
import edu.oswego.cs.bowler_owner.containers.dialogs.ControlDialog;
import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaneInfoButtonsPanel extends JPanel implements ActionListener {

    private MainFrame mainFrame;
    private TopMainFramePanel topPanel;
    private LaneInfoPanel laneInfoPanel;
    private JNonLaneButtonInPanel back, addPlayer, changeName, insertScore, modifyScore, checkOut;

    public LaneInfoButtonsPanel(MainFrame root, TopMainFramePanel tPanel, LaneInfoPanel liPanel) {

        setLayout(new MigLayout("","[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill]","[grow, fill]"));
        mainFrame = root;
        topPanel = tPanel;
        laneInfoPanel = liPanel;
        Color backgroundColor = Color.decode("#B3B3B3");
        setBackground(backgroundColor);
        back = new JNonLaneButtonInPanel("Back");
        back.addActionListener(e -> {
            topPanel.setLeagueModeButtonTrue();
            CardLayout cardLayout = (CardLayout)mainFrame.getCardsLayout().getLayout();
            if(topPanel.getLeagueMode().equals("Regular Mode")) {
                cardLayout.show(mainFrame.getCardsLayout(), "NonLeaguePanel");
            }
            else {
                cardLayout.show(mainFrame.getCardsLayout(), "LeaguePanel");
            }
        });
        add(back);
        addPlayer = new JNonLaneButtonInPanel("Add Player");
        add(addPlayer);
        changeName = new JNonLaneButtonInPanel("Change Player Name");
        add(changeName);
        insertScore = new JNonLaneButtonInPanel("Insert Score");
        add(insertScore);
        modifyScore = new JNonLaneButtonInPanel("Modify Score");
        add(modifyScore);
        checkOut = new JNonLaneButtonInPanel("Check Out");
        checkOut.addActionListener(this);
        add(checkOut);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getText().equals("Check Out")) {
            final CheckOutDialog checkOutDialog = new CheckOutDialog(mainFrame);
            SwingUtilities.invokeLater(() -> checkOutDialog.setVisible(true));
        }
    }
}
