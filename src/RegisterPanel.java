/**
 * Carl Owen
 * Design Pattern Lab
 * RegisterPanel
 * Class for the GUI panel that allows the user to input amount and interact with
 * the register class
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegisterPanel extends JPanel
{
    private Register register; // Reference to the Register class that handles change-making logic
    private JTextField input; // Text field for entering the amount
    private PursePanel changePanel; // Panel to display the current contents of the purse

    // Constructor to initialize the RegisterPanel
    public RegisterPanel(Register register)
    {
        this.register = register; // Assign the Register object passed as an argument

        setLayout(new BorderLayout()); // Set the layout of the panel to BorderLayout

        input = new JTextField(10); // Create a text field to input the amount
        changePanel = new PursePanel(); // Create a PursePanel to display the purse's contents

        JPanel inputPanel = new JPanel(); // Create a new panel for the input components
        inputPanel.add(new JLabel("Enter amount: ")); // Add a label to prompt the user
        inputPanel.add(input); // Add the input field to the panel

        input.addActionListener(new InputListener()); // Add an action listener to handle user input

        add(inputPanel, BorderLayout.NORTH); // Add the input panel to the top of the layout
        add(changePanel, BorderLayout.CENTER); // Add the change panel to the center of the layout
    }


    private class InputListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Parse the inputted amount from the text field
            double amount = Double.parseDouble(input.getText());
            // Use the Register object to calculate the change and get an ObservablePurse
            ObservablePurse purse = register.makeChange(amount);
            // Update the PursePanel with the new purse
            changePanel.setPurse(purse);
        }
    }
}
