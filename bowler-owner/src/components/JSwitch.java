package components;

import javax.swing.*;
import java.awt.*;

public class JSwitch extends JCheckBox {

    @Override
    public void paintComponent(Graphics g) {
        g.fillOval(26, 26, 22, 22);
        g.fillRect(36, 26, 30, 22);
        g.fillOval(56, 26, 22, 22);
        g.setColor(new Color(132, 199, 193));
        g.fillOval(27, 27, 20, 20);
        g.fillRect(37, 27, 30, 20);
        g.fillOval(57, 27, 20, 20);
        g.setColor(new Color(38, 166, 154));
        g.fillOval(24, 24, 25, 25);
    }
}
