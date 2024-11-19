/**
 * Carl Owen
 * Design Pattern Lab
 * Purse class
 * Very little changes adding and removing denominations
 */


import java.util.HashMap;
import java.util.Map;

public class Purse
{
    // Map to hold denominations and their corresponding count
    private final Map<Denomination, Integer> cash = new HashMap<>();

    /**
     * Adds a certain number of a specific denomination to the purse.
     * @param denomination The denomination to add.
     * @param count The number of this denomination to add.
     */
    public void add(Denomination denomination, int count)
    {
        // Update map by adding the specified denomination and count
        cash.put(denomination, cash.getOrDefault(denomination, 0) + count);
    }

    /**
     * Removes a certain number of a specific denomination from the purse.
     * @param denomination The denomination to remove.
     * @param count The number of this denomination to remove.
     * @return The total value of the denominations removed.
     */
    public double remove(Denomination denomination, int count)
    {
        if (cash.containsKey(denomination))
        {
            // Get the current count of the denomination in the purse
            int currentCount = cash.get(denomination);
            // Remove as many as possible (up to the specified count)
            int toRemove = Math.min(currentCount, count);
            cash.put(denomination, currentCount - toRemove);
            // Return the total value removed
            return toRemove * denomination.amt();
        }
        return 0;
    }

    /**
     * Gets the total value of all the denominations in the purse.
     * @return The total value of the purse.
     */
    public double getValue()
    {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    /**
     * Gets the cash map (denominations and their counts) in the purse.
     * @return The map of denominations and counts.
     */
    public Map<Denomination, Integer> getCash()
    {
        return cash;
    }

    @Override
    public String toString()
    {
        // String representation of the purse's contents
        StringBuilder sb = new StringBuilder("Purse contents:\n");
        cash.forEach((denomination, count) -> {
            sb.append(count).append(" x ").append(denomination.name())
                    .append(" (").append(denomination.form()).append(") - $")
                    .append(denomination.amt()).append("\n");
        });
        return sb.toString();
    }
}

