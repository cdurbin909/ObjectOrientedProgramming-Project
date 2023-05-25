package airlines;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDetails {
    private String flightNumber, airlines, flyingFrom, flyingTo;
    private int seatsAvailable, hoursJourney;
    private LocalDate date;
    private LocalTime time;

    public FlightDetails() {

    }

    public FlightDetails(String flightNumber, String airlines, String flyingFrom, String flyingTo, int seatsAvailable,
                         int hoursJourney, LocalDate date, LocalTime time) {
        this.flightNumber = flightNumber;
        this.airlines = airlines;
        this.flyingFrom = flyingFrom;
        this.flyingTo = flyingTo;
        this.seatsAvailable = seatsAvailable;
        this.hoursJourney = hoursJourney;
        this.date = date;
        this.time = time;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirlines() {
        return airlines;
    }

    public String getFlyingFrom() {
        return flyingFrom;
    }

    public String getFlyingTo() {
        return flyingTo;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public int getHoursJourney() {
        return hoursJourney;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void viewFlightDetails() {
        System.out.println("" +
                "AirLines: " + airlines + "\n" +
                "Flight Number: " + flightNumber + "\n" +
                "Date: " + date + "\n" +
                "Time: " + time + "\n" +
                "Flight flying from: " + flyingFrom + "\n" +
                "Flight flying to: " + flyingTo + "\n" +
                "Number of hours journey: " + hoursJourney + " minutes\n" +
                "Number of seats available: " + seatsAvailable + "\n");
    }
}
