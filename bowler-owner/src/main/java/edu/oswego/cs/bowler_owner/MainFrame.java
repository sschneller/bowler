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

    MainFrame() {
        setTitle("Owner Station");
        setLayout(new MigLayout("", "[grow,fill][]", "[][grow,fill]"));

        //FIX AT LATER DATE TO TAKE INTO ACCOUNT TOOLBAR
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setResizable(false);

        setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("bowling-ball.png")).getImage());
        Color backgroundColor = Color.decode("#666666");
        getContentPane().setBackground(backgroundColor);

        add(topMainFrame = new TopMainFramePanel(this), "span, growx");
        add(sideMainFrame = new SideMainFramePanel(this), "cell 1 1, growy");

        cards = new JPanel(new CardLayout());
        cards.add(nonPanel = new NonLeagueLanePanel(), "NonLeaguePanel");
        cards.add(leaguePanel = new LeagueLanePanel(), "LeaguePanel");
        add(cards, "cell 0 1");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel getCardsLayout(){
        return cards;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
