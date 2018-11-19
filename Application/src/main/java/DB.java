// imports
import org.neo4j.driver.v1.*;
import java.util.*;

public final class DB {
  public static void CreateDB() {
    // Create the constraints of the graph
    DBAccess.createUniqueConstraints();

    // Create the caracteristics in the graph
    DBAccess.createCaracteristics();

    // Create the sample of drinks
    Drink coca = new Drink("Coca regular", 200, 0.0, true);
    Drink ice_tea = new Drink("Ice tea green", 220, 0.0, false);
    Drink duvel = new Drink("Duvel", 420, 8.5, true);

    // Create the sample of food
    Food salad = new Food("Quinoa salad", 800, true, true, true);
    Food wafel = new Food("Brussels Wafel", 400, false, false, true);

    // Create the menus
    Menu menu1 = new Menu();
    menu1.addDrink(coca);
    menu1.addDrink(ice_tea);
    Menu menu2 = new Menu();
    menu2.addDrink(ice_tea);
    menu2.addDrink(duvel);
    menu2.addFood(wafel);
    Menu menu3 = new Menu();
    menu3.addDrink(coca);
    menu3.addDrink(ice_tea);
    menu3.addDrink(duvel);
    menu3.addFood(salad);
    menu3.addFood(wafel);

    // Create the caracteristics
    Caracteristics carac1 = new Caracteristics(true, false, false, false, false, false, false, false);
    Caracteristics carac2 = new Caracteristics(true, true, true, true, true, true, false, true);
    Caracteristics carac3 = new Caracteristics(false, true, true, true, true, true, true, true);

    // Create the preferences
    Preferences pref1 = new Preferences();
    pref1.addCaracteristics(carac1);
    pref1.addCaracteristics(carac2);
    pref1.setRadius(5000);
    Preferences pref2 = new Preferences();
    pref2.addCaracteristics(carac2);
    pref2.addCaracteristics(carac3);
    pref2.setTrip(true);

    //Create the positions
    Position posp1 = new Position(4.3528, 50.8468);
    Position posp2 = new Position(4.3542, 50.8468);
    Position posp3 = new Position(4.3528, 50.8405);
    Position posp4 = new Position(4.328, 50.468);
    Position posp5 = new Position(4.28, 50.8);
    Position posp6 = new Position(4.8, 49.9);
    Position posp7 = new Position(4.29, 50.8468);
    Position posp8 = new Position(4.27, 50.82);
    Position posp9 = new Position(4.362, 50.683);
    Position posp10 = new Position(4.38, 50.88);

    Position posu1 = new Position(4.3527, 50.8465);
    Position posu2 = new Position(4.3526, 50.8467);

    // Create the addresses
    Address addp1 = new Address("Chaussée de Wavre", "1789", posp1);
    Address addp2 = new Address("Chaussée de Louvain", "178B", posp2);
    Address addp3 = new Address("Rue des acacias", "26", posp3);
    Address addp4 = new Address("Chaussée de Wavre", "34", posp4);
    Address addp5 = new Address("Place Tian'Men", "14", posp5);
    Address addp6 = new Address("Clos des sapins", "45", posp6);
    Address addp7 = new Address("Avenue Thermidor", "17", posp7);
    Address addp8 = new Address("Grand place de Bruxelles", "178", posp8);
    Address addp9 = new Address("Avenue Rabelais", "19", posp9);
    Address addp10 = new Address("Chaussée de Waterloo", "265", posp10);

    // Create some places in the graph
    List<Place> places = new ArrayList<Place>();
    Place p1 = new Place(1, "La soeur du patron", addp1, menu1, carac1);
    Place p2 = new Place(2, "Café de Paris", addp2, menu2, carac2);
    Place p3 = new Place(3, "Ballodrome", addp3, menu3, carac3);
    Place p4 = new Place(4, "Brasse-temps", addp4, menu2, carac2);
    Place p5 = new Place(5, "Beer Bar", addp5, menu1, carac1);
    Place p6 = new Place(6, "Bucket's food", addp6, menu2, carac2);
    Place p7 = new Place(7, "My tannour", addp7, menu3, carac3);
    Place p8 = new Place(8, "Tutti pizza", addp8, menu2, carac2);
    Place p9 = new Place(9, "El greco", addp9, menu1, carac1);
    Place p10 = new Place(10, "Chez Fernand", addp10, menu3, carac3);
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

    for (Place place : places) {
      DBAccess.createPlace(place);
      DBAccess.createP2CRelationship(place, place.getCaracteristics());
      List<Place> db_places = DBAccess.findPlaces();
      for (Place db_place : db_places) {
        DBAccess.createP2PRelationship(place, db_place);
      }
    }

    // Create some users in the graph
    List<User> users = new ArrayList<User>();
    User u1 = new User("user1", posu1, pref1);
    User u2 = new User("user2", posu2, pref2);
    users.add(u1);
    users.add(u2);

    for (User user : users) {
      DBAccess.createUser(user);
      DBAccess.createU2CRelationship(user, user.getPreferences().getCaracteristics().get(0));
      for (Place place : places) {
        DBAccess.createU2PRelationship(user, place);
      }
    }
  }


  public static Place NearestBar(User user) {
    /*
    This function takes a parameter of type User and finds the nearest bar around him.
    */

    Driver driver = DBAccess.connect();
    try (Session session = driver.session()) {
      // To continue the query
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[AWAY]-(p:Place RETURN p)", user.getPseudo()));
      if (rs != null) {
        return rs;
      }
      else {
        System.out.println("Impossible to find the nearest bar.\nNo relationship AWAY in this graph.");
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the search of the nearest bar !");
    }
    driver.close();
  }


  public static void BarsToEat(int Y) {

  }


  public static ArrayList<Place> NearbyBars(int X, int Y) {

  }
}
