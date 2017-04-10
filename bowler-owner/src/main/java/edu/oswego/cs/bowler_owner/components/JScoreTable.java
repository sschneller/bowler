package edu.oswego.cs.bowler_owner.components;

import javax.swing.*;
import java.awt.*;

public class JScoreTable extends JPanel {

    public JScoreTable() {

    }

    public void addPlayer(String playerName) {

    }

    public void removePlayer(String playerName) {

    }

    public void updatePlayer(String oldPlayerName, String newPlayerName) {

    }

    public void insertScore() {

    }

    public void removeScore() {

    }

    public void updateScore() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Double height, width, xDivider, yDivider;
        int numPlayers = 0;

        height = getHeight() - 1.0;
        width = getWidth() - 1.0;
        xDivider = width / 14;

        Double BLANKBOX_XLOC = xDivider;
        Double BLANKBOX_CENTER = BLANKBOX_XLOC / 2.0;
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

        g.drawString("1", FRAME1_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("1") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("2", FRAME2_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("2") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("3", FRAME3_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("3") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("4", FRAME4_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("4") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("5", FRAME5_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("5") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("6", FRAME6_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("6") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("7", FRAME7_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("7") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("8", FRAME8_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("8") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("9", FRAME9_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("9") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("10", FRAME10_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("10") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("HDCP", HDCP_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("HDCP") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("HDCP Game", HDCPG_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("HDCP Game") / 2), 30 - (g.getFontMetrics().getHeight() / 2));
        g.drawString("HDCP Series", HDCPS_XLOC_CENTER.intValue() - (g.getFontMetrics().stringWidth("HDCP Series") / 2), 30 - (g.getFontMetrics().getHeight() / 2));

        g.drawLine(0, 30, width.intValue(), 30);
    }
}
