package edu.oswego.cs.bowler_owner.models;

import java.util.ArrayList;

public class FrameConnector {
    public ArrayList<Player> players;
    public ArrayList<Score> scoreList;

    public FrameConnector() {
        players = new ArrayList<>();
        scoreList = new ArrayList<>();
    }
}
