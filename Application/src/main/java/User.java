import java.io.Console;
import java.util.ArrayList;

public class User {
    private String pseudo;
    private ArrayList<Place> bars;
    private ArrayList<Place> trips;
    private Position position;
    private Preferences preferences;
    private int choice;

    public User(String pseudo, Position po, Preferences pr) {
        this.pseudo = pseudo;
        this.bars = new ArrayList<Place>();
        this.trips = new ArrayList<Place>();
        this.position = po;
        this.preferences = pr;
        this.choice = 0;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String p) {
        this.pseudo = p;
    }

    public ArrayList<Place> getBars() {
        return this.bars;
    }

    public void setBars(ArrayList<Place> b) {
        this.bars = b;
        return;
    }

    public void addBar(Place b) {
        this.bars.add(b);
        return;
    }

    public void removeBar(Place b) {
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

    public void addTrip(ArrayList<Place> t) {
      this.trips.addAll(t);
    }

    public void removeTrip(ArrayList<Place> t) {
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

    public void setChoice(int c) {
        this.choice = c;
    }

    public int getChoice() {
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
            this.trips = st.solve(this.position, this.preferences.getCaracteristics().get(0)); //ERROR
        }
        else if (!this.preferences.getTrip()) {
            StrategyBars sb = new StrategyBars();
            this.bars = sb.solve(this.position, this.preferences.getCaracteristics().get(0)); //ERROR
        }
    }

    public int chooseCaracterictics() {
        Console console = System.console();

        String msg = String.format("Choose Caracteristic [0-%01d]", this.preferences.getNbCaracteristic());
        System.out.println(msg);
        int input = Integer.parseInt(console.readLine());
        //TO REMOVE
        this.choice = input;
        return input;
    }
}
