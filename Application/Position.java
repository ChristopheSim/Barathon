public class Position {

    private Double longitude;
    private Double latitude;

    public void Position(Double lo, Double la) {
        this.longitude = lo;
        this.latitude = la;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Bool isEqually(Position p) {
        // to implement
    }
}
