package edu.oswego.cs.bowler_owner;

import edu.oswego.cs.bowler_owner.components.JSwitchBox;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class LaneControlFrame extends JFrame {
    private MainFrame parentFrame;
    private String title;
    private int lane;
    private String ip;
    private JLabel laneLabel;
    private JLabel ipLabel;
    private JTextField paramField;
    private JButton getButton;
    private JButton postButton;

    public LaneControlFrame(MainFrame pF, String t, int l, String i) {
        parentFrame = pF;
        title = t;
        lane = l;
        ip = i;

        setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("bowling-ball.png")).getImage());
        setTitle(title);
        setLayout(new MigLayout("", "[grow,fill][grow,fill]", "[grow,fill][][]"));

        add(new JSwitchBox("Free", "League"), "growx, wrap");
        laneLabel = new JLabel("Lane " + lane);
        add(laneLabel);
        ipLabel = new JLabel(ip);
        add(ipLabel, "wrap");

        paramField = new JTextField();
        add(paramField, "span, growx");

        getButton = new JButton("GET EXAMPLE");
        getButton.addActionListener(e12 -> {
            try {
                parentFrame.sendGet(ipLabel.getText(), paramField.getText());
            }
            catch(Exception e1) {
                e1.printStackTrace();
            }
        });
        add(getButton);
        postButton = new JButton("POST EXAMPLE");
        add(postButton, "wrap");

        pack();
    }
}
