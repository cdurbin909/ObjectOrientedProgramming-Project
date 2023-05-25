package airlines;

import java.util.ArrayList;

public class FlightsAvailable {
    private ArrayList<FlightDetails> flights;

    public FlightsAvailable() {
        flights = new ArrayList<>();
    }

    public ArrayList<FlightDetails> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<FlightDetails> flights) {
        this.flights = flights;
    }

    public void addFlight(FlightDetails flight) {
        flights.add(flight);
    }

    public void viewAvailableFlights() {
        System.out.println("Available Flights\n--------------------------\n");
        System.out.printf("%-20s %-15s %-15s %-15s %-15s %-8s %-18s %-15s\n", "Airlines", "Flight Number", "Flying " +
                        "From", "Flying To", "Date", "Time", "Seats Available", "Travel Time");
        for (FlightDetails flight : flights) {
            System.out.printf("%-20s %-15s %-15s %-15s %-15s %-8s %-18s %-15s\n", flight.getAirlines(),
                    flight.getFlightNumber(),
                    flight.getFlyingFrom(), flight.getFlyingTo(), flight.getDate(), flight.getTime(),
                    flight.getSeatsAvailable(), flight.getHoursJourney());
        }
    }
}
