
/**
 * Indicate that there is a passenger that has the same destination as the pickup location.
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
