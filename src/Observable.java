/**
 * Carl Owen
 * Design Pattern Lab
 * Observable interface
 * Interface adding removing updating adn notifying.
 */
public interface Observable
{
    // Adds observer to list
    void addObserver(ChangeObserver observer);
    // Removes observer to list
    void removeObserver(ChangeObserver observer);
    // Notifies observer to list
    void notifyObservers();
}

