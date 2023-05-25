package airlines;

import java.util.Random;

public class TicketDetails {
    private FlightDetails flight;
    private Passenger passenger;
    private CabinClass cabinClass;
    private Double discount;
    private String foodType;

    Random rand = new Random();

    public TicketDetails(FlightDetails flight, Passenger passenger, CabinClass cabinClass, Double discount,
                         String foodType) {
        this.flight = flight;
        this.passenger = passenger;
        this.cabinClass = cabinClass;
        this.discount = discount;
        this.foodType = foodType;
    }

    public FlightDetails getFlight() {
        return flight;
    }

    public void setFlight(FlightDetails flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public CabinClass getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(CabinClass cabinClass) {
        this.cabinClass = cabinClass;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public char generateDepartureGate() {
        return (char) (rand.nextInt(26) + 'A');
    }

    public String generateSeatNumber() {
        int num = rand.nextInt(37);
        char c = (char) (rand.nextInt(7) + 'A');
        return num + " " + c;
    }

    public double calculateTax() {
        return (cabinClass.getPrice() - (cabinClass.getPrice() * (discount))) * 0.075;
    }

    public double calculateAmount() {
        return cabinClass.getPrice() - (cabinClass.getPrice() * (discount)) + calculateTax();
    }


    public void displayTicket() {
        System.out.println(flight.getAirlines() + "********** Ticket **********\n" +
                "Passenger Name:\t" + "Flight Number:\t" + "Class:\t" + "Date:\t" + "Time:\t\n" +
                passenger.nameOfPerson() + "\t" + flight.getFlightNumber() + "\t" + cabinClass.getCabinClass() +
                        "\t" + flight.getDate() + "\t" +
                flight.getTime() + "\n" + "From: " + flight.getFlyingFrom() + "\tSeat:\t" + "Gate:\t" +
                "Meals Type:\t" + "To: " + flight.getFlyingTo() + "\n\t" + generateSeatNumber() + "\t" +
                generateDepartureGate() + "\t" + foodType + "\n" + "Price: $" + cabinClass.getPrice() + "Tax:\t" +
                calculateTax() + "Total:\t\n" + calculateAmount());
    }
}
