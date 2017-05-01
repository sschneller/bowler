package edu.oswego.cs.bowler_owner;

import com.google.gson.Gson;
import edu.oswego.cs.bowler_owner.components.JScoreTable;
import edu.oswego.cs.bowler_owner.models.ScoreTable;

import javax.swing.*;

public class TestFrame extends JFrame {

    TestFrame() {
        Gson gson = new Gson();
        String json = "{'isLeagueMode':false,'playerList':[{'playerid':0,'player_name':'CHRIS','on_team':0,'average':0,'total_pins':0,'total_games':0,'high_game':0,'high_series':0,'points_won':0,'points_lost':0},{'playerid':0,'player_name':'SAM','on_team':0,'average':0,'total_pins':0,'total_games':0,'high_game':0,'high_series':0,'points_won':0,'points_lost':0}],'frameList':[[{'type':'Partitioned','leftFrame':'3','rightFrame':'/','bottomFrame':'12'},{'type':'Partitioned','leftFrame':'2','rightFrame':'2','bottomFrame':'16'},{'type':'Partitioned','leftFrame':'7','rightFrame':'1','bottomFrame':'24'},{'type':'Partitioned','leftFrame':'9','rightFrame':'-','bottomFrame':'33'},{'type':'Partitioned','leftFrame':'5','rightFrame':'/','bottomFrame':'45'},{'type':'Partitioned','leftFrame':'2','rightFrame':'6','bottomFrame':'53'},{'type':'Partitioned','leftFrame':'1','rightFrame':'3','bottomFrame':'57'},{'type':'Partitioned','leftFrame':'','rightFrame':'X','bottomFrame':'74'},{'type':'Partitioned','leftFrame':'3','rightFrame':'4','bottomFrame':'81'},{'type':'Final','leftFrame':'1','centerFrame':'/','rightFrame':'X','bottomFrame':'101'},{'type':'Full','value':'100'},{'type':'Full','value':'200'},{'type':'Full','value':'300'}],[{'type':'Partitioned','leftFrame':'3','rightFrame':'/','bottomFrame':'20'},{'type':'Partitioned','leftFrame':'','rightFrame':'X','bottomFrame':'38'},{'type':'Partitioned','leftFrame':'7','rightFrame':'1','bottomFrame':'46'},{'type':'Partitioned','leftFrame':'9','rightFrame':'-','bottomFrame':'55'},{'type':'Partitioned','leftFrame':'5','rightFrame':'/','bottomFrame':'67'},{'type':'Partitioned','leftFrame':'2','rightFrame':'6','bottomFrame':'75'},{'type':'Partitioned','leftFrame':'1','rightFrame':'3','bottomFrame':'79'},{'type':'Partitioned','leftFrame':'1','rightFrame':'3','bottomFrame':'83'},{'type':'Partitioned','leftFrame':'1','rightFrame':'3','bottomFrame':'87'},{'type':'Final','leftFrame':'1','centerFrame':'3','rightFrame':'','bottomFrame':'91'},{'type':'Full','value':''},{'type':'Full','value':''},{'type':'Full','value':''}]]}";
        add(new JScoreTable(gson.fromJson(json, ScoreTable.class)));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
    }

    public static void main(String[] args) {
        final TestFrame mainFrame = new TestFrame();
        SwingUtilities.invokeLater(() -> mainFrame.setVisible(true));
    }
}
