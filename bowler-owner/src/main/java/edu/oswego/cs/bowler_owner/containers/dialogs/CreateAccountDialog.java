package edu.oswego.cs.bowler_owner.containers.dialogs;

import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class CreateAccountDialog extends JDialog {

    private JTextField usernameField;
    private JTextField passwordField;
    private JButton createButton;
    private JButton cancelButton;

    public CreateAccountDialog(JDialog root) {
        super(root, ModalityType.DOCUMENT_MODAL);
        setTitle("Create Account");
        setSize(260, 141);
        setMinimumSize(this.getSize());
        setLocationRelativeTo(null);
        setLayout(new MigLayout("", "[][grow,fill]", "[][][]"));
        add(new JLabel("Username:"));
        add(usernameField = new JTextField(), "growx, wrap");
        add(new JLabel("Password:"));
        add(passwordField = new JTextField(), "growx, wrap");
        JPanel dialogButtons = new JPanel(new MigLayout("", "[grow,fill][][][grow,fill]", "[grow,fill]"));
        dialogButtons.add(createButton = new JButton("Create"), "cell 1 0");
        dialogButtons.add(cancelButton = new JButton("Cancel"), "cell 2 0");
        createButton.addActionListener(e -> {
            if(!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                DB.insertAccount(usernameField.getText(), passwordField.getText());
                DB.incrementSequence("accountid");
                //TODO: Maybe add a confirmation dialog to check they want to make this account?
                dispose();
                root.setVisible(true);
            }
        });
        cancelButton.addActionListener(e -> {
            dispose();
            root.setVisible(true);
        });
        add(dialogButtons, "span, growx");
    }
}
