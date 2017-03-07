package edu.oswego.cs.bowler;

import com.google.gson.Gson;
import edu.oswego.cs.bowler.models.ScoreFrame;
import edu.oswego.cs.bowler.models.ScoreTable;
import edu.oswego.cs.bowler.models.UserFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class ClientServer {

    // static Map<String, String> players = new HashMap<>();
    static ArrayList<String> players = new ArrayList<>();

    public static void main(String[] args) {
        final GUI gui = new GUI();
        SwingUtilities.invokeLater(() -> gui.setVisible(true));

        get("/", (req, res) -> {
            res.type("application/json");
            return 200;
        });

        get("/add/player/:name", (req, res) -> {
            res.type("text");
            if(!req.params("name").equals("") && !players.contains(req.params("name"))) {
                players.add(req.params("name"));
                gui.addPlayer(req.params("name"));
                return 200;
            }
            return 404;
        });

        get("/remove/player/:name", (req, res) -> {
            res.type("text");
            if(!req.params("name").equals("") && players.contains(req.params("name"))) {
                players.remove(req.params("name"));
                gui.removePlayer(req.params("name"));
                return 200;
            }
            return 404;
        });

        get("/players", (req, res) -> {
            Map<String, String> map = new HashMap<>();
            int i = 1;
            for(String name : players) {
                map.put("player" + i, name);
                i++;
            }
            Gson gson = new Gson();
            res.type("application/json");
            return gson.toJson(map);
        });

        get("/iplocator", (req, res) -> {
            final IP ip = new IP();
            SwingUtilities.invokeLater(() -> ip.setVisible(true));
            return 200;
        });

        get("/scoretable", (req, res) -> {
            res.type("application/json");
            Gson gson = new Gson();

            UserFrame user1 = new UserFrame();
            user1.setName("Sam");
            user1.setFrameValue("100");
            UserFrame user2 = new UserFrame();
            user2.setName("Chris");
            user2.setFrameValue("200");
            UserFrame user3 = new UserFrame();
            user3.setName("Guy");
            user3.setFrameValue("69");
            UserFrame user4 = new UserFrame();
            user4.setName("Banana");
            user4.setFrameValue("420");
            List<UserFrame> frameUsers = new ArrayList<>();
            frameUsers.add(user1);
            frameUsers.add(user2);
            frameUsers.add(user3);
            frameUsers.add(user4);

            ScoreFrame frame1 = new ScoreFrame();
            frame1.setUserFrames(frameUsers);
            frame1.setFrameName("Frame 1");
            ScoreFrame frame2 = new ScoreFrame();
            frame2.setUserFrames(frameUsers);
            frame2.setFrameName("Frame 2");
            ScoreFrame frame3 = new ScoreFrame();
            frame3.setUserFrames(frameUsers);
            frame3.setFrameName("Frame 3");
            ScoreFrame frame4 = new ScoreFrame();
            frame4.setUserFrames(frameUsers);
            frame4.setFrameName("Frame 4");
            ScoreFrame frame5 = new ScoreFrame();
            frame5.setUserFrames(frameUsers);
            frame5.setFrameName("Frame 5");

            List<ScoreFrame> scoreFrames = new ArrayList<>();
            scoreFrames.add(frame1);
            scoreFrames.add(frame2);
            scoreFrames.add(frame3);
            scoreFrames.add(frame4);
            scoreFrames.add(frame5);

            ScoreTable table = new ScoreTable();
            table.setLeagueMode(false);
            table.setScoreFrames(scoreFrames);

            return gson.toJson(table);
        });
    }
}