public class Address {

    private String street;
    private String number;
    private Position position;

    public void Address(String s, String n, Position p) {
        this.street = s;
        this.number = n;
        this.Position = p;
    }

    public String getStreet() {
        return this.street;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getNumber() {
        return this.number;
    }
}
