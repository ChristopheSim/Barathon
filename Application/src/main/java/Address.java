/**
 * Class to represent an address.
 */

public class Address {
    /**
    * street.
    */
    private String street;
    /**
    * number.
    */
    private String number;
    /**
    * object position.
    */
    private Position position;

    /**
     * Method to generate an address.
     *
     * @param s street.
     * @param n number.
     * @param p position.
     */
    public Address(final String s, final String n, final Position p) {
        this.street = s;
        this.number = n;
        this.position = p;
    }

    /**
     * Method to get the street.
     *
     * @return a string representing the street.
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Method to set the street.
     *
     * @param s a string representing the street.
     */
    public void setStreet(final String s) {
        this.street = s;
    }

    /**
     * Method to get the position.
     *
     * @return a object position.
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Method to set the position.
     *
     * @param p a object position.
     */
    public void setPosition(final Position p) {
        this.position = p;
    }

    /**
     * Method to get the number.
     *
     * @return a string representing the number.
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Method to set the number.
     *
     * @param n a string representing the number.
     */
    public void setNumber(final String n) {
        this.number = n;
    }
}
