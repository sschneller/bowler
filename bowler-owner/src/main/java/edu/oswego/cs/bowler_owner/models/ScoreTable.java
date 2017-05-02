package edu.oswego.cs.bowler_owner.models;

import java.util.ArrayList;
import java.util.List;

public class ScoreTable {
    private boolean isLeagueMode;
    private List<Player> playerList = new ArrayList<>();
    private List<List<BFrame>> frameList = new ArrayList<>();

    public boolean isLeagueMode() {
        return isLeagueMode;
    }

    public void setLeagueMode(boolean leagueMode) {
        isLeagueMode = leagueMode;
    }

    public List<Player> getPlayers() {
        return playerList;
    }

    public List<BFrame> getScores(Player p) {
        return frameList.get(playerList.indexOf(p));
    }

    public void insertPlayer(Player p) {
        playerList.add(p);
        List<BFrame> emptyFrames = new ArrayList<>();
        for(int i = 0; i < 9; i++) emptyFrames.add(new BFrame("", "", "", "Partitioned"));
        emptyFrames.add(new BFrame("", "", "", "", "Final"));
        for(int i = 0; i < 3; i++) emptyFrames.add(new BFrame("", "Full"));
        frameList.add(emptyFrames);
    }

    public void modifyPlayer(Player oldPlayer, Player newPlayer) {
        playerList.set(playerList.indexOf(oldPlayer), newPlayer);
    }

    public void insertScore(Player p, String score, int index) {
        List<BFrame> updatedList = frameList.get(playerList.indexOf(p));
        updatedList.set(index, updatedList.get(index).insertScore(score));
        frameList.set(playerList.indexOf(p), updatedList);
        tabulateScores(p);
    }

    public void modifyScore(Player p, String score, int index, int side) {
        List<BFrame> updatedList = frameList.get(playerList.indexOf(p));
        updatedList.set(index, updatedList.get(index).modifyScore(score, side));
        frameList.set(playerList.indexOf(p), updatedList);
        tabulateScores(p);
    }

