package airlines;

public enum Discounts {
    STUDENT(13.5), COUPON(7), HALLOWEEN(9.3), CHRISTMAS(6.7), NONE(0);

    private double value;

    private Discounts(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
