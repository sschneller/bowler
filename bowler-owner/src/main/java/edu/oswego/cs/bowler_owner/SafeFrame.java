package edu.oswego.cs.bowler_owner;

import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SafeFrame extends JDialog {

    private JLabel usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private String userName;
    private MainFrame rootFrame;

    public SafeFrame(MainFrame root, String user) {

        super(root, ModalityType.DOCUMENT_MODAL);

        userName = user;
        rootFrame = root;
        rootFrame.setDialogShown(true);

        setTitle("Safe Mode");
        setSize(260, 100);
        setLocationRelativeTo(null);
        setMinimumSize(this.getSize());
        setLayout(new MigLayout("", "[][grow,fill]", "[][][]"));

        add(new JLabel("Username:"));
        add(usernameField = new JLabel(), "growx, wrap");
        usernameField.setText(userName);

        add(new JLabel("Password:"));
        add(passwordField = new JPasswordField(), "growx, wrap");
        JPanel dialogButtons = new JPanel(new MigLayout("", "[grow,fill][][][grow,fill]", "[grow,fill]"));
        dialogButtons.add(submitButton = new JButton("Login"), "cell 1 0");

        submitButton.addActionListener(e -> {
            if(DB.verifyUsername(usernameField.getText())) {
                if(DB.verifyPassword(String.valueOf(usernameField.getText()), String.valueOf(passwordField.getPassword()))) {
                    this.setVisible(false);
                    rootFrame.setDialogShown(false);
                    rootFrame.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(submitButton, "This username/password combination does not match any account.", "Username/Password Mismatch", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(submitButton, "This username does not exist.", "Username Not Found", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(dialogButtons, "span, growx");

        getRootPane().setDefaultButton(submitButton);
        setUndecorated(true);
    }
}
