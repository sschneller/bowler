package edu.oswego.cs.bowler_owner;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private TopMainFramePanel topMainFrame;
    private SideMainFramePanel sideMainFrame;
    private JPanel cards;
    private NonLeagueLanePanel nonPanel;
    private LeagueLanePanel leaguePanel;
    private LaneInfoPanel infoPanel;
    private String userName;
    private boolean dialogShown = false;

    MainFrame(String user) {
        setTitle("Bowling Alley");
        setLayout(new MigLayout("", "[grow,fill][]", "[][grow,fill]"));

        cards = new JPanel(new CardLayout());
        userName = user;
        nonPanel = new NonLeagueLanePanel(this);
        leaguePanel = new LeagueLanePanel(this);

        //FIX AT LATER DATE TO TAKE INTO ACCOUNT TOOLBAR
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setResizable(false);

        setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("bowling-ball.png")).getImage());
        Color backgroundColor = Color.decode("#666666");
        getContentPane().setBackground(backgroundColor);

        add(topMainFrame = new TopMainFramePanel(this), "span, growx");
        add(sideMainFrame = new SideMainFramePanel(this, nonPanel, leaguePanel, userName), "cell 1 1, growy");

        infoPanel = new LaneInfoPanel(this, topMainFrame);

        cards.add(nonPanel, "NonLeaguePanel");
        cards.add(leaguePanel, "LeaguePanel");
        cards.add(infoPanel, "LaneInfoPanel");
        add(cards, "cell 0 1");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel getCardsLayout(){
        return cards;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setDialogShown(boolean state) {
        dialogShown = state;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(dialogShown) {
            g.setColor(new Color(128, 128, 128, 128));
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }
}
