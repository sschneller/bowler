package edu.oswego.cs.bowler.models;

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
    public BFrame insertScore(String score) {
        if(getLeftFrame().equals("")) {
            if(score.equals("10")) setRightFrame("X");
            else if(score.equals("0")) setLeftFrame("-");
            else setLeftFrame(score);
        }
        else {
            if((Integer.parseInt(getLeftFrame()) + Integer.parseInt(score)) == 10) setRightFrame("/");
            else if(score.equals("0")) setRightFrame("-");
            else setRightFrame(score);
        }
        return this;
    }

    @Override
    public BFrame modifyScore(String score, int side) {
        switch(side) {
            case BFrame.LEFT: {
                setLeftFrame(score);
                break;
            }
            case BFrame.RIGHT: {
                setRightFrame(score);
                break;
            }
            default: {
                return null;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "PartitionedFrame\n\tLeft: " + getLeftFrame() + "\tRight: " + getRightFrame();
    }
}
