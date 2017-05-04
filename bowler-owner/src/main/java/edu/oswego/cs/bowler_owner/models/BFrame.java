package edu.oswego.cs.bowler_owner.models;

public class BFrame {
    public static final int LEFT = 0;
    public static final int CENTER = 1;
    public static final int RIGHT = 2;

    private String type;
    private String leftFrame;
    private String centerFrame;
    private String rightFrame;
    private String bottomFrame;
    private String value;

    public BFrame(String val, String t) {
        leftFrame = null;
        centerFrame = null;
        rightFrame = null;
        bottomFrame = null;
        value = val;
        type = t;
    }

    public BFrame(String left, String right, String bottom, String t) {
        leftFrame = left;
        centerFrame = null;
        rightFrame = right;
        bottomFrame = bottom;
        value = null;
        type = t;
    }

    public BFrame(String left, String center, String right, String bottom, String t) {
        leftFrame = left;
        centerFrame = center;
        rightFrame = right;
        bottomFrame = bottom;
        value = null;
        type = t;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BFrame insertScore(String score) {
        if(type.equals("Partitioned")) {
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
        else if(type.equals("Final")) {
            if(getLeftFrame().equals("")) {
                if(score.equals("10")) setLeftFrame("X");
                else if(score.equals("0")) setLeftFrame("-");
                else setLeftFrame(score);
            }
            else if(!getLeftFrame().equals("") && getCenterFrame().equals("")) {
                if(score.equals("10")) setCenterFrame("X");
                else if(score.equals("0")) setCenterFrame("-");
                else if(!getLeftFrame().equals("X") && !getLeftFrame().equals("-") && (Integer.parseInt(getLeftFrame()) + Integer.parseInt(score)) == 10)
                    setCenterFrame("/");
                else setCenterFrame(score);
            }
            else if(!getLeftFrame().equals("") && !getCenterFrame().equals("") && getRightFrame().equals("")) {
                if(getLeftFrame().equals("X") || getCenterFrame().equals("/")) {
                    if(score.equals("10")) setRightFrame("X");
                    else if(score.equals("0")) setRightFrame("-");
                    else if(!getCenterFrame().equals("X") && !getCenterFrame().equals("-") && !getCenterFrame().equals("/") && (Integer.parseInt(getCenterFrame()) + Integer.parseInt(score)) == 10)
                        setRightFrame("/");
                    else setRightFrame(score);
                }
            }
            return this;
        }
        else if(type.equals("Full")) {
            setValue(score);
            return this;
        }
        return null;
    }

    public BFrame modifyScore(String score, int side) {
        if(type.equals("Partitioned")) {
            switch(side) {
                case LEFT: {
                    setLeftFrame(score);
                    break;
                }
                case RIGHT: {
                    setRightFrame(score);
                    break;
                }
                default: {
                    return null;
                }
            }
            return this;
        }
        else if(type.equals("Final")) {
            switch(side) {
                case LEFT: {
                    setLeftFrame(score);
                    break;
                }
                case CENTER: {
                    setCenterFrame(score);
                    break;
                }
                case RIGHT: {
                    setRightFrame(score);
                    break;
                }
                default: {
                    return null;
                }
            }
            return this;
        }
        else if(type.equals("Full")) {
            setValue(score);
            return this;
        }
        return null;
    }
}