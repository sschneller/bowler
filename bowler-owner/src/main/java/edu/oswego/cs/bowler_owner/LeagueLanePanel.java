package edu.oswego.cs.bowler_owner;

import edu.oswego.cs.bowler_owner.models.Connection;
import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeagueLanePanel extends JPanel implements ActionListener {

    private ArrayList<LaneButton> lanes = new ArrayList<>();
    private DefaultListModel model = new DefaultListModel();
    private NonLaneButtonInPanel lanesControl, pinsettersControl, absentTeams;
    private MainFrame mainFrame;

    LeagueLanePanel(MainFrame root) {

        setLayout(new MigLayout());
        Color backgroundColor = Color.decode("#B3B3B3");
        setBackground(backgroundColor);
        mainFrame = root;

        addConnectionsToListModel();
        for(int i = 0; i < model.size(); i++){
            LaneButton lane = new LaneButton(model.get(i).toString());
            lane.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout) mainFrame.getCardsLayout().getLayout();
                cardLayout.show(mainFrame.getCardsLayout(), "LaneInfoPanel");
            });
            lanes.add(lane);
            add(lane, "wrap");
        }

        add(lanesControl = new NonLaneButtonInPanel("Turn Lanes On"));
        add(pinsettersControl = new NonLaneButtonInPanel("Pinsetters On"));
        add(absentTeams = new NonLaneButtonInPanel("Absent Teams"));
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

    private void updateLanes(){
        for(int i = 0; i < lanes.size(); i++){
            remove(lanes.get(i));
        }
        lanes.clear();

        addConnectionsToListModel();
        for(int i = 0; i < model.size(); i++){
            LaneButton lane = new LaneButton(model.get(i).toString());
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
