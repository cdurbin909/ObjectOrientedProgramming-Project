package airlines;

public class NotSufficientSeatsException extends Exception {
    public NotSufficientSeatsException(String message) {
        super(message);
    }
}
