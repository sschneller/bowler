package edu.oswego.cs.bowler;

import com.google.gson.Gson;
import edu.oswego.cs.bowler.models.Player;
import edu.oswego.cs.bowler.models.ScoreTable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class ClientServer {

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

            ScoreTable scoreTable = new ScoreTable();

            Player p = new Player();
            p.setPlayer_name("CHRIS");
            scoreTable.insertPlayer(p);

            Player p2 = new Player();
            p2.setPlayer_name("SAM");
            scoreTable.insertPlayer(p2);

            scoreTable.insertScore(p, "3", 0);
            scoreTable.insertScore(p, "7", 0);
            scoreTable.insertScore(p, "2", 1);
            scoreTable.insertScore(p, "2", 1);
            scoreTable.insertScore(p, "7", 2);
            scoreTable.insertScore(p, "1", 2);
            scoreTable.insertScore(p, "9", 3);
            scoreTable.insertScore(p, "0", 3);
            scoreTable.insertScore(p, "5", 4);
            scoreTable.insertScore(p, "5", 4);
            scoreTable.insertScore(p, "2", 5);
            scoreTable.insertScore(p, "6", 5);
            scoreTable.insertScore(p, "1", 6);
            scoreTable.insertScore(p, "3", 6);
            scoreTable.insertScore(p, "10", 7);
            scoreTable.insertScore(p, "3", 8);
            scoreTable.insertScore(p, "4", 8);
            scoreTable.insertScore(p, "1", 9);
            scoreTable.insertScore(p, "9", 9);
            scoreTable.insertScore(p, "10", 9);
            scoreTable.insertScore(p, "100", 10);
            scoreTable.insertScore(p, "200", 11);
            scoreTable.insertScore(p, "300", 12);

            scoreTable.insertScore(p2, "3", 0);
            scoreTable.insertScore(p2, "7", 0);
            scoreTable.insertScore(p2, "10", 1);
            scoreTable.insertScore(p2, "7", 2);
            scoreTable.insertScore(p2, "1", 2);
            scoreTable.insertScore(p2, "9", 3);
            scoreTable.insertScore(p2, "0", 3);
            scoreTable.insertScore(p2, "5", 4);
            scoreTable.insertScore(p2, "5", 4);
            scoreTable.insertScore(p2, "2", 5);
            scoreTable.insertScore(p2, "6", 5);
            scoreTable.insertScore(p2, "1", 6);
            scoreTable.insertScore(p2, "3", 6);
            scoreTable.insertScore(p2, "1", 7);
            scoreTable.insertScore(p2, "3", 7);
            scoreTable.insertScore(p2, "1", 8);
            scoreTable.insertScore(p2, "3", 8);
            scoreTable.insertScore(p2, "1", 9);
            scoreTable.insertScore(p2, "3", 9);

            return gson.toJson(scoreTable);
        });
    }
}