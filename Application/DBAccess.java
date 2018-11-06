// This class is used to connect the database (neo4j) with the application Barathon


public class DBAccess {
  public void open() {
	Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "NEO4J"));
  }

  public void close() {
	try (Session session = driver.session()) {
		driver.close();
	}
  }

  public void create(Place place) {
	try (Session session = driver.session()) {
    		StatementResult rs = session.run("CREATE (" + place + ") RETURN " + place);
	}
  }

  public void update(Place place) {
  }

  public void delete(Place place) {
  }
}
