import org.junit.*;

public class ComponentTest {

	@Test
	public void TestIsEqual() {

		assertTrue((new Drink("Drink", 10, 5.2, true)).isEqual((new Drink("Drink", 10, 5.2, true))));
		assertFalse((new Drink("Drink", 10, 5.2, true)).isEqual((new Drink("Beer", 10, 5.2, true))));
		assertFalse((new Drink("Drink", 10, 5.2, true)).isEqual((new Drink("Drink", 8, 5.2, true))));
		assertFalse((new Drink("Drink", 10, 5.2, true)).isEqual((new Drink("Drink", 10, 0.1, true))));
		assertFalse((new Drink("Drink", 10, 5.2, true)).isEqual((new Drink("Drink", 10, 5.2, false))));

		assertFalse((new Drink("Drink", 10, 5.2, true)).isEqual((new Food("Food", 10, true, true, true))));

		assertTrue((new Food("Food", 10, true, true, true)).isEqual((new Food("Food", 10, true, true, true))));
		assertFalse((new Food("Food", 10, true, true, true)).isEqual((new Food("Hamburger", 10, true, true, true))));
		assertFalse((new Food("Food", 10, true, true, true)).isEqual((new Food("Food", 12, true, true, true))));
		assertFalse((new Food("Food", 10, true, true, true)).isEqual((new Food("Food", 10, false, true, true))));
		assertFalse((new Food("Food", 10, true, true, true)).isEqual((new Food("Food", 10, true, false, true))));
		assertFalse((new Food("Food", 10, true, true, true)).isEqual((new Food("Food", 10, true, true, false))));
	}
}
