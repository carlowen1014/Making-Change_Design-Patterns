/**
 * Carl Owen
 * Design Pattern Lab
 * Denomination Factory
 * Interface for creating a list of denominations.
 * This allows the creation of denominations to be dynamic and extensible.
 */
import java.util.List;

interface DenominationFactory
{
    List<Denomination> createDenominations();
}

