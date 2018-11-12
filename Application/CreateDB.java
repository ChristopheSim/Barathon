public final class CreateDB {
  public static void createBaseDB() {
    // Create the constraints of the graph
    DBAccess.createUniqueConstraints();

    // Create the caracteristics in the graph
    DBAccess.createCaracteristics();

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
    Place p11 = new Place();
    Place p12 = new Place();
    Place p13 = new Place();
    Place p14 = new Place();
    Place p15 = new Place();
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
    places.add(p11);
    places.add(p12);
    places.add(p13);
    places.add(p14);
    places.add(p15);

    // Create some users in the graph
    List<User> users = new ArrayList<User>();
    User u1 = new User();
    User u2 = new User();
    User u3 = new User();
    users.add(u1);
    users.add(u2);
    users.add(u3);
  }
}
