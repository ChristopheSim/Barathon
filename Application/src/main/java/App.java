import java.io.Console;

/**
 *  Class to have an inteface between the application and the user.
 */
public class App {

    /**
     *  Method main.
     */
    public static void main(String [] args) {
        Console c = System.console();
        String intro = "\n======================= \n| Welcome to Barathon |\n======================= \n";
        System.out.println(intro);

        System.out.print("  user pseudo : ");
        String pseudo = c.readLine();
        System.out.println(String.format("  Hello %s !\n", pseudo));

        System.out.print("  ! Can we use your actual position ? [Y/n] :");
        boolean bpos = "Yy ".indexOf(c.readLine()) >= 0;
        Double x = 0.0;
        Double y = 0.0;
        if (bpos) {
            System.out.print("  Position (x) : ");
            x = new Double(c.readLine());
            System.out.print("  Position (y) : ");
            y = new Double(c.readLine());
        } else {
            x = 666.0;
            y = 666.0;
        }
        System.out.println(String.format("\n  Your position : %f %f \n", x, y));
        Position pos = new Position(x, y);

        System.out.println("\n --- Choose Preferencies --- \n");
        System.out.print("  - Cheap [Y/n]: ");
        //String cheap = c.readLine();
        boolean cheap = "Yy ".indexOf(c.readLine()) >= 0;
        System.out.print("  - Music [Y/n]: ");
        //String music = c.readLine();
        boolean music = "Yy ".indexOf(c.readLine()) >= 0;
        System.out.print("  - Alcohol [Y/n]: ");
        //String alcohol = c.readLine();
        boolean alcohol = "Yy ".indexOf(c.readLine()) >= 0;

        System.out.println(String.format("\n  You choosed : %s %s %s \n",
         cheap, music, alcohol));
        Caracteristics car = new Caracteristics();
        car.setCheap(cheap);
        car.setMusic(music);
        car.setAlcohol(alcohol);

        System.out.println("\n --- Choose Type of Search --- \n");
        System.out.print("  - Trip [Y/n]: ");
        //String trip = c.readLine();
        boolean trip = "Yy ".indexOf(c.readLine()) >= 0;
        System.out.print("  - Radius: ");
        //String trip = c.readLine();
        int radius = Integer.parseInt(c.readLine());

        System.out.println(String.format("\n  You choosed : %s %d\n",
         trip, radius));
        Preferences pref = new Preferences();
        pref.addCaracteristics(car);
        pref.setTrip(trip);
        pref.setRadius(radius);

        // Create user
        User user = new User(pseudo, pos, pref);

        //TODO: run Search
        user.generate();

        //TODO: show result
        user.show();
    }
}
