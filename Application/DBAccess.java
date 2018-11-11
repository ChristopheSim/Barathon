// This class is used to connect the database (neo4j) with the application Barathon

// imports
import org.neo4j.driver.v1.*;
import static java.lang.Math.*;
import java.util.*;


public final class DBAccess {
  public static void createUniqueConstraints() {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run("CREATE CONSTRAINT ON (place:Place) ASSERT place.id IS UNIQUE");
    }
    catch(Exception e) {
      System.out.println("An error occured during the unique id constraint creation!");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run("CREATE CONSTRAINT ON (user:User) ASSERT user.pseudo IS UNIQUE");
    }
    catch(Exception e) {
      System.out.println("An error occured during the unique pseudo constraint creation!");
    }
    driver.close();
	}


  public static void createPlace(Place place) {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("CREATE (:Place {id: %d, name: '%s', position: '%d, %d'})", place.getId(), place.getName(), place.getAddress().getPosition().getLongitude(), place.getAddress().getPosition().getLatitude()));
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
      Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
      try (Session session = driver.session()) {
        StatementResult rs = session.run(String.format("CREATE (:Caracteristic {name: '%s'})", field));
      }
      catch(Exception e) {
        System.out.println("An error occured during the labels creation !");
      }
      driver.close();
    }
	}


  public static void createP2CRelationship(Place place, Caracteristics carac) {
    /*
    for (String field : fields) {
      Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
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

    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "cheap"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getCheap()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "music"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getMusic()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "famousPlace"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getFamousPlace()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "food"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getFood()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegetarian"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getVegetarian()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "halal"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getHalal()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegan"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getVegan()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p:Place {id: %d})", place.getId()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "alcohol"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getAlcohol()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();
	}


  public static void createU2CRelationship(User user, Caracteristics carac) {
    /*
    for (String field : fields) {
      Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
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

    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "cheap"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getCheap()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "music"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getMusic()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "famousPlace"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getFamousPlace()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "food"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getFood()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegetarian"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getVegetarian()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "halal"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getHalal()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "vegan"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getVegan()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();

    driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (u:User {pseudo: '%s'})", user.getPseudo()));
      rs = session.run(String.format("MATCH (c:Caracteristic {name: '%s'})", "alcohol"));
      rs = session.run(String.format("CREATE (p) -[r:%s]-> (c)", carac.getAlcohol()));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();
	}


  public static void createP2PRelationship(Place place1, Place place2) {
    double distance = Math.sqrt(Math.pow(place1.getLongitude() - place2.getLongitude(), 2) + Math.pow(place1.getLatitude() - place2.getLatitude(), 2));
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("MATCH (p1:Place {id: %s})", place1.getId()));
      rs = session.run(String.format("MATCH (p2:Place {id: %s})", place2.getId()));
      rs = session.run("CREATE (p1) -[r:AWAY]-> (p2)");
      rs = session.run(String.format("SET r.distance=%d", distance));
    }
    catch(Exception e) {
      System.out.println("An error occured during the relationship creation !");
    }
    driver.close();
	}
}
