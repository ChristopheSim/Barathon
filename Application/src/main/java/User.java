import java.io.Console;
import java.util.ArrayList;

/**
 * Class to represent a user.
 */
public class User {
    private String pseudo;
    private ArrayList<Place> bars;
    private ArrayList<Place> trips;
    private Position position;
    private Preferences preferences;
    private int choice;

    /**
     * Method to generate a user.
     *
     * @param pseudo user's pseudo.
     * @param po user's position.
     * @param pr user's preferences.
     */
    public User(String pseudo, Position po, Preferences pr) {
        this.pseudo = pseudo;
        this.bars = new ArrayList<Place>();
        this.trips = new ArrayList<Place>();
        this.position = po;
        this.preferences = pr;
        this.choice = 0;
    }

    /**
     * Method to get the user's pseudo.
     *
     * @return a string representing the user's pseudo.
     */
    public String getPseudo() {
        return this.pseudo;
    }

    /**
     * Method to set the user's pseudo.
     *
     * @param p a string representing the user's pseudo.
     */
    public void setPseudo(String p) {
        this.pseudo = p;
    }

    /**
     * Method to get a list of bars.
     *
     * @return a list representing the bars to visit.
     */
    public ArrayList<Place> getBars() {
        return this.bars;
    }

    /**
     * Method to set a list of bars.
     *
     * @param b list representing the bars to visit.
     */
    public void setBars(ArrayList<Place> b) {
        this.bars = b;
        return;
    }

    /**
     * Method to add a bar to the list of bars.
     *
     * @param b place representing the bar to add.
     */
    public void addBar(Place b) {
        this.bars.add(b);
        return;
    }

    /**
     * Method to remove a bar of the list.
     *
     * @param b place representing the bar to remove.
     */
    public void removeBar(Place b) {
        if (this.bars.contains(b)) {
            this.bars.remove(b);
        } else {
            System.out.println("Place not deleted (not found)");
        }
    }

    /**
     * Method to get a list of bars.
     *
     * @return a list representing the bars to visit.
     */
    public ArrayList<Place> getTrips() {
        return this.trips;
    }

    /**
     * Method to set a list of bars.
     *
     * @param t list representing the bars to visit.
     */
    public void setTrips(ArrayList<Place> t) {
        this.trips = t;
    }

    /**
     * Method to add a bar to the list of bars.
     *
     * @param t place representing the bar to add.
     */
    public void addTrip(ArrayList<Place> t) {
        this.trips.addAll(t);
    }

    /**
     * Method to remove a bar of the list.
     *
     * @param t place representing the bar to remove.
     */
    public void removeTrip(ArrayList<Place> t) {
        if (this.trips.contains(t)) {
            this.trips.remove(t);
        } else {
            System.out.println("Trip not deleted (not found)");
        }
    }

    /**
     *  Method to get the user's Position.
     *
     * @return a position representing the user's position.
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Method to set the user's position.
     *
     * @param p a position representing the user's position.
     */
    public void setPosition(Position p) {
        this.position = p;
    }

    /**
     * Method to get the user's preferences.
     *
     * @return a preferences representing the user's preferences.
     */
    public Preferences getPreferences() {
        return this.preferences;
    }

    /**
     * Method to set the user's preferences.
     *
     * @param pr a preferences representing the user's preferences.
     */
    public void setPreferences(Preferences pr) {
        this.preferences = pr;
    }

    /**
     *  Method to set the user's choice.
     *
     * @param c a int representing the user's choice.
     */
    public void setChoice(int c) {
        this.choice = c;
    }

    /**
     *  Method to get the user's choice.
     *
     * @return a int representing the user's choice.
     */
    public int getChoice() {
        return this.choice;
    }

    /**
     *  Method to clear the lists bars and trips.
     */
    private void clearList() {
        this.bars = new ArrayList<Place>();
        this.trips = new ArrayList<Place>();
    }

    /**
     *  Method to generate the lists via the search algorithm.
     */
    public void generate() {
        //to implement
        this.clearList();
        if (this.preferences.getTrip()) {
            StrategyTrip st = new StrategyTrip();
            this.trips = st.solve(this.position, this.preferences.getCaracteristics().get(0)); //ERROR
        } else if (!this.preferences.getTrip()) {
            StrategyBars sb = new StrategyBars();
            this.bars = sb.solve(this.position, this.preferences.getCaracteristics().get(0)); //ERROR
        }
    }

    /**
     *  Method to show the lists.
     */
    public void show() {
        if (this.preferences.getTrip()) {
            System.out.println(this.trips);
        } else if (!this.preferences.getTrip()) {
            System.out.println(this.bars);
        }
    }

    /**
     *  Method to choose the caracteristic.
     *
     * @return a int representing the user's choice.
     */
    public int chooseCaracterictics() {
        Console console = System.console();

        String msg = String.format("Choose Caracteristic [0-%01d]", this.preferences.getNbCaracteristic());
        System.out.println(msg);
        int input = Integer.parseInt(console.readLine());
        //TO REMOVE
        this.choice = input;
        return input;
    }

    /**
     *  Method to find the corresponding user in the db.
     *
     * @param users a list of user representing all the users of the db.
     * @param pseudo a string representing the user's pseudo.
     * @return null
     */
	public static User findUser(ArrayList<User> users, String pseudo) {
		for (User u: users) {
			if (u.getPseudo().equals(pseudo)) {
				return u;
			}
		}

		return null;
	}
}
