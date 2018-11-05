public class Position {

    private Double longitude;
    private Double latitude;

    public Position(Double lo, Double la) {
        this.longitude = lo;
        this.latitude = la;
    }

    public getLongitude() {
        return this.longitude;
    }

    public getLatitude() {
        return this.latitude;
    }

    public isEqually(Position p) {
        // to implement
    }
}
