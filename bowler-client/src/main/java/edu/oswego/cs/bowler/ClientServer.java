package edu.oswego.cs.bowler;

import com.google.gson.Gson;
import edu.oswego.cs.bowler.models.Player;
import edu.oswego.cs.bowler.models.ScoreTable;

import javax.swing.*;

import static spark.Spark.get;

public class ClientServer {
    static final GUI gui = new GUI();
    static ScoreTable scoreTable = new ScoreTable();
    static JScoreTable jScoreTable = new JScoreTable(scoreTable);

    public static void main(String[] args) {
        gui.add(jScoreTable);
        SwingUtilities.invokeLater(() -> gui.setVisible(true));

        get("/", (req, res) -> {
            res.type("application/json");
            jScoreTable.repaint();
            return 200;
        });

        get("/league/create_table/:tabledata", (req, res) -> {
            res.type("text");
            Gson gson = new Gson();
            jScoreTable.scoreTable = gson.fromJson(req.params(":tabledata"), ScoreTable.class);
            jScoreTable.repaint();
            return 200;
        });

        get("/add/player/:name", (req, res) -> {
            res.type("text");
            Player tempP = new Player();
            tempP.setPlayer_name(req.params(":name"));
            scoreTable.insertPlayer(tempP);
            jScoreTable.repaint();
            return 200;
        });

        get("/update/player/*/to/*", (req, res) -> {
            res.type("text");
            Player oldP = new Player();
            oldP.setPlayer_name(req.splat()[0]);
            Player newP = new Player();
            newP.setPlayer_name(req.splat()[1]);
            scoreTable.modifyPlayer(oldP, newP);
            jScoreTable.repaint();
            return 200;
        });

        get("/add/score/to/:player/:score", (req, res) -> {
            res.type("text");
            Player p = new Player();
            p.setPlayer_name(req.params(":player"));
            scoreTable.insertScore(p, req.params(":score"));
            jScoreTable.repaint();
            return 200;
        });

//        get("/remove/player/:name", (req, res) -> {
//            res.type("text");
//            if(!req.params("name").equals("") && players.contains(req.params("name"))) {
//                players.remove(req.params("name"));
//                gui.removePlayer(req.params("name"));
//                return 200;
//            }
//            return 404;
//        });

        get("/players", (req, res) -> {
            Gson gson = new Gson();
            res.type("application/json");
            return gson.toJson(scoreTable.getPlayers());
        });

        get("/iplocator", (req, res) -> {
            final IP ip = new IP();
            SwingUtilities.invokeLater(() -> ip.setVisible(true));
            return 200;
        });

        get("/scoretable", (req, res) -> {
            res.type("application/json");
            Gson gson = new Gson();

            // ScoreTable scoreTable = new ScoreTable();

//            Player p = new Player();
//            p.setPlayer_name("CHRIS");
//            scoreTable.insertPlayer(p);
//
//            Player p2 = new Player();
//            p2.setPlayer_name("SAM");
//            scoreTable.insertPlayer(p2);
//
//            scoreTable.insertScore(p, "3");
//            scoreTable.insertScore(p, "7");
//            scoreTable.insertScore(p, "2");
//            scoreTable.insertScore(p, "2");
//            scoreTable.insertScore(p, "7");
//            scoreTable.insertScore(p, "1");
//            scoreTable.insertScore(p, "9");
//            scoreTable.insertScore(p, "0");
//            scoreTable.insertScore(p, "5");
//            scoreTable.insertScore(p, "5");
//            scoreTable.insertScore(p, "2");
//            scoreTable.insertScore(p, "6");
//            scoreTable.insertScore(p, "1");
//            scoreTable.insertScore(p, "3");
//            scoreTable.insertScore(p, "10");
//            scoreTable.insertScore(p, "3");
//            scoreTable.insertScore(p, "4");
//            scoreTable.insertScore(p, "1");
//            scoreTable.insertScore(p, "9");
//            scoreTable.insertScore(p, "10");
////            scoreTable.insertScore(p, "100");
////            scoreTable.insertScore(p, "200");
////            scoreTable.insertScore(p, "300");
//
//            scoreTable.insertScore(p2, "3");
//            scoreTable.insertScore(p2, "7");
//            scoreTable.insertScore(p2, "10");
//            scoreTable.insertScore(p2, "7");
//            scoreTable.insertScore(p2, "1");
//            scoreTable.insertScore(p2, "9");
//            scoreTable.insertScore(p2, "0");
//            scoreTable.insertScore(p2, "5");
//            scoreTable.insertScore(p2, "5");
//            scoreTable.insertScore(p2, "2");
//            scoreTable.insertScore(p2, "6");
//            scoreTable.insertScore(p2, "1");
//            scoreTable.insertScore(p2, "3");
//            scoreTable.insertScore(p2, "1");
//            scoreTable.insertScore(p2, "3");
//            scoreTable.insertScore(p2, "1");
//            scoreTable.insertScore(p2, "3");
//            scoreTable.insertScore(p2, "1");
//            scoreTable.insertScore(p2, "3");

            return gson.toJson(scoreTable);
        });
    }
}