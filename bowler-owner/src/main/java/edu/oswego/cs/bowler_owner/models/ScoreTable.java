package edu.oswego.cs.bowler_owner.models;

import java.util.*;

public class ScoreTable {
    private boolean isLeagueMode;
    private Map<Player, List<BFrame>> playerListMap = new HashMap<>();

    public boolean isLeagueMode() {
        return isLeagueMode;
    }

    public void setLeagueMode(boolean leagueMode) {
        isLeagueMode = leagueMode;
    }

    public Set<Player> getPlayers() {
        return playerListMap.keySet();
    }

    public List<BFrame> getScores(Player p) {
        return playerListMap.get(p);
    }

    public void insertPlayer(Player p) {
        List<BFrame> emptyFrames = new ArrayList<>();
        for(int i = 0; i < 10; i++) emptyFrames.add(new PartitionedFrame("", "", ""));
        for(int i = 0; i < 3; i++) emptyFrames.add(new FullFrame(""));
        playerListMap.put(p, emptyFrames);
    }

    public void insertScore(Player p, String score, int index) {
        List<BFrame> updatedList = playerListMap.get(p);
        updatedList.set(index, playerListMap.get(p).get(index).insertScore(p, score));
        playerListMap.replace(p, updatedList);
    }
}
