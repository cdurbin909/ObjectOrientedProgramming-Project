package airlines;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/airlines/flights.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner scan = new Scanner(System.in);

        // Flight details
        FlightsAvailable flights = new FlightsAvailable();
        while (fileScanner.hasNextLine()) {
            String airline = fileScanner.nextLine();
            String flightNumber = fileScanner.nextLine();
            String[] fromTo = fileScanner.nextLine().split(" - ");
            String from = fromTo[0];
            String to = fromTo[1];
            String[] temp = (fileScanner.nextLine().split(" "));
            int seatsAvailable = Integer.parseInt(temp[0]);
            LocalDate date = LocalDate.parse(fileScanner.nextLine());
            LocalTime time = LocalTime.parse(fileScanner.nextLine());
            temp = fileScanner.nextLine().split(" ");
            int minutes = Integer.parseInt(temp[0]);
            flights.addFlight(new FlightDetails(flightNumber, airline, from, to, seatsAvailable, minutes, date, time));
        }

        // Passenger Details
        System.out.println("Flight Tickets Booking\n===================================");
        System.out.println("Enter your first name: ");
        String firstName = scan.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scan.nextLine();
        System.out.println("Enter your passport number: ");
        String passportNumber = scan.nextLine();
        System.out.println("Enter your phone number: ");
        long phoneNumber = scan.nextLong();
        Passenger passenger = new Passenger(firstName, lastName, passportNumber, phoneNumber);
        passenger.detailsOfPassenger();

        while (true) {
            // Available Flights
            flights.viewAvailableFlights();

            // Choose Flight
            System.out.println("Choose the date you would like to fly: ");
            LocalDate date = LocalDate.parse(scan.next());
            System.out.println("Enter the from and to places: ");
            String from = scan.next();
            String to = scan.next();

            // Show flights
            FlightsAvailable available = new FlightsAvailable();
            for (FlightDetails f : flights.getFlights()) {
                if (f.getDate().equals(date) && f.getFlyingFrom().equals(from) && f.getFlyingTo().equals(to)) {
                    available.addFlight(f);
                }
            }
            if(available.getFlights().size() != 0) {
                int total = 0;
                available.viewAvailableFlights();
                System.out.println("Choose the airline you would like to fly: ");
                String airline = scan.next();
                try {
                    for (FlightDetails f : available.getFlights()) {
                        if (f.getAirlines().equalsIgnoreCase(airline)) {
                            System.out.println("Would you like to book this flight? (Yes/No): ");
                            String choice = scan.next();
                            if (choice.equalsIgnoreCase("yes")) {
                                try {
                                    if (f.getSeatsAvailable() != 0) {
                                        System.out.println("Thank you for choosing " + f.getAirlines());
                                        System.out.println("Choose the type of cabin class: ");
                                        System.out.println("1. Business Class\t2. Economy Class");
                                        scan.nextLine();
                                        String c = scan.nextLine();
                                        CabinClass cabin;
                                        if (c.equalsIgnoreCase("business")) {
                                            cabin = new BusinessClass();
                                        }
                                        else {
                                            cabin = new EconomyClass();
                                        }
                                        System.out.println("Choose the type of meals you like to have: ");
                                        System.out.println("1. Vegetarian\t2. Non-Vegetarian\t3. International");
                                        String meal = scan.nextLine();
                                        System.out.println("Choose the discount type: ");
                                        System.out.println(
                                                "1. STUDENT\t2. HALLOWEEN\t3. CHRISTMAS\t4. COUPONS\t5. NONE");
                                        Discounts discount = Discounts.valueOf(scan.nextLine());
                                        TicketDetails t =
                                                new TicketDetails(f, passenger, cabin, discount.getValue(), meal);
                                        t.displayTicket();
                                        f.setSeatsAvailable(f.getSeatsAvailable() - 1);
                                        total += 1;
                                        System.out.println("Would you like to continue?");
                                        String cont = scan.next();
                                        if (cont.equalsIgnoreCase("no")) {
                                            System.exit(0);
                                        }
                                    }
                                    else {
                                        throw new NotSufficientSeatsException("No seats available");
                                    }
                                }catch (NotSufficientSeatsException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Would you like to continue?");
                                    String cont = scan.next();
                                    if (cont.equalsIgnoreCase("no")) {
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                    if (total == 0) {
                        throw new InvalidAirlineException("Invalid Airlines");
                    }
                } catch (InvalidAirlineException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Would you like to continue?");
                    String choice = scan.next();
                    if (choice.equalsIgnoreCase("no")) {
                        break;
                    }
                }
            }
            else {
                System.out.println("No flights available");
                // Ask to continue
                System.out.println("Would you like to continue?");
                String choice = scan.next();
                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            }
        }
    }
}
