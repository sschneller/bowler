package edu.oswego.cs.bowler_owner.models;

import java.util.List;

public class ScoreFrame {
    private String frameName;
    private List<UserFrame> userFrames;

    public String getFrameName() {
        return frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    public List<UserFrame> getUserFrames() {
        return userFrames;
    }

    public void setUserFrames(List<UserFrame> userFrames) {
        this.userFrames = userFrames;
    }
}
