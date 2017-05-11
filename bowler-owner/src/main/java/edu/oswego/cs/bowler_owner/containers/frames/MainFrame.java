package edu.oswego.cs.bowler_owner.containers.frames;

import edu.oswego.cs.bowler_owner.containers.panels.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainFrame extends JFrame implements ActionListener {

    private final String USER_AGENT = "Mozilla/5.0";
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

    public JPanel getCardsLayout() {
        return cards;
    }

    public LaneInfoPanel getLaneInfoPanel() {
        return infoPanel;
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

    /**
     * Sends gets to the provided url, along with a concatenated string of params and their values.
     *
     * @param s String representation of the url
     * @param p String representation of the parameters and their values
     * @throws Exception
     */
    public String sendGet(String s, String p) throws Exception {
        String url = "http://" + s + ":4567" + p;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        // add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());
        return response.toString();
    }
}
