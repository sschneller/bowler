package edu.oswego.cs.bowler_owner;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel  extends JFrame implements ActionListener {

    private TopMainFrameButtons logOut, leagueMode;
    private SideButtonInMainFrame safeMode, setDefaults, ownerFeatures, cashOut;
    private JLabel currentMode;
    private JPanel cards;
    private NonLeagueLanePanel nonPanel;
    private LeagueLanePanel leaguePanel;

    MainPanel() {
        setTitle("Owner Station");
        setLayout(new MigLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("bowling-ball.png")).getImage());
        Color backgroundColor = Color.decode("#666666");
        getContentPane().setBackground(backgroundColor);

        add(leagueMode = new TopMainFrameButtons("Switch to League Mode"), "cell 0 0");
        add(logOut = new TopMainFrameButtons("Log Out"), "cell 2 0");

        Color topScreenColors = Color.decode("#000000");
        add(currentMode = new JLabel("Regular Mode"), "cell 1 0");
        currentMode.setBackground(topScreenColors);
        currentMode.setOpaque(true);
        currentMode.setForeground(Color.white);

        JPanel card1 = new JPanel();
        card1.add(nonPanel = new NonLeagueLanePanel());
        JPanel card2 = new JPanel();
        card2.add(leaguePanel = new LeagueLanePanel());
        cards = new JPanel(new CardLayout());
        cards.add(card1, "NonLeaguePanel");
        cards.add(card2, "LeaguePanel");
        add(cards, "cell 0 1");

        add(safeMode = new SideButtonInMainFrame("Safe Mode"), "cell 2 1");
        add(setDefaults = new SideButtonInMainFrame("Set Defaults"), "cell 2 2");
        add(ownerFeatures = new SideButtonInMainFrame("Owner Features"), "cell 2 3");
        add(cashOut = new SideButtonInMainFrame("Cash Out"), "cell 2 4");

        leagueMode.addActionListener(this);
        logOut.addActionListener(this);
        safeMode.addActionListener(this);
        setDefaults.addActionListener(this);
        ownerFeatures.addActionListener(this);
        cashOut.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getText().equals("Switch to League Mode")){
            leagueMode.setText("Switch to Regular Mode");
            currentMode.setText("League Mode");
            CardLayout cardLayout = (CardLayout) cards.getLayout();
            cardLayout.show(cards, "LeaguePanel");
        }
        else if(((JButton)e.getSource()).getText().equals("Switch to Regular Mode")){
            leagueMode.setText("Switch to League Mode");
            currentMode.setText("Regular Mode");
            CardLayout cardLayout = (CardLayout) cards.getLayout();
            cardLayout.show(cards, "NonLeaguePanel");
        }
        else if(((JButton)e.getSource()).getText().equals("Log Out")){
            this.setVisible(false);
            final LoginFrame logInFrame = new LoginFrame();
            SwingUtilities.invokeLater(() -> logInFrame.setVisible(true));
        }
        else if(((JButton)e.getSource()).getText().equals("Safe Mode")){

        }
        else if(((JButton)e.getSource()).getText().equals("Set Defaults")){

        }
        else if(((JButton)e.getSource()).getText().equals("Owner Features")){

        }
        else if(((JButton)e.getSource()).getText().equals("Cash Out")){

        }

    }
}
