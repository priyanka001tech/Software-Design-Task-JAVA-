import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {

    @Test
    void addPassengerTest() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger passenger1 = new Passenger("John", 1, PassengerType.STANDARD);
        Passenger passenger2 = new Passenger("Alice", 2, PassengerType.STANDARD);
        Passenger passenger3 = new Passenger("Bob", 3, PassengerType.STANDARD);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        // Trying to add the third passenger should fail as capacity is only 2
        travelPackage.addPassenger(passenger3);

        assertEquals(2, travelPackage.getPassengers().size());
    }

    @Test
    void printItineraryTest() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Destination destination1 = new Destination("Destination 1");
        Destination destination2 = new Destination("Destination 2");
        Activity activity1 = new Activity("Activity 1", "Description 1", 50.0, 10, destination1);
        Activity activity2 = new Activity("Activity 2", "Description 2", 75.0, 15, destination2);
        destination1.addActivity(activity1);
        destination2.addActivity(activity2);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        travelPackage.printItinerary();

        // Restore original output stream
        System.setOut(originalOut);

        String expectedOutput = "Travel Package: Test Package\n" +
                "Itinerary:\n" +
                "Destination: Destination 1\n" +
                "Activities:\n" +
                "Activity: Activity 1 - Description: Description 1 - Cost: 50.0 - Capacity: 10\n" +
                "Destination: Destination 2\n" +
                "Activities:\n" +
                "Activity: Activity 2 - Description: Description 2 - Cost: 75.0 - Capacity: 15\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void printPassengerListTest() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger passenger1 = new Passenger("John", 1, PassengerType.STANDARD);
        Passenger passenger2 = new Passenger("Alice", 2, PassengerType.STANDARD);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        travelPackage.printPassengerList();

        // Restore original output stream
        System.setOut(originalOut);

        String expectedOutput = "Travel Package: Test Package\n" +
                "Passenger List:\n" +
                "Passenger: John - Passenger Number: 1\n" +
                "Passenger: Alice - Passenger Number: 2\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}

class DestinationTest {

    @Test
    void addActivityTest() {
        Destination destination = new Destination("Test Destination");
        Activity activity1 = new Activity("Activity 1", "Test Description 1", 50.0, 10, destination);
        Activity activity2 = new Activity("Activity 2", "Test Description 2", 75.0, 15, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        assertEquals(2, destination.getActivities().size());
    }
}

class ActivityTest {

    @Test
    void activityToStringTest() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);

        assertEquals("Activity: Test Activity - Description: Test Description - Cost: 50.0 - Capacity: 10", activity.toString());
    }
}

class PassengerTest {

    @Test
    void passengerToStringTest() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD);

        assertEquals("Passenger: John - Passenger Number: 1", passenger.toString());
    }
}
