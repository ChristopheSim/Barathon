// This class is used to connect the database (neo4j) with the application Barathon

// imports
import org.neo4j.driver.v1.*;


public final class DBAccess {
  public static void createPlace(Place place) {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      // To complete with all the properties of a node place
      StatementResult rs = session.run(String.format("CREATE (:Place {name: '%s'})", place.getName()));
    }
    catch(Exception e) {
      System.out.println("An error occured !");
    }
    driver.close();
	}
}
