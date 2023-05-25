package airlines;

public class BusinessClass extends CabinClass{
    private final double PRICE = 482.78;

    /**
     * Default Constructor for BusinessClass
     */
    public BusinessClass() {

    }

    /**
     * Getter for cabin class, Override from CabinClass
     * @return Cabin class of the flight
     */
    @Override
    public String getCabinClass() {
        return "BS";
    }

    /**
     * Getter for price Override from CabinClass
     * @return Price of the cabin class
     */
    @Override
    public double getPrice() {
        return PRICE;
    }

    /**
     * View the complimentaries of Business Class Override from CabinClass
     */
    @Override
    public void viewComplimentaries() {
        System.out.println("*******Business Class*******\n" +
                "Passengers are offered with:\n" +
                "1. Warm Towel, Welcome Drink\n" +
                "2. Bowl of nuts, Complimentary Champagne\n" +
                "3. Wide Selection of Cocktails and many more.......");
    }
}
