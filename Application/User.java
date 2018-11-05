import java.util.ArrayList;

public class User {

    private ArrayList<Place> bars = new ArrayList<Place>();
    private ArrayList<Place> trips = new ArrayList<Place>();
    private Position position;
    private Preferences preferences;

    public void User(Position po, Preferences pr) {
        this.position = po;
        this.preferences = pr;
    }

    public ArrayList<Place> getBars() {
        return this.bars;
    }

    public void setBars(ArrayList<Place> b) {
        this.bars = b;
        return;
    }

    public ArrayList<Place> getTrips() {
        return this.trips;
    }

    public void setTrips(ArrayList<Place> t) {
        this.Trips = t;
        return;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position p) {
        this.position = p;
        return;
    }

    public Preferences getPreferences() {
        return this.preferences;
    }
}
