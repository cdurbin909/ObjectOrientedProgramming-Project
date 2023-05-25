package airlines;

public class EconomyClass extends CabinClass{
    private final double PRICE = 482.76;

    public EconomyClass() {

    }

    public String getCabinClass() {
        return "EC";
    }

    public double getPrice() {
        return PRICE;
    }

    public void viewComplimentaries() {
        System.out.println("*******Economy Class*******\n" +
                "Passengers are offered with:\n" +
                "1. Multi-Meal\n" +
                "2. Fruits, Salad, Crackers, Cheese of your choice\n" +
                "3. Drinks like fruit juices, soft drinks, beers, wines");
    }
}
