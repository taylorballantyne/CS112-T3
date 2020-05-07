
/**
 * Indicate that there was no passenger at a pickup point.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class DuplicateLocationException extends RuntimeException
{
    private Passenger passenger;
    /**
     * Constructor for objects of class DuplicateLocationException.
     * @param passenger The passenger with duplicate locations.
     */
    public DuplicateLocationException(Passenger passenger)
    {
        super("Passenger's pickup location is the same as thier destanation.");
    }

    /**
     * @return The passenger for which there was duplicate location values.
     */
    public Passenger getPassenger()
    {
        return passenger;
    }
}
