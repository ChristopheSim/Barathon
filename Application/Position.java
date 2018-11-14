import java.lang.*;

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

    public boolean isEqual(Position p) {
      try {
  			int result = Double.compare(this.longitude, p.longitude);
        int result2 = Double.compare(this.latitude, p.latitude);
        return result == 0 && result2 == 0;
  		}
  		catch (Exception e) {
  			System.out.println("Position Comparison Error: Double.compare exception");
  		}
    }
}
