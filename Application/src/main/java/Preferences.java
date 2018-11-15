import java.util.*;

public class Preferences {
    private ArrayList<Caracteristics> caracteristics;
    private int radius;
    private boolean trip;

    Preferences() {
        this.caracteristics = new ArrayList<Caracteristics>();
        this.radius = 1000;
        this.trip = false;
    }

    public Caracteristics getCaracteristics() {
      return this.caracteristics;
    }

    public int getNbCaracteristic() {
        return this.caracteristics.size();
    }

    public void addCaracteristics(Caracteristics caracteristics) {
        this.caracteristics.add(caracteristics);
    }

    public void removeCaracteristics(Caracteristics caracteristics) {
      if (this.caracteristics.contains(caracteristics)) {
        this.caracteristics.remove(caracteristics);
      } else {
        System.out.println("Caracteristics not deleted (not found)");
      }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    public boolean getTrip() {
        return this.trip;
    }

    public void setTrip(boolean trip) {
        this.trip = trip;
    }
}
