package edu.oswego.cs.bowler_owner.containers.frames;

import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class LoginFrame extends JFrame {

    private static LoginFrame gui;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton cancelButton;

    public LoginFrame() {
        DB.init();

        setTitle("Login");
        setSize(260, 141);
        setLocationRelativeTo(null);
        setMinimumSize(this.getSize());
        setLayout(new MigLayout("", "[][grow,fill]", "[][][]"));
        add(new JLabel("Username:"));
        add(usernameField = new JTextField(), "growx, wrap");
        add(new JLabel("Password:"));
        add(passwordField = new JPasswordField(), "growx, wrap");
        JPanel dialogButtons = new JPanel(new MigLayout("", "[grow,fill][][][grow,fill]", "[grow,fill]"));
        dialogButtons.add(submitButton = new JButton("Login"), "cell 1 0");
        dialogButtons.add(cancelButton = new JButton("Cancel"), "cell 2 0");
        submitButton.addActionListener(e -> {
            if(DB.verifyUsername(usernameField.getText())) {
                if(DB.verifyPassword(String.valueOf(usernameField.getText()), String.valueOf(passwordField.getPassword()))) {
                    gui.setVisible(false);
                    final MainFrame mainFrame = new MainFrame(usernameField.getText());
                    SwingUtilities.invokeLater(() -> mainFrame.setVisible(true));
                }
                else {
                    JOptionPane.showMessageDialog(submitButton, "This username/password combination does not match any account.", "Username/Password Mismatch", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(submitButton, "This username does not exist.", "Username Not Found", JOptionPane.ERROR_MESSAGE);
            }
        });
        cancelButton.addActionListener(e -> dispose());
        add(dialogButtons, "span, growx");

        getRootPane().setDefaultButton(submitButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        gui = new LoginFrame();
        SwingUtilities.invokeLater(() -> gui.setVisible(true));
    }
}
