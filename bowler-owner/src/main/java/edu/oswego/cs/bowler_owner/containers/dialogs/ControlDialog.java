package edu.oswego.cs.bowler_owner.containers.dialogs;

import com.google.gson.Gson;
import edu.oswego.cs.bowler_owner.containers.frames.LaneControlFrame;
import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import edu.oswego.cs.bowler_owner.containers.panels.LeagueLanePanel;
import edu.oswego.cs.bowler_owner.containers.panels.NonLeagueLanePanel;
import edu.oswego.cs.bowler_owner.models.Connection;
import edu.oswego.cs.bowler_owner.models.ScoreTable;
import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ControlDialog extends JDialog implements ActionListener {

    private final String USER_AGENT = "Mozilla/5.0";
    private JTextField jTextField;
    private JList<String> iplist;
    private JButton openMenu, createAccount, exitManagement;
    private JButton send;
    private DefaultListModel model = new DefaultListModel();
    private MainFrame rootFrame;
    private NonLeagueLanePanel nonPanel;
    private LeagueLanePanel leaguePanel;

    /**
     * Empty constructor for the Frame.  Loads the DB, changes the necessary properties to the frame, and adds all
     * components to the frame.  It then pulls all the respective connection IPs stored in the DB, and populates the
     * JList with it.
     *
     * @see JList
     */
    public ControlDialog(MainFrame root, NonLeagueLanePanel nlP, LeagueLanePanel llP) {

        super(root, Dialog.ModalityType.DOCUMENT_MODAL);
        setTitle("System Controls");
        setLayout(new MigLayout("", "[grow,fill][]", "[][grow,fill][]"));
        setSize(400, 200);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("bowling-ball.png")).getImage());
        rootFrame = root;
        nonPanel = nlP;
        leaguePanel = llP;
        rootFrame.setDialogShown(true);

        add(jTextField = new JTextField(""), "growx");
        add(send = new JButton("SEND"), "wrap");
        send.addActionListener(this);

        addConnectionsToListModel();
        iplist = new JList<>(model);
        add(iplist, "span, wrap");
        JPanel commands = new JPanel(new MigLayout("", "[grow,fill, 50%][grow,fill, 50%]", "[grow,fill][grow,fill]"));
        openMenu = new JButton("Lane Information");
        openMenu.addActionListener(this);
        commands.add(openMenu);
        createAccount = new JButton("Create New Account");
        createAccount.addActionListener(e12 -> {
            this.setVisible(false);
            new CreateAccountDialog(this).setVisible(true);
        });
        commands.add(createAccount, "wrap");
        exitManagement = new JButton("Close");
        exitManagement.addActionListener(e -> {
            this.setVisible(false);
            rootFrame.setDialogShown(false);
            rootFrame.repaint();
        });
        commands.add(exitManagement, "span");
        add(commands, "span");

        setUndecorated(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getText().equals("SEND")) {
            System.out.println("Testing 1 - Send Http GET request");
            boolean inArray = false;
            for(int i = 0; i < model.getSize(); i++) {
                if(((String)model.getElementAt(i).toString()).contains(jTextField.getText())) {
                    inArray = true;
                }
            }
            if(!inArray) {
                try {
                    sendGet(jTextField.getText());
                    DB.insertConnection(new Connection(DB.getCurrValBySeq("laneid"), jTextField.getText()));
                    DB.incrementSequence("laneid");
                    addConnectionsToListModel();
                    iplist.repaint();
                    nonPanel.updateLanes();
                    leaguePanel.updateLanes();
                }
                catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        else {
            LaneControlFrame laneControlFrame = new LaneControlFrame(this, "DATA", ((Connection)model.getElementAt(iplist.getSelectedIndex())).getLaneid(), ((Connection)model.getElementAt(iplist.getSelectedIndex())).getIp());
            laneControlFrame.setVisible(true);
        }
    }

    /**
     * Takes the url of the pi, and attempts to send a get request and receive a response.  This is to determine if the
     * pi is actually reachable as an endpoint.
     *
     * @param s String of the url portion of the address
     * @throws Exception
     */
    protected void sendGet(String s) throws Exception {
        String url = "http://" + s + ":4567/";

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
    }

    /**
     * Sends gets to the provided url, along with a concatenated string of params and their values.
     *
     * @param s String representation of the url
     * @param p String representation of the parameters and their values
     * @throws Exception
     */
    public void sendGet(String s, String p) throws Exception {
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
    }
}
