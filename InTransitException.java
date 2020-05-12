/**
 * Indicate that the taxi already has a target location if it is assigned another passanger
 *
 * @author Jordan Thomson
 * @version 05/05/2020
 */
public class InTransitException extends RuntimeException {

    private Vehicle vehicle;

    /**
     * Constructor for objects of class InTransitException.
     * @param vehicle The vehicle expecting a passenger.
     */
    public InTransitException(Vehicle vehicle) {
        super("Vehicle already has a target location.");
    }

    /**
     * @return The vehicle that is already in transit to a location.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }
}
