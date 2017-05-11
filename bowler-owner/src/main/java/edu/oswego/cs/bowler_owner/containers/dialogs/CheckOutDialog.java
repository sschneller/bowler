package edu.oswego.cs.bowler_owner.containers.dialogs;

import edu.oswego.cs.bowler_owner.containers.frames.MainFrame;
import edu.oswego.cs.bowler_owner.mongo.DB;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class CheckOutDialog extends JDialog {

    private JLabel shoeLabel, socksLabel, gameLabel;
    private JTextField shoePrice, socksPrice, gamePrice;
    private JButton submitButton, cancelButton;
    private MainFrame rootFrame;

    public CheckOutDialog(MainFrame root){
        super(root, Dialog.ModalityType.DOCUMENT_MODAL);

        rootFrame = root;
        rootFrame.setDialogShown(true);

        setTitle("Check Out");
        setSize(260, 100);
        setLocationRelativeTo(null);
        setMinimumSize(this.getSize());
        setLayout(new MigLayout("", "[][grow,fill]", "[][][][]"));

        add(shoeLabel = new JLabel("Shoes Purchased:"));
        add(shoePrice = new JTextField(), "growx, wrap");
        add(socksLabel = new JLabel("Socks Purchased:"));
        add(socksPrice = new JTextField(), "growx, wrap");
        add(gameLabel = new JLabel("Games Bowled:"));
        add(gamePrice = new JTextField(), "growx, wrap");

        JPanel dialogButtons = new JPanel(new MigLayout("", "[grow,fill][][][grow,fill]", "[grow,fill]"));
        dialogButtons.add(submitButton = new JButton("Submit"), "cell 1 0");
        dialogButtons.add(cancelButton = new JButton("Cancel"), "cell 2 0");

        submitButton.addActionListener(e -> {
            String errorMessage = "";
            double shoeFinalPrice = 0.0;
            double sockFinalPrice = 0.0;
            double gameFinalPrice = 0.0;

            if(shoePrice.getText().equals("")) {
                errorMessage += "Need to Enter Number of Shoes!" + System.lineSeparator();
            }
            else {
                try {
                    if(DB.getPrice("shoePrice") != -1) {
                        shoeFinalPrice = Double.parseDouble(shoePrice.getText()) * DB.getPrice("shoePrice");
                    }
                    else {
                        errorMessage += "Need to Enter a Shoe Price in PriceDefaults!" + System.lineSeparator();
                    }
                }
                catch(NumberFormatException nfe) {
                    errorMessage += "Invalid Price for a Shoe!" + System.lineSeparator();
                }
            }
            if(socksPrice.getText().equals("")) {
                errorMessage += "Need to Enter Number of Shoes!" + System.lineSeparator();
            }
            else {
                try {
                    if(DB.getPrice("sockPrice") != -1) {
                        sockFinalPrice = Double.parseDouble(socksPrice.getText()) * DB.getPrice("sockPrice");
                    }
                    else {
                        errorMessage += "Need to Enter a Sock Price in PriceDefaults!" + System.lineSeparator();
                    }
                }
                catch(NumberFormatException nfe) {
                    errorMessage += "Invalid Price for a Sock!" + System.lineSeparator();
                }
            }
            if(gamePrice.getText().equals("")) {
                errorMessage += "Need to Enter Number of Games!" + System.lineSeparator();
            }
            else {
                try {
                    if(DB.getPrice("gamePrice") != -1) {
                        gameFinalPrice = Double.parseDouble(gamePrice.getText()) * DB.getPrice("gamePrice");
                    }
                    else {
                        errorMessage += "Need to Enter a Game Price in PriceDefaults!" + System.lineSeparator();
                    }
                }
                catch(NumberFormatException nfe) {
                    errorMessage += "Invalid Price for a Game!" + System.lineSeparator();
                }
            }
            if(errorMessage.equals("")) {
                double total = shoeFinalPrice + sockFinalPrice + gameFinalPrice;
                if(DB.getPrice("Total") == -1){
                    DB.insertPricing("Total", total);
                }
                else{
                    total += DB.getPrice("Total");
                    DB.updatePrice("Total", total);
                }
                this.setVisible(false);
                rootFrame.setDialogShown(false);
                rootFrame.repaint();
            }
            else {
                JOptionPane.showMessageDialog(submitButton, errorMessage);
            }
        });

        cancelButton.addActionListener(e -> {
            this.setVisible(false);
            rootFrame.setDialogShown(false);
            rootFrame.repaint();
        });

        add(dialogButtons, "span, growx");
        this.pack();
        this.setResizable(false);

        getRootPane().setDefaultButton(submitButton);
    }


}
