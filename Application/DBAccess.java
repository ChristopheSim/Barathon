// This class is used to connect the database (neo4j) with the application Barathon

// imports
import org.neo4j.driver.v1.*;


public final class DBAccess {
  public static void createUniquePseudoConstraint() {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run("CREATE CONSTRAINT ON (place:Place ASSERT book.pseudo IS UNIQUE");
    }
    catch(Exception e) {
      System.out.println("An error occured during the unique pseudo constraint creation!");
    }
    driver.close();
	}


  public static void createPlace(Place place) {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("CREATE (:Place {id: '%d', name: '%s', position: '%d, %d'})", place.getId(), place.getName(), place.getAddress().getPosition().getLongitude(), place.getAddress().getPosition().getLatitude()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the place creation !");
    }
    driver.close();
	}


  public static void createUser(User user) {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("CREATE (:User {pseudo: '%s', position: '%d, %d'})", user.getPseudo(), user.getPosition().getLongitude(), user.getPosition().getLatitude()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the user creation !");
    }
    driver.close();
	}


  public static void createCaracteristics() {
    List fields = new ArrayList();
    fields.add("cheap");
    fields.add("music");
    fields.add("famousPlace");
    fields.add("food");
    fields.add("vegetarian");
    fields.add("halal");
    fields.add("vegan");
    fields.add("alcohol");

    for (String field : fields) {
      Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
      try (Session session = driver.session()) {
        StatementResult rs = session.run(String.format("CREATE (:Caracteristic {name: '%s')", field));
      }
      catch(Exception e) {
        System.out.println("An error occured during the labels creation !");
      }
      driver.close();
    }
	}


// To complete to use with Activity, Place and User, type of relation !!!
  public static void createRelation(Place place1) {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      // To complete with all the properties of a node place
      StatementResult rs = session.run(String.format("CREATE (:Place {name: '%s'})", place.getName()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relation creation !");
    }
    driver.close();
	}
}
