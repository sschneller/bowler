package edu.oswego.cs.bowler.models;

import java.util.List;

public class ScoreTable {
    private boolean isLeagueMode;
    private List<ScoreFrame> scoreFrames;

    public boolean isLeagueMode() {
        return isLeagueMode;
    }

    public void setLeagueMode(boolean leagueMode) {
        isLeagueMode = leagueMode;
    }

    public List<ScoreFrame> getScoreFrames() {
        return scoreFrames;
    }

    public void setScoreFrames(List<ScoreFrame> scoreFrames) {
        this.scoreFrames = scoreFrames;
    }
}
