package edu.oswego.cs.bowler_owner;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class LoginFrame extends JDialog {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton cancelButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(260, 141);
        setMinimumSize(this.getSize());
        setLayout(new MigLayout("", "[][grow,fill]", "[][][]"));
        add(new JLabel("Username:"));
        add(usernameField = new JTextField(), "growx, wrap");
        add(new JLabel("Password:"));
        add(passwordField = new JPasswordField(), "growx, wrap");
        JPanel dialogButtons = new JPanel(new MigLayout("", "[grow,fill][][][grow,fill]","[grow,fill]"));
        dialogButtons.add(submitButton = new JButton("Login"), "cell 1 0");
        dialogButtons.add(cancelButton = new JButton("Cancel"), "cell 2 0");
        submitButton.addActionListener(e -> {

        });
        cancelButton.addActionListener(e -> dispose());
        add(dialogButtons, "span, growx");
    }

    public static void main(String[] args) {
        final LoginFrame gui = new LoginFrame();
        SwingUtilities.invokeLater(() -> gui.setVisible(true));
    }
}
