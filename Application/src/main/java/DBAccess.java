// This class is used to connect the database (neo4j) with the application Barathon

// imports
import org.neo4j.driver.v1.*;
import static java.lang.Math.*;
import java.util.*;


public final class DBAccess {
  private static String ip = "localhost:7687";
  private static String login = "neo4j";
  private static String password = "NEO4J";


  public static Driver connect() {
    return GraphDatabase.driver(String.format("bolt://%s", ip), AuthTokens.basic(login, password));
  }


  public static void createUniqueConstraints() {
    /*
    This function creates the unique constraints on the following nodes:
    - Place: id;
    - User: pseudo;
    - Caracteristic: name.
    */

    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run("CREATE CONSTRAINT ON (place:Place) ASSERT place.id IS UNIQUE");
    }
    catch(Exception e) {
      System.out.println("An error occured during the unique id constraint creation!");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run("CREATE CONSTRAINT ON (user:User) ASSERT user.pseudo IS UNIQUE");
    }
    catch(Exception e) {
      System.out.println("An error occured during the unique pseudo constraint creation!");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run("CREATE CONSTRAINT ON (carac:Caracteristic) ASSERT carac.name IS UNIQUE");
    }
    catch(Exception e) {
      System.out.println("An error occured during the unique name constraint creation!");
    }
    driver.close();
	}


  public static void createPlace(Place place) {
    /*
    This function takes a parameter of type Place and creates a node of this type in the graph.
    The parameters are:
    - id (unique);
    - name;
    - position (longitude, latitude).
    */

    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("CREATE (:Place {id: %d, name: '%s', position: '%d, %d'})", place.getId(), place.getName(), place.getAddress().getPosition().getLongitude(), place.getAddress().getPosition().getLatitude()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the place creation !");
    }
    driver.close();
	}


  public static void matchPlace(Place place) {
    /*
    This function takes a parameter of type Place and searches a node of this type in the graph.
    If no node is found, it will be created.
    */

    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d}) RETURN p", place.getId()));
      if (rs != null) { }
      else {
        createPlace(place);
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the place matching !");
    }
    driver.close();
	}


  public static ArrayList<Place> findPlaces() {
    /*
    This function searches all places in the graph.
    */

    ArrayList<Place> places= new ArrayList<Place>();
    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run("MATCH (p:Place) RETURN p.name AS name");
      if (rs != null) {
        while (rs.hasNext()) {
          Record record = rs.next();
          places.add(record.get("name"));
        }
        return places;
      }
      else {
        System.out.println("There is no place in the database !");
        return places;
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the places searching !");
      return places;
    }
    driver.close();
	}


  public static void createUser(User user) {
    /*
    This function takes a parameter of type User and creates a node of this type in the graph.
    The parameters are:
    - pseudo (unique);
    - position (longitude, latitude).
    */

    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("CREATE (:User {pseudo: '%s', position: '%d, %d'})", user.getPseudo(), user.getPosition().getLongitude(), user.getPosition().getLatitude()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the user creation !");
    }
    driver.close();
	}


  public static void matchUser(User user) {
    /*
    This function takes a parameter of type User and searches a node of this type in the graph.
    If no node is found, it will be created.
    */

    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'}) RETURN u", user.getPseudo()));
      if (rs != null) {
        rs = session.run(String.format("SET u.position='%d, %d'", user.getPosition().getLongitude(), user.getPosition().getLatitude()));
      }
      else {
        createUser(user);
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the user matching !");
    }
    driver.close();
	}


  public static void createCaracteristics() {
    /*
    This function creates one node for each caracteristics (cheap, music, famousPlace, food, vegetarian, halal, vegan, alcohol).
    */

    List<String> fields = new ArrayList<String>();
    fields.add("cheap");
    fields.add("music");
    fields.add("famousPlace");
    fields.add("food");
    fields.add("vegetarian");
    fields.add("halal");
    fields.add("vegan");
    fields.add("alcohol");

    for (String field : fields) {
      Driver driver = connect();
      try (Session session = driver.session()) {
        StatementResult rs = session.run(String.format("CREATE (:Caracteristic {name: '%s'})", field));
      }
      catch(Exception e) {
        System.out.println("An error occured during the caracteristics creation !");
      }
      driver.close();
    }
	}


  public static void createP2CRelationship(Place place, Caracteristics carac) {
    /*
    This function creates a relationship between a place and the caracteristics.
    */

    /*
    for (String field : fields) {
      Driver driver = connect();
      try (Session session = driver.session()) {
        StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", field));
        rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getCheap())); //how to get the field value ?
      }
      catch(Exception e) {
        System.out.println("An error occured during the relationship creation !");
      }
      driver.close();
    }
    */

    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "cheap"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getCheap()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "cheap"));
        rs = session.run("CREATE (p) -[r:FOLLOWS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getCheap()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the cheap relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "music"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getMusic()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "music"));
        rs = session.run("CREATE (p) -[r:FOLLOWS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getMusic()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the music relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "famousPlace"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getFamousPlace()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "famousPlace"));
        rs = session.run("CREATE (p) -[r:IS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getFamousPlace()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the famous place relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "food"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getFood()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "food"));
        rs = session.run("CREATE (p) -[r:FOLLOWS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getFood()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the food relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "vegetarian"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getVegetarian()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegetarian"));
        rs = session.run("CREATE (p) -[r:FOLLOWS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getVegetarian()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the vegetarian relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "halal"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getHalal()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "halal"));
        rs = session.run("CREATE (p) -[r:FOLLOWS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getHalal()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the halal relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "vegan"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getVegan()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegan"));
        rs = session.run("CREATE (p) -[r:FOLLOWS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getVegan()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the vegan relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", place.getId(), "alcohol"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getAlcohol()));
      }
      else {
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "alcohol"));
        rs = session.run("CREATE (p) -[r:FOLLOWS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getAlcohol()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the alcohol relationship creation !");
    }
    driver.close();
	}


  public static void createU2CRelationship(User user, Caracteristics carac) {
    /*
    This function creates a relationship between a place and the caracteristics.
    */

    /*
    for (String field : fields) {
      Driver driver = connect();
      try (Session session = driver.session()) {
        StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", field));
        rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getCheap())); //how to get the field value ?
      }
      catch(Exception e) {
        System.out.println("An error occured during the relationship creation !");
      }
      driver.close();
    }
    */

    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "cheap"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getCheap()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "cheap"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getCheap()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the cheap relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "music"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getMusic()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "music"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getMusic()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the music relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "famousPlace"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getFamousPlace()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "famousPlace"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getFamousPlace()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the famous place relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "food"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getFood()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "food"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getFood()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the food relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "vegetarian"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getVegetarian()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegetarian"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getVegetarian()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the vegetarian relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "halal"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getHalal()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "halal"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getHalal()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the halal relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "vegan"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getVegan()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegan"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getVegan()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the vegan relationship creation !");
    }
    driver.close();

    driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(c:Caracteristic {name: '%s'} RETURN r)", user.getPseudo(), "alcohol"));
      if (rs != null) {
        rs = session.run(String.format("SET r.status=%b", carac.getAlcohol()));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "alcohol"));
        rs = session.run("CREATE (u) -[r:WANTS]-> (c)");
        rs = session.run(String.format("SET r.status=%b", carac.getAlcohol()));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the alcohol relationship creation !");
    }
    driver.close();
	}


  public static void createP2PRelationship(Place place1, Place place2) {
    /*
    This function creates a relationship AWAY between two places. This relationship contains one property, the distance.
    */

    double distance = 111.03 * Math.sqrt(Math.pow(place1.getAddress().getPosition().getLongitude() - place2.getAddress().getPosition().getLongitude(), 2) + Math.pow(place1.getAddress().getPosition().getLatitude() - place2.getAddress().getPosition().getLatitude(), 2));
    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p1:Place {id: %d})-[r]-(p2:Place {id: %d} RETURN r)", place1.getId(), place2.getId()));
      if (rs != null) {
        rs = session.run(String.format("SET r.distance=%d", distance));
      }
      else {
        rs = session.run(String.format("MATCH (p1:Place {id: %d})", place1.getId()));
        rs = session.run(String.format("MATCH (p2:Place {id: %d})", place2.getId()));
        rs = session.run("CREATE (p1) -[r:AWAY]-> (p2)");
        rs = session.run(String.format("SET r.distance=%d", distance));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the Place-Place relationship creation !");
    }
    driver.close();
	}


  public static void createU2PRelationship(User user, Place place) {
    /*
    This function creates a relationship AWAY between two places. This relationship contains one property, the distance.
    */

    double distance = Math.sqrt(Math.pow(user.getPosition().getLongitude() - place.getAddress().getPosition().getLongitude(), 2) + Math.pow(user.getPosition().getLatitude() - place.getAddress().getPosition().getLatitude(), 2));
    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})-[r]-(p:Place {id: %d} RETURN r)", user.getPseudo(), place.getId()));
      if (rs != null) {
        rs = session.run(String.format("SET r.distance=%d", distance));
      }
      else {
        rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
        rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
        rs = session.run("CREATE (u) -[r:AWAY]-> (p)");
        rs = session.run(String.format("SET r.distance=%d", distance));
      }
    }
    catch(Exception e) {
      System.out.println("An error occured during the User-Place relationship creation !");
    }
    driver.close();
  }


  public static void dropDatabase() {
    Driver driver = connect();
    try (Session session = driver.session()) {
      StatementResult rs = session.run("MATCH (n) DETACH DELETE n");
    }
    catch(Exception e) {
      System.out.println("An error occured during the databse erasing");
    }
    driver.close();
  }
}
