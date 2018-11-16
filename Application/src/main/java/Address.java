public class Address {

    private String street;
    private String number;
    private Position position;

    public Address(String s, String n, Position p) {
        this.street = s;
        this.number = n;
        this.position = p;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String s) {
        this.street = s;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position p) {
        this.position = p;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String n) {
        this.number = n;
    }
}