    private void tabulateScores(Player p) {
        List<BFrame> bFrameList = frameList.get(playerList.indexOf(p));
        BFrame prevFrame = null, currFrame = null, nextFrame = null, nextNextFrame = null;
        BFrame finalFrame = bFrameList.get(9);
        int prevValue = 0, total = 0;
        for(int i = 0; i <= 8; i++) {
            if((i - 1) >= 0) prevFrame = bFrameList.get(i - 1);
            currFrame = bFrameList.get(i);
            if((i + 1) <= 8) nextFrame = bFrameList.get(i + 1);
            if((i + 2) <= 8) nextNextFrame = bFrameList.get(i + 2);
            prevValue = 0;
            if(prevFrame != null) prevValue = Integer.parseInt(prevFrame.getBottomFrame());

            total = 0;

            if(i == 8) {
                // STRIKE CALCS
                //
                if(currFrame.getRightFrame().equals("X") && finalFrame.getLeftFrame().equals("X") && finalFrame.getCenterFrame().equals("X")) {
                    total = prevValue + 30;
                }
                //
                else if(currFrame.getRightFrame().equals("X") && finalFrame.getLeftFrame().equals("X") && !finalFrame.getCenterFrame().equals("")) {
                    if(finalFrame.getCenterFrame().equals("-")) total = prevValue + 20;
                    else total = prevValue + 20 + Integer.parseInt(finalFrame.getCenterFrame());
                }
                //
                else if(currFrame.getRightFrame().equals("X") && finalFrame.getCenterFrame().equals("/")) {
                    total = prevValue + 20;
                }
                //
                else if(currFrame.getRightFrame().equals("X") && !finalFrame.getLeftFrame().equals("") && !finalFrame.getCenterFrame().equals("")) {
                    if(finalFrame.getLeftFrame().equals("-") && finalFrame.getCenterFrame().equals("-")) total = prevValue + 10;
                    else if(finalFrame.getLeftFrame().equals("-")) total = prevValue + 10 + Integer.parseInt(finalFrame.getCenterFrame());
                    else if(finalFrame.getCenterFrame().equals("-")) total = prevValue + 10 + Integer.parseInt(finalFrame.getLeftFrame());
                    else total = prevValue + 10 + Integer.parseInt(finalFrame.getLeftFrame()) + Integer.parseInt(finalFrame.getCenterFrame());
                }
                // SPARE CALCS
                //
                else if(currFrame.getRightFrame().equals("/") && finalFrame.getLeftFrame().equals("X")) {
                    total = prevValue + 20;
                }
                //
                else if(currFrame.getRightFrame().equals("/") && !finalFrame.getLeftFrame().equals("")) {
                    if(finalFrame.getLeftFrame().equals("-")) total = prevValue + 10;
                    else total = prevValue + 10 + Integer.parseInt(finalFrame.getLeftFrame());
                }
                // ELSE
                //
                else if(!currFrame.getLeftFrame().equals("") && !currFrame.getRightFrame().equals("") && !currFrame.getRightFrame().equals("/") && !currFrame.getRightFrame().equals("X")) {
                    if(currFrame.getLeftFrame().equals("-") && currFrame.getRightFrame().equals("-")) total = prevValue;
                    else if(currFrame.getLeftFrame().equals("-")) total = prevValue + Integer.parseInt(currFrame.getRightFrame());
                    else if(currFrame.getRightFrame().equals("-")) total = prevValue + Integer.parseInt(currFrame.getLeftFrame());
                    else total = prevValue + Integer.parseInt(currFrame.getLeftFrame()) + Integer.parseInt(currFrame.getRightFrame());
                }
                currFrame.setBottomFrame(total + "");
            }
            else {
                // STRIKE CALCS
                if(currFrame.getRightFrame().equals("X") && nextFrame.getRightFrame().equals("X") && nextNextFrame.getRightFrame().equals("X")) {
                    total = prevValue + 30;
                }
                else if(currFrame.getRightFrame().equals("X") && nextFrame.getRightFrame().equals("X") && !nextNextFrame.getLeftFrame().equals("")) {
                    if(nextNextFrame.getLeftFrame().equals("-")) total = prevValue + 20;
                    else total = prevValue + 20 + Integer.parseInt(nextNextFrame.getLeftFrame());
                }
                else if(currFrame.getRightFrame().equals("X") && nextFrame.getRightFrame().equals("/")) {
                    total = prevValue + 20;
                }
                else if(currFrame.getRightFrame().equals("X") && !nextFrame.getLeftFrame().equals("") && !nextFrame.getRightFrame().equals("")) {
                    if(nextFrame.getLeftFrame().equals("-") && nextFrame.getRightFrame().equals("-")) total = prevValue + 10;
                    else if(nextFrame.getLeftFrame().equals("-")) total = prevValue + 10 + Integer.parseInt(nextFrame.getRightFrame());
                    else if(nextFrame.getRightFrame().equals("-")) total = prevValue + 10 + Integer.parseInt(nextFrame.getLeftFrame());
                    else total = prevValue + 10 + Integer.parseInt(nextFrame.getLeftFrame()) + Integer.parseInt(nextFrame.getRightFrame());
                }
                // SPARE CALCS
                else if(currFrame.getRightFrame().equals("/") && nextFrame.getRightFrame().equals("X")) {
                    total = prevValue + 20;
                }
                else if(currFrame.getRightFrame().equals("/") && !nextFrame.getLeftFrame().equals("")) {
                    if(nextFrame.getLeftFrame().equals("-")) total = prevValue + 10;
                    else total = prevValue + 10 + Integer.parseInt(nextFrame.getLeftFrame());
                }
                // ELSE
                else if(!currFrame.getLeftFrame().equals("") && !currFrame.getRightFrame().equals("") && !currFrame.getRightFrame().equals("/") && !currFrame.getRightFrame().equals("X")) {
                    if(currFrame.getLeftFrame().equals("-") && currFrame.getRightFrame().equals("-")) total = prevValue;
                    else if(currFrame.getLeftFrame().equals("-")) total = prevValue + Integer.parseInt(currFrame.getRightFrame());
                    else if(currFrame.getRightFrame().equals("-")) total = prevValue + Integer.parseInt(currFrame.getLeftFrame());
                    else total = prevValue + Integer.parseInt(currFrame.getLeftFrame()) + Integer.parseInt(currFrame.getRightFrame());
                }
                currFrame.setBottomFrame(total + "");
            }
        }
        prevValue = Integer.parseInt(currFrame.getBottomFrame());
        // STRIKE CALCS
        if(finalFrame.getLeftFrame().equals("X") && finalFrame.getCenterFrame().equals("X") && finalFrame.getRightFrame().equals("X")) {
            total = prevValue + 30;
        }
        else if(finalFrame.getLeftFrame().equals("X") && finalFrame.getCenterFrame().equals("X") && !finalFrame.getRightFrame().equals("")) {
            if(finalFrame.getRightFrame().equals("-")) total = prevValue + 20;
            else total = prevValue + 20 + Integer.parseInt(finalFrame.getRightFrame());
        }
        else if(finalFrame.getLeftFrame().equals("X") && finalFrame.getRightFrame().equals("/")) {
            total = prevValue + 20;
        }
        else if(finalFrame.getLeftFrame().equals("X") && !finalFrame.getCenterFrame().equals("") && !finalFrame.getRightFrame().equals("")) {
            if(finalFrame.getCenterFrame().equals("-") && finalFrame.getRightFrame().equals("-")) total = prevValue + 10;
            else if(finalFrame.getCenterFrame().equals("-")) total = prevValue + 10 + Integer.parseInt(finalFrame.getCenterFrame());
            else if(finalFrame.getRightFrame().equals("-")) total = prevValue + 10 + Integer.parseInt(finalFrame.getRightFrame());
            else total = prevValue + 10 + Integer.parseInt(finalFrame.getRightFrame()) + Integer.parseInt(finalFrame.getCenterFrame());
        }
        // SPARE CALCS
        else if(finalFrame.getCenterFrame().equals("/") && finalFrame.getRightFrame().equals("X")) {
            total = prevValue + 20;
        }
        else if(finalFrame.getCenterFrame().equals("/") && !finalFrame.getRightFrame().equals("")) {
            if(finalFrame.getRightFrame().equals("-")) total = prevValue + 10;
            else total = prevValue + 10 + Integer.parseInt(finalFrame.getRightFrame());
        }
        // ELSE
        else if(!finalFrame.getLeftFrame().equals("") && !finalFrame.getCenterFrame().equals("") && !finalFrame.getCenterFrame().equals("/") && !finalFrame.getCenterFrame().equals("X")) {
            if(finalFrame.getLeftFrame().equals("-") && finalFrame.getCenterFrame().equals("-")) total = prevValue;
            else if(finalFrame.getLeftFrame().equals("-")) total = prevValue + Integer.parseInt(finalFrame.getCenterFrame());
            else if(finalFrame.getCenterFrame().equals("-")) total = prevValue + Integer.parseInt(finalFrame.getLeftFrame());
            else total = prevValue + Integer.parseInt(finalFrame.getLeftFrame()) + Integer.parseInt(finalFrame.getCenterFrame());
        }
        finalFrame.setBottomFrame(total + "");
    }
}
