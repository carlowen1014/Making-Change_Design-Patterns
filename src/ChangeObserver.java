/**
 * Observer Design Pattern
 * Defines an interface for observers to be notified of changes in the purse.
 */
interface ChangeObserver {
    /**
     * Method to notify the observer of a change in the purse.
     * @param purse the updated purse
     */
    void notifyChange(Purse purse);
}

