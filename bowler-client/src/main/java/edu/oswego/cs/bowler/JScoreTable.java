package edu.oswego.cs.bowler;

import edu.oswego.cs.bowler.models.BFrame;
import edu.oswego.cs.bowler.models.Player;
import edu.oswego.cs.bowler.models.ScoreTable;

import javax.swing.*;
import java.awt.*;

public class JScoreTable extends JPanel {
    ScoreTable scoreTable;

    public JScoreTable(ScoreTable scoreTable) {
        this.scoreTable = scoreTable;
        scoreTable.getPlayers().forEach(p -> scoreTable.getScores(p).forEach(System.out::println));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Double height, width, xDivider, yDivider;

        height = getHeight() - 1.0;
        width = getWidth() - 1.0;
        xDivider = width / 14;

        Double BLANKBOX_XLOC = xDivider;
        Double BLANKBOX_XLOC_CENTER = BLANKBOX_XLOC / 2.0;
        Double FRAME1_XLOC = 3.0 * xDivider;
        Double FRAME1_XLOC_CENTER = FRAME1_XLOC / 2.0;
        Double FRAME2_XLOC = 5.0 * xDivider;
        Double FRAME2_XLOC_CENTER = FRAME2_XLOC / 2.0;
        Double FRAME3_XLOC = 7.0 * xDivider;
        Double FRAME3_XLOC_CENTER = FRAME3_XLOC / 2.0;
        Double FRAME4_XLOC = 9.0 * xDivider;
        Double FRAME4_XLOC_CENTER = FRAME4_XLOC / 2.0;
        Double FRAME5_XLOC = 11.0 * xDivider;
        Double FRAME5_XLOC_CENTER = FRAME5_XLOC / 2.0;
        Double FRAME6_XLOC = 13.0 * xDivider;
        Double FRAME6_XLOC_CENTER = FRAME6_XLOC / 2.0;
        Double FRAME7_XLOC = 15.0 * xDivider;
        Double FRAME7_XLOC_CENTER = FRAME7_XLOC / 2.0;
        Double FRAME8_XLOC = 17.0 * xDivider;
        Double FRAME8_XLOC_CENTER = FRAME8_XLOC / 2.0;
        Double FRAME9_XLOC = 19.0 * xDivider;
        Double FRAME9_XLOC_CENTER = FRAME9_XLOC / 2.0;
        Double FRAME10_XLOC = 21.0 * xDivider;
        Double FRAME10_XLOC_CENTER = FRAME10_XLOC / 2.0;
        Double HDCP_XLOC = 23.0 * xDivider;
        Double HDCP_XLOC_CENTER = HDCP_XLOC / 2.0;
        Double HDCPG_XLOC = 25.0 * xDivider;
        Double HDCPG_XLOC_CENTER = HDCPG_XLOC / 2.0;
        Double HDCPS_XLOC = 27.0 * xDivider;
        Double HDCPS_XLOC_CENTER = HDCPS_XLOC / 2.0;

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width.intValue(), height.intValue());

