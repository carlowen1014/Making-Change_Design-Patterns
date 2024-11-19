import javax.swing.*;
import java.awt.*;
import java.util.Map;

class PursePanel extends JPanel implements ChangeObserver {
    private ObservablePurse purse = new ObservablePurse();

    public void setPurse(ObservablePurse purse) {
        this.purse = purse;
        this.purse.addObserver(this);  // Subscribe to updates
        repaint();
    }

    @Override
    public void notifyChange(Observable observable) {
        // Update the display when notified of a change
        if (observable instanceof ObservablePurse) {
            this.purse = (ObservablePurse) observable;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 20;
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            g.drawString(entry.getValue() + " x " + entry.getKey().name(), 10, y);
            y += 20;
        }
    }
}
