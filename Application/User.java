import java.io.Console;
import java.util.ArrayList;

public class User {

    private ArrayList<Place> bars;
    private ArrayList<Place> trips;
    private Position position;
    private Preferences preferences;
    private String pseudo;
    private Int choice;

    public void User(Position po, Preferences pr) {
        this.bars = new ArrayList<Place>();
        this.trips = new ArrayList<Place>();
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

    public void AddBar(Place b) {
        this.bars.add(b);
        return;
    }

    public void RemoveBar(Place b) {
      if (this.bars.contains(b)) {
        this.bars.remove(b);
      } else {
        System.out.println("Place not deleted (not found)");
      }
    }

    public ArrayList<Place> getTrips() {
        return this.trips;
    }

    public void setTrips(ArrayList<Place> t) {
        this.trips = t;
    }

    public void AddTrip(ArrayList<Place> t) {
      this.trips.add(t);
    }

    public void RemoveTrip(ArrayList<Place> t) {
      if (this.trips.contains(t)) {
        this.trips.remove(t);
      } else {
        System.out.println("Trip not deleted (not found)");
      }
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

    public void setPreferences(Preferences pr) {
      this.preferences = pr;
    }

    public void setPseudo(String p) {
        this.pseudo = p;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setChoice(Int c) {
        this.choice = c;
    }

    public Int getChoice() {
        return this.choice;
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
            this.trips = st.solve(this.position, this.preferences); //ERROR
        }
        else if (!this.preferences.getTrip()) {
            StrategyBars sb = new StrategyBars();
            this.bars = sb.solve(this.position, this.preferences); //ERROR
        }
    }

    public Int ChooseCaracterictics() {
        Console console = System.Console();

        String msg = String.format()"Choose Caracteristic [0-%01d]", this.preferences.getNbCaracteristic());
        System.out.println(msg);
        Int input = Integer.parseInt(console.readLine());
        //TO REMOVE
        this.choice = input;
        return input;
    }
}
