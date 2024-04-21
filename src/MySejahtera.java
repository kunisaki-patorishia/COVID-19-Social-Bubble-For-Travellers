import java.time.LocalDate;
import java.util.Scanner;

public class MySejahtera extends IncomingPassenger {
    private String currentLocation;

    public MySejahtera(String firstName, String lastName, String countryOfOrigin, LocalDate departureDate, String currentLocation) {
        super(firstName, lastName, countryOfOrigin, departureDate);
        this.currentLocation = currentLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int calculateOverallRank() {
        int countryRank = super.countryRank(super.getCountryOfOrigin());
        int locationRank = getLocationRank(currentLocation);
        return Math.max(countryRank, locationRank);
    }

    public String getCountryOfOrigin() {
        return super.getCountryOfOrigin();
    }

    public int getLocationRank(String location) {
        // Assign ranks based on the location visited
        switch (location.toLowerCase()) {
            case "residential compound":
                return 1;
            case "clinic/hospital":
                return 2;
            case "tesco semenyih":
                return 4;
            default:
                return 3; // Default rank for other places
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get passenger details
        String firstName = IncomingPassenger.firstName();
        String lastName = IncomingPassenger.lastName();
        System.out.println();
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println();

        String departCountry = IncomingPassenger.country();
        LocalDate departDate = IncomingPassenger.departureDateInput();

        // Get MySejahtera details
        System.out.print("Enter current location: ");
        String currentLocation = scanner.nextLine().trim();

        // Create an instance of MySejahtera
        MySejahtera passenger = new MySejahtera(firstName, lastName, departCountry, departDate, currentLocation);

        // Determine quarantine period and display information
        passenger.determineQuarantinePeriod();

        // Determine overall rank and display information
        int overallRank = passenger.calculateOverallRank();
        System.out.println("Overall COVID spread probability rank: " + overallRank);
        if (overallRank >= 4) {
            System.out.println("It is not recommended to visit " + passenger.getCurrentLocation() + " due to high COVID spread probability.");
            System.out.println("Please stay safe and follow health guidelines.");
        } else {
            System.out.println("You can visit " + passenger.getCurrentLocation() + " with caution.");
            System.out.println("Stay vigilant and take necessary precautions.");
        }
    }
}