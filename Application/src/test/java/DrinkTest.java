import org.junit.*

public class DrinkTest {

	@Test
	public void TestGetSoft() {		

		assertFalse((new Drink("Drink", 10, 9.7, false)).getSoft());
		assertFalse((new Drink("Drink", 10, 9.7, true)).getSoft());
		assertFalse((new Drink("Drink", 8.5, 40, false)).getSoft());
		assertFalse((new Drink("Drink", 8.5, 40, true)).getSoft());
		assertFalse((new Drink("Drink", 10, 121.3789, false)).getSoft());
		assertFalse((new Drink("Drink", 10, 121.3789, true)).getSoft());
		assertTrue((new Drink("Drink", 0, 0, false)).getSoft());
		assertTrue((new Drink("Drink", 0, 0, true)).getSoft());
		assertTrue((new Drink("Drink", 10, -5, false)).getSoft());
		assertTrue((new Drink("Drink", 10, -5, true)).getSoft());

	}
}
