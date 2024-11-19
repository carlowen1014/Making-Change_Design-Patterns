// Carl Owen
// Design Pattern Lab
// Mon. 18 Nov. 2024
// Adding design methods and implementations to the Making Change Lab

import javax.swing.*;


 // Main class that serves as the entry point for the Making Change application.

public class MakingChange
{
    public static void main(String[] args)
    {
        // Initialize the factory and register with denominations dynamically created
        DenominationFactory factory = new USDDenominationFactory();
        Register register = new Register(factory);

        // Set up the JFrame and GUI panel
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        RegisterPanel panel = new RegisterPanel(register);
        frame.add(panel);

        frame.setVisible(true);
    }
}
