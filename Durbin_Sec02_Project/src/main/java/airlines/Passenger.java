package airlines;

public class Passenger {
    String firstName, lastName, passportNumber;
    long phoneNumber;

    /**
     * Constructor for Passenger class
     * @param firstName First name of the passenger
     * @param lastName Last name of the passenger
     * @param passportNumber Passport number of the passenger
     * @param phoneNumber Phone number of the passenger
     */
    public Passenger(String firstName, String lastName, String passportNumber, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for first name
     * @return First name of the passenger
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name
     * @param firstName First name of the passenger
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for last name
     * @return Last name of the passenger
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for last name
     * @param lastName Last name of the passenger
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for passport number
     * @return Passport number of the passenger
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Setter for passport number
     * @param passportNumber Passport number of the passenger
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * Getter for phone number
     * @return Phone number of the passenger
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phone number
     * @param phoneNumber Phone number of the passenger
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Name of person method
     * @return String representation of the passenger's name
     */
    public String nameOfPerson() {
        return firstName + " " + lastName;
    }

    /**
     * String including passenger information
     */
    public void detailsOfPassenger() {
        System.out.println("Passenger Details\n" +
                            "--------------------\n" +
                            "Name: " + lastName + ", " + firstName + "\n" +
                            "Passport Number: " + passportNumber + "\n" +
                            "Phone Number: " + phoneNumber + "\n");
    }
}
