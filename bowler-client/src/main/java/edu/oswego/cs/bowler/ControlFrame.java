package edu.oswego.cs.bowler;

import edu.oswego.cs.bowler.models.Player;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ControlFrame extends JFrame {
    JButton addPlayerButton = new JButton("Add Player");
    JButton changePlayerNameButton = new JButton("Change Player Name");
    JButton insertScoreButton = new JButton("Insert Score");
    JButton changeScoreButton = new JButton("Modify Score");

    public ControlFrame() {
        setLayout(new MigLayout("", "[][][][]", "[]"));
        addPlayerButton.addActionListener(e -> {
            JFrame temp = new JFrame();
            temp.setLayout(new MigLayout("", "[grow,fill]", "[][][]"));
            temp.add(new JLabel("Player Name"),"wrap");
            JTextField jTextField = new JTextField();
            temp.add(jTextField, "growx, wrap");
            JButton jButton = new JButton("Submit");
            jButton.addActionListener(e1 -> {
                Player p = new Player();
                p.setPlayer_name(jTextField.getText());
                ClientServer.scoreTable.insertPlayer(p);
                ClientServer.jScoreTable.repaint();
                temp.setVisible(false);
            });
            temp.add(jButton);
            temp.pack();
            temp.setSize(300, temp.getHeight());
            temp.setVisible(true);
        });
        add(addPlayerButton, "growx");
        changePlayerNameButton.addActionListener(e -> {
            JFrame temp = new JFrame();
            temp.setLayout(new MigLayout("", "[grow,fill]", "[][][][][]"));
            temp.add(new JLabel("Old Player Name"),"wrap");
            JTextField jTextField = new JTextField();
            temp.add(jTextField, "growx, wrap");
            temp.add(new JLabel("New Player Name"),"wrap");
            JTextField jTextField2 = new JTextField();
            temp.add(jTextField2, "growx, wrap");
            JButton jButton = new JButton("Submit");
            jButton.addActionListener(e1 -> {
                Player oldP = new Player();
                oldP.setPlayer_name(jTextField.getText());
                Player newP = new Player();
                newP.setPlayer_name(jTextField2.getText());
                ClientServer.scoreTable.modifyPlayer(oldP, newP);
                ClientServer.jScoreTable.repaint();
                temp.setVisible(false);
            });
            temp.add(jButton);
            temp.pack();
            temp.setSize(300, temp.getHeight());
            temp.setVisible(true);
        });
        add(changePlayerNameButton, "growx");
        insertScoreButton.addActionListener(e -> {
            JFrame temp = new JFrame();
            temp.setLayout(new MigLayout("", "[grow,fill]", "[][][]"));
            temp.add(new JLabel("Player Name"),"wrap");
            JTextField jTextField = new JTextField();
            temp.add(jTextField, "growx, wrap");
            temp.add(new JLabel("Score"),"wrap");
            JTextField jTextField2 = new JTextField();
            temp.add(jTextField2, "growx, wrap");
            JButton jButton = new JButton("Submit");
            jButton.addActionListener(e1 -> {
                Player p = new Player();
                p.setPlayer_name(jTextField.getText());
                ClientServer.scoreTable.insertScore(p, jTextField2.getText());
                ClientServer.jScoreTable.repaint();
                temp.setVisible(false);
            });
            temp.add(jButton);
            temp.pack();
            temp.setSize(300, temp.getHeight());
            temp.setVisible(true);
        });
        add(insertScoreButton, "growx");
        changeScoreButton.addActionListener(e -> {
            JFrame temp = new JFrame();
            temp.setLayout(new MigLayout("", "[grow,fill]", "[][][]"));
            temp.add(new JLabel("Player Name"),"wrap");
            JTextField jTextField = new JTextField();
            temp.add(jTextField, "growx, wrap");
            temp.add(new JLabel("Frame Number"),"wrap");
            JTextField jTextField2 = new JTextField();
            temp.add(jTextField2, "growx, wrap");
            temp.add(new JLabel("Position"),"wrap");
            JComboBox position = new JComboBox(new String[]{"Left", "Center", "Right"});
            temp.add(position, "wrap");
            temp.add(new JLabel("Score"),"wrap");
            JTextField jTextField3 = new JTextField();
            temp.add(jTextField3, "growx, wrap");
            JButton jButton = new JButton("Submit");
            jButton.addActionListener(e1 -> {
                Player p = new Player();
                p.setPlayer_name(jTextField.getText());
                ClientServer.scoreTable.modifyScore(p, jTextField3.getText(), Integer.parseInt(jTextField2.getText()) - 1, position.getSelectedIndex());
                ClientServer.jScoreTable.repaint();
                temp.setVisible(false);
            });
            temp.add(jButton);
            temp.pack();
            temp.setSize(300, temp.getHeight());
            temp.setVisible(true);
        });
        add(changeScoreButton, "growx");
        pack();
    }
}