        g.drawLine(xDivider.intValue(), 0, xDivider.intValue(), height.intValue());
        g.drawLine(((Double)(2.0 * xDivider)).intValue(), 0, ((Double)(2.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(3.0 * xDivider)).intValue(), 0, ((Double)(3.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(4.0 * xDivider)).intValue(), 0, ((Double)(4.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(5.0 * xDivider)).intValue(), 0, ((Double)(5.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(6.0 * xDivider)).intValue(), 0, ((Double)(6.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(7.0 * xDivider)).intValue(), 0, ((Double)(7.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(8.0 * xDivider)).intValue(), 0, ((Double)(8.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(9.0 * xDivider)).intValue(), 0, ((Double)(9.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(10.0 * xDivider)).intValue(), 0, ((Double)(10.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(11.0 * xDivider)).intValue(), 0, ((Double)(11.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(12.0 * xDivider)).intValue(), 0, ((Double)(12.0 * xDivider)).intValue(), height.intValue());
        g.drawLine(((Double)(13.0 * xDivider)).intValue(), 0, ((Double)(13.0 * xDivider)).intValue(), height.intValue());

        g.drawString("1", ((Double)(FRAME1_XLOC_CENTER - (g.getFontMetrics().stringWidth("1") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("2", ((Double)(FRAME2_XLOC_CENTER - (g.getFontMetrics().stringWidth("2") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("3", ((Double)(FRAME3_XLOC_CENTER - (g.getFontMetrics().stringWidth("3") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("4", ((Double)(FRAME4_XLOC_CENTER - (g.getFontMetrics().stringWidth("4") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("5", ((Double)(FRAME5_XLOC_CENTER - (g.getFontMetrics().stringWidth("5") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("6", ((Double)(FRAME6_XLOC_CENTER - (g.getFontMetrics().stringWidth("6") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("7", ((Double)(FRAME7_XLOC_CENTER - (g.getFontMetrics().stringWidth("7") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("8", ((Double)(FRAME8_XLOC_CENTER - (g.getFontMetrics().stringWidth("8") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("9", ((Double)(FRAME9_XLOC_CENTER - (g.getFontMetrics().stringWidth("9") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("10", ((Double)(FRAME10_XLOC_CENTER - (g.getFontMetrics().stringWidth("10") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("HDCP", ((Double)(HDCP_XLOC_CENTER - (g.getFontMetrics().stringWidth("HDCP") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("HDCP Game", ((Double)(HDCPG_XLOC_CENTER - (g.getFontMetrics().stringWidth("HDCP Game") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("HDCP Series", ((Double)(HDCPS_XLOC_CENTER - (g.getFontMetrics().stringWidth("HDCP Series") / 2.0))).intValue(), 30 - (g.getFontMetrics().getHeight() / 2));

        g.drawLine(0, 30, width.intValue(), 30);

        yDivider = xDivider;
        Double i = 1.0;

        for(Player p : scoreTable.getPlayers()) {
            g.drawLine(0, ((Double)(30.0 + (i * yDivider))).intValue(), width.intValue(), ((Double)(30.0 + (i * yDivider))).intValue());
            g.drawString(p.getPlayer_name(), ((Double)(BLANKBOX_XLOC_CENTER - (g.getFontMetrics().stringWidth(p.getPlayer_name()) / 2.0))).intValue(), ((Double)(30.0 + ((i * yDivider) - (yDivider / 2.0)) + (0.0 + g.getFontMetrics().getHeight()) / 2.0)).intValue());
            int j = 1;
            for(BFrame frame : scoreTable.getScores(p)) {
                if(frame.getType().equals("Partitioned")) {
                    switch(j) {
                        case 1:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME1_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME1_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME1_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 2:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME2_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME2_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME2_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 3:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME3_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME3_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME3_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 4:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME4_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME4_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME4_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 5:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME5_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME5_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME5_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 6:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME6_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME6_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME6_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 7:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME7_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME7_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME7_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 8:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME8_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME8_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME8_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                        case 9:
                            g.drawString(frame.getLeftFrame(), ((Double)(FRAME9_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getRightFrame(), ((Double)(FRAME9_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                            g.drawString(frame.getBottomFrame(), ((Double)(FRAME9_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                            break;
                    }
                    j++;
                }
                if(frame.getType().equals("Final")) {
                    g.drawString(frame.getLeftFrame(), ((Double)(FRAME10_XLOC_CENTER - (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getLeftFrame())) / 2.0)).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                    g.drawString(frame.getCenterFrame(), ((Double)(FRAME10_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getCenterFrame())) / 2.0)).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                    g.drawString(frame.getRightFrame(), ((Double)(FRAME10_XLOC_CENTER + (xDivider / 4.0) - (g.getFontMetrics().stringWidth(frame.getRightFrame()) / 2.0))).intValue(), ((Double)((30.0 + (i * yDivider)) - (4.0 * (yDivider / 5.0)) + ((0.0 + g.getFontMetrics().getHeight()) / 2.0))).intValue());
                    g.drawString(frame.getBottomFrame(), ((Double)(FRAME10_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getBottomFrame())) / 2.0)).intValue(), ((Double)((30.0 + (i * yDivider)) - (yDivider / 5.0) + ((0.0 + g.getFontMetrics().getHeight() / 2.0)))).intValue());
                }
                if(frame.getType().equals("Full")) {
                    switch(j) {
                        case 10:
                            g.drawString(frame.getValue(), ((Double)(HDCP_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getValue()) / 2.0))).intValue(), ((Double)(30.0 + ((i * yDivider) - (yDivider / 2.0)) + (0.0 + g.getFontMetrics().getHeight()) / 2.0)).intValue());
                            break;
                        case 11:
                            g.drawString(frame.getValue(), ((Double)(HDCPG_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getValue()) / 2.0))).intValue(), ((Double)(30.0 + ((i * yDivider) - (yDivider / 2.0)) + (0.0 + g.getFontMetrics().getHeight()) / 2.0)).intValue());
                            break;
                        case 12:
                            g.drawString(frame.getValue(), ((Double)(HDCPS_XLOC_CENTER - (g.getFontMetrics().stringWidth(frame.getValue()) / 2.0))).intValue(), ((Double)(30.0 + ((i * yDivider) - (yDivider / 2.0)) + (0.0 + g.getFontMetrics().getHeight()) / 2.0)).intValue());
                            break;
                    }
                    j++;
                }
            }
            i += 1.0;
        }
    }
}
