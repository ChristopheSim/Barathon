public class Position {

    private Double longitude;
    private Double latitude;

    public Position(Double lo, Double la) {
        this.longitude = lo;
        this.latitude = la;
    }

    public GetLongitude() {
        return this.longitude;
    }

    public GetLatitude() {
        return this.latitude;
    }

    public IsEqually(Position p) {
        // to implement
    }
}
