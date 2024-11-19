

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ObservablePurse class that extends Purse and implements the Observable interface.
 */
public class ObservablePurse extends Purse implements Observable {
    private final List<ChangeObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(ChangeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ChangeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ChangeObserver observer : observers) {
            observer.notifyChange(this);
        }
    }

    @Override
    public void add(Denomination type, int num) {
        super.add(type, num);
        notifyObservers();  // Notify observers whenever an addition is made.
    }

    @Override
    public double remove(Denomination type, int num) {
        double removedValue = super.remove(type, num);
        notifyObservers();  // Notify observers whenever a removal is made.
        return removedValue;
    }
}
