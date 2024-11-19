import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegisterPanel extends JPanel {
    private Register register;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel(Register register) {
        this.register = register;

        setLayout(new BorderLayout());

        input = new JTextField(10);
        changePanel = new PursePanel();

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter amount: "));
        inputPanel.add(input);

        input.addActionListener(new InputListener());

        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(input.getText());
            ObservablePurse purse = register.makeChange(amount);
            changePanel.setPurse(purse);
        }
    }
}
