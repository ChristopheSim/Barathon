import java.util.LinkedList;

public class Preferences {
    private LinkedList<Caracteristics> caracteristics;
    private int nbBar;
    private int radius; // En m
    private boolean trip;

    // TODO: add trip variable

    Preferences() {
        caracteristics = new LinkedList<Caracteristics>();
        this.nbBar = 1;
        this.radius = 1000;
    }

    public void AddCaracteristics(Caracteristics caracteristics) {
        this.caracteristics.add(caracteristics);
    }

    public int getNbBar() {
        return this.nbBar;
    }

    public void setNbBar(int nbBar) {
        if (nbBar > 0) {
            this.nbBar = nbBar;
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

    public int getNbCaracteristic() {
        return this.caracteristics.size();
    }
}
