import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Student name: Patricia Chin Ling Choo"); //show student name
        
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
