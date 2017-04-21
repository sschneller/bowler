package edu.oswego.cs.bowler_owner.models;

public interface BFrame {
    BFrame insertScore(Player p, String score);
}

/*
public class BFrame {
    private boolean normalFrame;
    private Integer first_round;
    private Integer second_round;

    public BFrame(boolean f, int fr, int sr) {
        normalFrame = f;
        first_round = fr;
        second_round = sr;
    }

    public BFrame() {
        first_round = null;
        second_round = null;
    }

    public boolean isNormalFrame() {
        return normalFrame;
    }

    public void setNormalFrame(boolean normalFrame) {
        this.normalFrame = normalFrame;
    }

    public Integer getFirst_round() {
        return first_round;
    }

    public void setFirst_round(int first_round) {
        this.first_round = first_round;
    }

    public Integer getSecond_round() {
        return second_round;
    }

    public void setSecond_round(int second_round) {
        this.second_round = second_round;
    }
}*/
