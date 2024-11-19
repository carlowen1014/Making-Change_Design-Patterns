public interface Observable {
    void addObserver(ChangeObserver observer);
    void removeObserver(ChangeObserver observer);
    void notifyObservers();
}

