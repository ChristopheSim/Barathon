public final class CreateDB {
  public static void db() {
    // Create the constraints of the graph
    DBAccess.createUniqueConstraints();

    // Create the caracteristics in the graph
    DBAccess.createCaracteristics();

    // Create the sample of drinks
    Drink coca = new Drink();
    Drink duvel = new Drink();

    // Create the sample of food
    Food salad = new Food();
    Food wafel = new Food();

    // Create the menus
    Menu menu1 = new Menu();
    Menu menu2 = new Menu();
    Menu menu3 = new Menu();

    // Create the caracteristics
    Caracteristics carac1 = new Caracteristics();
    Caracteristics carac2 = new Caracteristics();
    Caracteristics carac3 = new Caracteristics();

    // Create the preferences
    Preferences pref1 = new Preferences();
    Preferences pref2 = new Preferences();

    //Create the positions
    Position posp1 = new Position();
    Position posp2 = new Position();
    Position posp3 = new Position();
    Position posp4 = new Position();
    Position posp5 = new Position();
    Position posp6 = new Position();
    Position posp7 = new Position();
    Position posp8 = new Position();
    Position posp9 = new Position();
    Position posp10 = new Position();

    Position posu1 = new Position();
    Position posu2 = new Position();

    // Create the addresses
    Address addp1 = new Address();
    Address addp2 = new Address();
    Address addp3 = new Address();
    Address addp4 = new Address();
    Address addp5 = new Address();
    Address addp6 = new Address();
    Address addp7 = new Address();
    Address addp8 = new Address();
    Address addp9 = new Address();
    Address addp10 = new Address();

    // Create some places in the graph
    List<Place> places = new ArrayList<Place>();
    Place p1 = new Place();
    Place p2 = new Place();
    Place p3 = new Place();
    Place p4 = new Place();
    Place p5 = new Place();
    Place p6 = new Place();
    Place p7 = new Place();
    Place p8 = new Place();
    Place p9 = new Place();
    Place p10 = new Place();
    places.add(p1);
    places.add(p2);
    places.add(p3);
    places.add(p4);
    places.add(p5);
    places.add(p6);
    places.add(p7);
    places.add(p8);
    places.add(p9);
    places.add(p10);

    // Create some users in the graph
    List<User> users = new ArrayList<User>();
    User u1 = new User();
    User u2 = new User();
    users.add(u1);
    users.add(u2);
  }
}
