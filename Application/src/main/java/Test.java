import org.neo4j.driver.v1.*;

public final class Test {
  public static void create(String node) {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run(String.format("CREATE (:Place {name: '%s'})", node));
    }
    catch(Exception e) {
      System.out.println("An error occured !");
    }
	  driver.close();
  }
}
