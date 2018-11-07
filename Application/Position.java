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

    public void setLongitude(Double lo) {
        this.longitude  = lo;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double la) {
        this.latitude = la;
    }

    public boolean isEqually(Position p) {
        //to implement
        return this.longitude == p.getLongitude() && this.latitude == p.getLatitude();
    }
}
