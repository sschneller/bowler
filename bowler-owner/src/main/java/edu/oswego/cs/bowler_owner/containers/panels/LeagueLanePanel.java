package edu.oswego.cs.bowler_owner.containers.panels;

import edu.oswego.cs.bowler_owner.components.JLaneButton;
import edu.oswego.cs.bowler_owner.components.JNonLaneButtonInPanel;
import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import edu.oswego.cs.bowler_owner.models.Connection;
import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeagueLanePanel extends JPanel implements ActionListener {

    private ArrayList<JLaneButton> lanes = new ArrayList<>();
    private DefaultListModel model = new DefaultListModel();
    private JNonLaneButtonInPanel lanesControl, pinsettersControl, absentTeams;
    private MainFrame mainFrame;

    public LeagueLanePanel(MainFrame root) {

        setLayout(new MigLayout());
        Color backgroundColor = Color.decode("#B3B3B3");
        setBackground(backgroundColor);
        mainFrame = root;

        addConnectionsToListModel();
        for(int i = 0; i < model.size(); i++){
            JLaneButton lane = new JLaneButton(model.get(i).toString());
            lane.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout) mainFrame.getCardsLayout().getLayout();
                cardLayout.show(mainFrame.getCardsLayout(), "LaneInfoPanel");
            });
            lanes.add(lane);
            add(lane, "wrap");
        }

        add(lanesControl = new JNonLaneButtonInPanel("Turn Lanes On"));
        add(pinsettersControl = new JNonLaneButtonInPanel("Pinsetters On"));
        add(absentTeams = new JNonLaneButtonInPanel("Absent Teams"));
    }

    /**
     * Retrieves all lanes that have been stored in the DB and adds them to the ListModel
     */
    private void addConnectionsToListModel() {
        model.removeAllElements();
        for(Connection c : DB.getStoredConnections()) {
            model.addElement(c);
        }
    }

    public void updateLanes(){
        for(int i = 0; i < lanes.size(); i++){
            remove(lanes.get(i));
        }
        lanes.clear();

        addConnectionsToListModel();
        for(int i = 0; i < model.size(); i++){
            JLaneButton lane = new JLaneButton(model.get(i).toString());
            lane.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout) mainFrame.getCardsLayout().getLayout();
                cardLayout.show(mainFrame.getCardsLayout(), "LaneInfoPanel");
            });
            lanes.add(lane);
            add(lane, "wrap");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
