package edu.oswego.cs.bowler_owner.containers.panels;

import com.google.gson.Gson;
import edu.oswego.cs.bowler_owner.components.JLaneButton;
import edu.oswego.cs.bowler_owner.components.JNonLaneButtonInPanel;
import edu.oswego.cs.bowler_owner.components.JScoreTable;
import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import edu.oswego.cs.bowler_owner.models.Connection;
import edu.oswego.cs.bowler_owner.models.ScoreTable;
import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NonLeagueLanePanel extends JPanel implements ActionListener {

    private ArrayList<JLaneButton> lanes = new ArrayList<>();
    private JNonLaneButtonInPanel lanesControl, pinsettersControl;
    private DefaultListModel model = new DefaultListModel();
    private MainFrame mainFrame;

    public NonLeagueLanePanel(MainFrame root) {
        setLayout(new MigLayout());
        Color backgroundColor = Color.decode("#B3B3B3");
        setBackground(backgroundColor);
        mainFrame = root;

        addConnectionsToListModel();
        for(int i = 0; i < model.size(); i++) {
            JLaneButton lane = new JLaneButton(model.get(i).toString(), ((Connection)model.get(i)).getIp());
            lane.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout)mainFrame.getCardsLayout().getLayout();
                cardLayout.show(mainFrame.getCardsLayout(), "LaneInfoPanel");
                Gson gson = new Gson();
                try {
                    if(mainFrame.getLaneInfoPanel().getComponentCount() > 1) {
                        mainFrame.getLaneInfoPanel().remove(1);
                    }
                    mainFrame.getLaneInfoPanel().add(new JScoreTable(gson.fromJson(mainFrame.sendGet(lane.ip, "/scoretable"), ScoreTable.class)), "span, wrap");
                }
                catch(Exception e1) {
                    e1.printStackTrace();
                }
            });
            lanes.add(lane);
            add(lane, "wrap");
        }

        add(lanesControl = new JNonLaneButtonInPanel("Turn Lanes On"), "cell 0 4");
        add(pinsettersControl = new JNonLaneButtonInPanel("Pinsetters On"), "cell 2 4");

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

    public void updateLanes() {
        for(int i = 0; i < lanes.size(); i++) {
            remove(lanes.get(i));
        }
        lanes.clear();

        addConnectionsToListModel();
        for(int i = 0; i < model.size(); i++) {
            JLaneButton lane = new JLaneButton(model.get(i).toString(), ((Connection)model.get(i)).getIp());
            lane.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout)mainFrame.getCardsLayout().getLayout();
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
