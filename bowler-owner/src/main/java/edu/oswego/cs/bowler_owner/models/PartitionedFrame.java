package edu.oswego.cs.bowler_owner.models;

public class PartitionedFrame implements BFrame {
    private String leftFrame;
    private String rightFrame;
    private String bottomFrame;

    public PartitionedFrame(String leftFrame, String rightFrame, String bottomFrame) {
        this.leftFrame = leftFrame;
        this.rightFrame = rightFrame;
        this.bottomFrame = bottomFrame;
    }

    public String getLeftFrame() {
        return leftFrame;
    }

    public void setLeftFrame(String leftFrame) {
        this.leftFrame = leftFrame;
    }

    public String getRightFrame() {
        return rightFrame;
    }

    public void setRightFrame(String rightFrame) {
        this.rightFrame = rightFrame;
    }

    public String getBottomFrame() {
        return bottomFrame;
    }

    public void setBottomFrame(String bottomFrame) {
        this.bottomFrame = bottomFrame;
    }

    @Override
    public BFrame insertScore(Player p, String score, int index) {
        if(getLeftFrame().equals("")) {
            if(score.equals("10")) setRightFrame("X");
            else setLeftFrame(score);
        }
        else {
            if((Integer.parseInt(getLeftFrame()) + Integer.parseInt(score)) == 10) setRightFrame("/");
            else setRightFrame(score);
        }
        calculateBottoms();
        return this;
    }

    private void calculateBottoms() {

    }

    @Override
    public String toString() {
        return "PartitionedFrame";
    }
}
