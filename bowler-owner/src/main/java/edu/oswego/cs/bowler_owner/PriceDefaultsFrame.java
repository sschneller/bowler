package edu.oswego.cs.bowler_owner;


import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class PriceDefaultsFrame extends JFrame {

    JLabel shoeLabel, socksLabel, gameLabel;
    JTextField shoePrice, socksPrice, gamePrice;
    JButton submitButton, cancelButton;

    PriceDefaultsFrame() {

        setTitle("Price Preferences");
        setLocationRelativeTo(null);
        setMinimumSize(this.getSize());
        setLayout(new MigLayout("", "[][grow,fill]", "[][][][]"));

        add(shoeLabel = new JLabel("Shoe Price:"));
        add(shoePrice = new JTextField(), "growx, wrap");
        add(socksLabel = new JLabel("Socks Price:"));
        add(socksPrice = new JTextField(), "growx, wrap");
        add(gameLabel = new JLabel("Game Price:"));
        add(gamePrice = new JTextField(), "growx, wrap");

        JPanel dialogButtons = new JPanel(new MigLayout("", "[grow,fill][][][grow,fill]", "[grow,fill]"));
        dialogButtons.add(submitButton = new JButton("Submit"), "cell 1 0");
        dialogButtons.add(cancelButton = new JButton("Cancel"), "cell 2 0");

        submitButton.addActionListener(e -> {
            String errorMessage = "";
            double shoeFinalPrice, sockFinalPrice, gameFinalPrice;

            if(shoePrice.getText().equals("")){
                errorMessage += "Need to Enter a Shoe!" + System.lineSeparator();
            }else{
                try{
                    shoeFinalPrice = Double.parseDouble(shoePrice.getText());
                }catch (NumberFormatException nfe){
                    errorMessage += "Invalid Price for a Shoe!" + System.lineSeparator();
                }
            }
            if(socksPrice.getText().equals("")){
                errorMessage += "Need to Enter a Sock!" + System.lineSeparator();
            }else{
                try{
                    sockFinalPrice = Double.parseDouble(socksPrice.getText());
                }catch (NumberFormatException nfe){
                    errorMessage += "Invalid Price for a Sock!" + System.lineSeparator();
                }
            }
            if(gamePrice.getText().equals("")){
                errorMessage += "Need to Enter a Game!" + System.lineSeparator();
            }else{
                try{
                    gameFinalPrice = Double.parseDouble(gamePrice.getText());
                }catch (NumberFormatException nfe){
                    errorMessage += "Invalid Price for a Game!" + System.lineSeparator();
                }
            }
            if(errorMessage.equals("")){
                //Put doubles in the backend
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(submitButton, errorMessage);
            }
        });

        cancelButton.addActionListener(e -> dispose());

        add(dialogButtons, "span, growx");
        this.pack();
        this.setResizable(false);

        getRootPane().setDefaultButton(submitButton);
    }
}
