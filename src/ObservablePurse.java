/**
*Adding this for the purpose of extended the purse class
 * subclass
 */



import java.util.ArrayList;
import java.util.List;

/**
 * Observer Design Pattern
 * Extends the `Purse` class to add observer support.
 * Observers are notified whenever the purse's state changes.
 */
class ObservablePurse extends Purse {
    private List<ChangeObserver> observers = new ArrayList<>();

    /**
     * Adds an observer to the list of observers.
     * @param observer the observer to add
     */
    public void addObserver(ChangeObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     * @param observer the observer to remove
     */
    public void removeObserver(ChangeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void add(Denomination type, int num) {
        super.add(type, num);
        notifyObservers();
    }

    @Override
    public double remove(Denomination type, int num) {
        double removedValue = super.remove(type, num);
        notifyObservers();
        return removedValue;
    }

    /**
     * Notifies all observers of a state change in the purse.
     */
    private void notifyObservers()
    {
        for (ChangeObserver observer : observers)
        {
            observer.notifyChange(this);
        }
    }
}

