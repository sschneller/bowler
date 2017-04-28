package edu.oswego.cs.bowler_owner.models;

public class FinalFrame implements BFrame {
    private String leftFrame;
    private String centerFrame;
    private String rightFrame;
    private String bottomFrame;

    public FinalFrame(String leftFrame, String centerFrame, String rightFrame, String bottomFrame) {
        this.leftFrame = leftFrame;
        this.centerFrame = centerFrame;
        this.rightFrame = rightFrame;
        this.bottomFrame = bottomFrame;
    }

    public String getLeftFrame() {
        return leftFrame;
    }

    public void setLeftFrame(String leftFrame) {
        this.leftFrame = leftFrame;
    }

    public String getCenterFrame() {
        return centerFrame;
    }

    public void setCenterFrame(String centerFrame) {
        this.centerFrame = centerFrame;
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
            if(score.equals("10")) setLeftFrame("X");
            else if(score.equals("0")) setLeftFrame("-");
            else setLeftFrame(score);
        }
        else if(!getLeftFrame().equals("") && getCenterFrame().equals("")) {
            if(score.equals("10")) setCenterFrame("X");
            else if(score.equals("0")) setCenterFrame("-");
            else if(!getLeftFrame().equals("X") && !getLeftFrame().equals("-") && (Integer.parseInt(getLeftFrame()) + Integer.parseInt(score)) == 10) setCenterFrame("/");
            else setCenterFrame(score);
        }
        else if(!getLeftFrame().equals("") && !getCenterFrame().equals("") && getRightFrame().equals("")) {
            if(getLeftFrame().equals("X") || getCenterFrame().equals("/")) {
                if(score.equals("10")) setRightFrame("X");
                else if(score.equals("0")) setRightFrame("-");
                else if(!getCenterFrame().equals("X") && !getCenterFrame().equals("-") && !getCenterFrame().equals("/") && (Integer.parseInt(getCenterFrame()) + Integer.parseInt(score)) == 10) setRightFrame("/");
                else setRightFrame(score);
            }
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
            case BFrame.CENTER: {
                setCenterFrame(score);
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
        return "FinalFrame\n\tLeft: " + getLeftFrame() + "\tCenter: " + getCenterFrame() + "\tRight: " + getRightFrame();
    }
}
