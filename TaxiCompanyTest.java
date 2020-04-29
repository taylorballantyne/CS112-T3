import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * The test class TaxiCompanyTest.
 *
 * @author  Jordan
 * @version 28/04/2020
 */
public class TaxiCompanyTest {

    private TaxiCompany company;

    public TaxiCompanyTest() {

    }

    /**
     * Create a taxi company.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        company = new TaxiCompany();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * since the addition of method to add and remove vehicles
     * test they work correctly
     */
    @Test
    public void addOneVehicleTest() {
        Location taxiLocation = new Location(0, 0);
        Vehicle taxi = new Taxi(company, taxiLocation);
        company.addVehicles(taxi);
        assertNotNull(company.getVehicles());
        List<Vehicle> taxis = new LinkedList<>();
        taxis = company.getVehicles();
        assertEquals(1, taxis.size());
    }

    /**
     * since the addition of method to add and remove vehicles
     * test they work correctly
     */
    @Test
    public void removeOneVehicle() {
        Location taxiLocation = new Location(0, 0);
        Vehicle taxi = new Taxi(company, taxiLocation);
        company.addVehicles(taxi);
        company.removeVehicle(taxi);
        List<Vehicle> taxis = new LinkedList<>();
        assertEquals(0, taxis.size());
    }

    /**
     * Test to see if the pick-up method works where first taxi picks up
     * the customer but there is no taxi available for second request.
     */
    @Test
    public void requestPickup() {
        Location pickup = new Location(1, 2);
        Location destination = new Location(5, 6);
        Passenger passenger = new Passenger(pickup, destination);
        Passenger passenger2 = new Passenger(pickup, destination);
        addOneVehicleTest();
        // test 1 taxi picks up customer without issues
        assertEquals(true, company.requestPickup(passenger));
        // test no taxi available for second pick-up
        assertEquals(false, company.requestPickup(passenger2));

    }

    @Test
    public void arrivedAtPickup() {
        Location pickup = new Location(1, 2);
        Location destination = new Location(5, 6);
        Passenger passenger = new Passenger(pickup, destination);
        Vehicle taxi = new Taxi(company,new Location(0,0));
        company.addVehicles(taxi);
        company.requestPickup(passenger);
        taxi.act();
        taxi.act();
        assertEquals(passenger.getPickupLocation(), taxi.getLocation());
    }

    @Test
    public void arrivedAtDestination() {
        Location pickup = new Location(1, 2);
        Location destination = new Location(5, 6);
        Passenger passenger = new Passenger(pickup, destination);
        Vehicle taxi = new Taxi(company,new Location(0,0));
        company.addVehicles(taxi);
        company.requestPickup(passenger);
        taxi.act();
        taxi.act();
        taxi.act();
        taxi.act();
        taxi.act();
        taxi.act();
        assertEquals(passenger.getDestination(), taxi.getLocation());
    }
}