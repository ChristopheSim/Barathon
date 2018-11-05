public class Address {

    private String street;
    private String number;
    private Position position;

    public Address(String s, String n, Position p) {
        this.street = s;
        this.number = n;
        this.Position = p;
    }

    public getStreet() {
        return this.street;
    }

    public getPosition() {
        return this.position;
    }

    public getNumber() {
        return this.number;
    }
}
