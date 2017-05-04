package edu.oswego.cs.bowler_owner.containers.panels;

import edu.oswego.cs.bowler_owner.components.JTopMainFrameButtons;
import edu.oswego.cs.bowler_owner.containers.frames.LoginFrame;
import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopMainFramePanel extends JPanel implements ActionListener {

    private MainFrame mainFrame;
    private JTopMainFrameButtons logOut, leagueMode;
    private JLabel currentMode;

    public TopMainFramePanel(MainFrame mF){
        setLayout(new MigLayout("", "[][grow,fill][][grow,fill][]", "[grow,fill]"));

        mainFrame = mF;

        Color backgroundColor = Color.decode("#666666");
        setBackground(backgroundColor);

        add(leagueMode = new JTopMainFrameButtons("Switch to League Mode"), "cell 0 0");

        Color topScreenColors = Color.decode("#000000");
        add(currentMode = new JLabel("Regular Mode", SwingConstants.CENTER), "cell 2 0, pad 0 -10 0 10");
        currentMode.setBackground(topScreenColors);
        currentMode.setOpaque(true);
        currentMode.setForeground(Color.white);

        add(logOut = new JTopMainFrameButtons("Log Out"), "cell 4 0");

        leagueMode.addActionListener(this);
        logOut.addActionListener(this);
    }

    public String getLeagueMode(){
        return currentMode.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("Switch to League Mode")) {
            leagueMode.setText("Switch to Regular Mode");
            currentMode.setText("League Mode");
            CardLayout cardLayout = (CardLayout) mainFrame.getCardsLayout().getLayout();
            cardLayout.show(mainFrame.getCardsLayout(), "LeaguePanel");
        }
        else if (((JButton) e.getSource()).getText().equals("Switch to Regular Mode")) {
            leagueMode.setText("Switch to League Mode");
            currentMode.setText("Regular Mode");
            CardLayout cardLayout = (CardLayout) mainFrame.getCardsLayout().getLayout();
            cardLayout.show(mainFrame.getCardsLayout(), "NonLeaguePanel");
        }
        else if(((JButton)e.getSource()).getText().equals("Log Out")){
            mainFrame.setVisible(false);
            final LoginFrame logInFrame = new LoginFrame();
            SwingUtilities.invokeLater(() -> logInFrame.setVisible(true));
        }
    }
}
