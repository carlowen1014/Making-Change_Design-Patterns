/**
 * Factory Method Design Pattern
 * Concrete factory for creating USD denominations.
 * Allows the `Register` class to dynamically use the denominations
 * defined here without hardcoding them directly.
 */
import java.util.List;

class USDDenominationFactory implements DenominationFactory {
    @Override
    public List<Denomination> createDenominations() {
        return List.of(
                new Denomination("Hundred Dollar Bill", 100.0, "bill", "hundred.png"),
                new Denomination("Fifty Dollar Bill", 50.0, "bill", "fifty.png"),
                new Denomination("Twenty Dollar Bill", 20.0, "bill", "twenty.png"),
                new Denomination("Ten Dollar Bill", 10.0, "bill", "ten.png"),
                new Denomination("Five Dollar Bill", 5.0, "bill", "five.png"),
                new Denomination("One Dollar Bill", 1.0, "bill", "one.png"),
                new Denomination("Quarter", 0.25, "coin", "quarter.png"),
                new Denomination("Dime", 0.10, "coin", "dime.png"),
                new Denomination("Nickel", 0.05, "coin", "nickel.png"),
                new Denomination("Penny", 0.01, "coin", "penny.png")
        );
    }
}

