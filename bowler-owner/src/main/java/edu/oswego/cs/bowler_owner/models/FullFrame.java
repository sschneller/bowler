package edu.oswego.cs.bowler_owner.models;

public class FullFrame implements BFrame {
    private String value;

    public FullFrame(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public BFrame insertScore(Player p, String score) {
        setValue(score);
        return this;
    }

    @Override
    public String toString() {
        return "FullFrame";
    }
}
