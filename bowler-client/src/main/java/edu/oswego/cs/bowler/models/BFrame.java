package edu.oswego.cs.bowler.models;

public interface BFrame {
    static final int LEFT = 0;
    static final int CENTER = 1;
    static final int RIGHT = 2;
    BFrame insertScore(String score);
    BFrame modifyScore(String score, int side);
}