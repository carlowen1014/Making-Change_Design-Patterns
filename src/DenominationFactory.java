/**
 * Factory Method Design Pattern
 * Interface for creating a list of denominations.
 * This allows the creation of denominations to be dynamic and extensible.
 */
interface DenominationFactory
{
    List<Denomination> createDenominations();
}

