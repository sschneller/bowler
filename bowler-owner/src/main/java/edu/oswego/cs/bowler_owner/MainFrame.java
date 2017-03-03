package edu.oswego.cs.bowler_owner;

import edu.oswego.cs.bowler_owner.models.Connection;
import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainFrame extends JFrame implements ActionListener {

    private final String USER_AGENT = "Mozilla/5.0";
    private JTextField jTextField;
    private JList<String> iplist;
    private JButton openMenu;
    private DefaultListModel model = new DefaultListModel();

    private static final String HOST = "ds013486.mlab.com";
    private static final int PORT = 13486;

    public static void main(String[] args) {
        final MainFrame mainFrame = new MainFrame();
        SwingUtilities.invokeLater(() -> mainFrame.setVisible(true));
    }

    private MainFrame() {
        DB.init(HOST, PORT);

        setTitle("Owner Station");
        setLayout(new MigLayout("", "[grow,fill][]", "[][grow,fill][]"));
        setSize(400, 200);
        setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("bowling-ball.png")).getImage());

        add(jTextField = new JTextField(""), "growx");
        JButton send;
        add(send = new JButton("SEND"), "wrap");
        send.addActionListener(this);

        addConnectionsToListModel();
        iplist = new JList<>(model);
        add(iplist, "span, wrap");
        openMenu = new JButton("OPEN CONTROLS");
        openMenu.addActionListener(this);
        add(openMenu, "span");
    }
    
    /**
     * Retrieves all lanes that have been stored in the DB and adds them to the ListModel
     * Will change to be decoupled from the Swing itself
     */
    private void addConnectionsToListModel() {
        model.removeAllElements();
        for(Connection c : DB.getStoredConnections()) {
            model.addElement(c);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getText().equals("SEND")) {
            System.out.println("Testing 1 - Send Http GET request");
            boolean inArray = false;
            for (int i = 0; i < model.getSize(); i++) {
                if (((String) model.getElementAt(i)).contains(jTextField.getText())) {
                    inArray = true;
                }
            }
            if (!inArray) {
                try {
                    sendGet(jTextField.getText());
                    DB.insertConnection(new Connection(DB.getCurrValBySeq("laneid"), jTextField.getText()));
                    DB.incrementSequence("laneid");
                    addConnectionsToListModel();
                    iplist.repaint();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        else {
            LaneControlFrame laneControlFrame = new LaneControlFrame(this, "DATA", ((Connection)model.getElementAt(iplist.getSelectedIndex())).getLaneid(), ((Connection)model.getElementAt(iplist.getSelectedIndex())).getIp());
            laneControlFrame.setVisible(true);
        }
    }

    protected void sendGet(String s) throws Exception {
        String url = "http://" + s + ":4567/";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }

    protected void sendGet(String s, String p) throws Exception {
        String url = "http://" + s + ":4567" + p;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }
}