/**
 * Carl Owen
 * Design Pattern Lab
 * PursePanel class
 * Custom class very small changes for implementing
 * design pattern methods whilst displaying contents
 */
import javax.swing.*;
import java.awt.*;
import java.util.Map;

class PursePanel extends JPanel implements ChangeObserver
{
    private ObservablePurse purse = new ObservablePurse();

    public void setPurse(ObservablePurse purse)
    {
        this.purse = purse;
        this.purse.addObserver(this);  // Subscribe to updates
        repaint();
    }

    // Updates the panel display when the purse changes (e.g., money is added or removed)
    @Override
    public void notifyChange(Observable observable)
    {
        // Update the display when notified of a change
        if (observable instanceof ObservablePurse)
        {
            this.purse = (ObservablePurse) observable;
            repaint(); // Repaint the panel to reflect the updated purse state
        }
    }

    // Custom paint method to display the purse's cash denominations and quantities
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int y = 20; // Starting vertical position for drawing text
        // Loop through each entry in the purse's cash map and display denomination and quantity
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet())
        {
            g.drawString(entry.getValue() + " x " + entry.getKey().name(), 10, y);
            y += 20; // Move down to draw the next line
        }
    }
}
