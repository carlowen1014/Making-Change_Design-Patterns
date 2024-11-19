import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel where the user interacts with the Register.
 */
class RegisterPanel extends JPanel {
    private final Register register;
    private final JTextField input;
    private final PursePanel changePanel;
    private final ObservablePurse observablePurse;

    public RegisterPanel(Register register) {
        this.register = register;
        this.observablePurse = new ObservablePurse();

        // Set up layout and components
        setLayout(new BorderLayout());
        input = new JTextField(10);
        changePanel = new PursePanel();
        observablePurse.addObserver(changePanel); // Subscribe PursePanel to ObservablePurse

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter amount: "));
        inputPanel.add(input);
        input.addActionListener(new InputListener());

        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);
    }

    /**
     * Inner class to handle user input.
     */
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Parse the input and make change
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                if (purse instanceof ObservablePurse) {
                    observablePurse.getCash().clear();
                    purse.getCash().forEach(observablePurse::add);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this,
                        "Please enter a valid amount.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

