import java.util.ArrayList;
import java.util.List;

// Enum representing passenger types
enum PassengerType {
    STANDARD,
    GOLD,
    PREMIUM
}

// Class representing a travel package
class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Cannot add more passengers. Capacity reached.");
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        System.out.println("Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }
}

// Class representing a destination
class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    // Override toString to print destination name and activities
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Destination: ").append(name).append("\n");
        sb.append("Activities:\n");
        for (Activity activity : activities) {
            sb.append(activity).append("\n");
        }
        return sb.toString();
    }
}

// Class representing an activity
class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    // Override toString to print activity details
    @Override
    public String toString() {
        return "Activity: " + name + " - Description: " + description + " - Cost: " + cost + " - Capacity: " + capacity;
    }
}

// Class representing a passenger
class Passenger {
    private String name;
    private int passengerNumber;
    private PassengerType passengerType;

    public Passenger(String name, int passengerNumber, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
    }

    // Override toString to print passenger details
    @Override
    public String toString() {
        return "Passenger: " + name + " - Passenger Number: " + passengerNumber;
    }
}

// Subclasses for different passenger types
class StandardPassenger extends Passenger {
    private double balance;

    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, PassengerType.STANDARD);
        this.balance = balance;
    }

    // Getters and setters for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class GoldPassenger extends Passenger {
    private double balance;

    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, PassengerType.GOLD);
        this.balance = balance;
    }

    // Getters and setters for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber, PassengerType.PREMIUM);
    }
}
