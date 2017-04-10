package edu.oswego.cs.bowler_owner;

import edu.oswego.cs.bowler_owner.components.JScoreTable;

import javax.swing.*;

public class TestFrame extends JFrame {

    TestFrame() {
        add(new JScoreTable());
        pack();
    }

    public static void main(String[] args) {
        final TestFrame mainFrame = new TestFrame();
        SwingUtilities.invokeLater(() -> mainFrame.setVisible(true));
    }
}
