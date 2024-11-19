import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Represents the display of the contents of the Purse.
 * Implements ChangeObserver to react to updates in ObservablePurse.
 */
class PursePanel extends JPanel implements ChangeObserver {
    private Purse purse = new ObservablePurse();

    /**
     * Sets the Purse and triggers a repaint.
     * @param purse the updated purse
     */
    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    /**
     * Notified by the ObservablePurse when its state changes.
     * @param purse the updated ObservablePurse
     */
    @Override
    public void notifyChange(Purse purse) {
        this.purse = purse;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Starts vertical position of the text
        int y = 20;
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            g.drawString(entry.getValue() + " x " + entry.getKey().name(), 10, y);
            y += 20;
        }
    }
}

