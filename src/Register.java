/**
 * Carl Owen
 * Design Pattern Lab
 * Register class
 * This class simply handles the logic of making the change
 * using list from DEnomination class, it updates constantly
 */

import java.util.List;

/**
 * Represents the Register logic for making change.
 * Uses a factory to dynamically obtain a list of denominations.
 */
class Register
{
    private final List<Denomination> denominations;

    /**
     * Constructor that initializes the Register with denominations from the factory.
     * @param factory the factory to create denominations
     */
    public Register(DenominationFactory factory)
    {
        this.denominations = factory.createDenominations();
    }

    /**
     * Calculates the fewest number of bills/coins for a given amount.
     * @param amt the amount to make change for
     * @return a Purse containing the change
     */
    public ObservablePurse makeChange(double amt)
    {
        ObservablePurse purse = new ObservablePurse();
        for (Denomination denomination : denominations)
        {
            int count = (int) (amt / denomination.amt());
            if (count > 0)
            {
                purse.add(denomination, count);
                amt -= count * denomination.amt();
            }
        }
        return purse;
    }
}

