import java.util.ArrayList;

public class User {

    private ArrayList<Place> bars = new ArrayList<Place>();
    private ArrayList<Place> trips = new ArrayList<Place>();
    private Position position;
    private Preferences preferences;
    private String pseudo;

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
        this.trips = t;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position p) {
        this.position = p;
    }

    public Preferences getPreferences() {
        return this.preferences;
    }

    public void setPseudo(String p) {
        this.pseudo = p;
    }

    public String getPseudo() {
        return this.pseudo();
    }

    private void clearList() {
        this.bars = new ArrayList<Place>();
        this.trips = new ArrayList<Place>();
    }

    public void generate() {
        //to implement
        this.clearList();
        if (this.preferences.getTrip()) {
            StrategyTrip st = new StrategyTrip();
            this.trips = st.solve(); //ERROR
        }
        else if (!this.preferences.getTrip()) {
            StrategyBars sb = new StrategyBars();
            this.bars = sb.solve(); //ERROR
        }
    }
}
