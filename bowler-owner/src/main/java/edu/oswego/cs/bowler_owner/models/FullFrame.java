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
    public BFrame insertScore(String score) {
        setValue(score);
        return this;
    }

    @Override
    public BFrame modifyScore(String score, int side) {
        setValue(score);
        return this;
    }

    @Override
    public String toString() {
        return "FullFrame\n\tValue: " + getValue();
    }
}
