import org.junit.*

public class DrinkTest {

	@Before
	public void InitClasses() {
		
		Drink d1 = new Drink("Drink", 1.0, 0, false);
		Drink d2 = new Drink("Drink", 2.0, 0, false);
		Drink d3 = new Drink("Drink", 3.0, 0, false);
		Drink d4 = new Drink("Drink", 4.0, 0, false);

		Food f1 = new Food("Food", 1.0, false, false, false);
		Food f2 = new Food("Food", 2.0, false, false, false);
		Food f3 = new Food("Food", 3.0, false, false, false);
		Food f4 = new Food("Food", 4.0, false, false, false);
	}

	@Test
	public void TestAddDrink() {
		Menu m = new Menu();

		assertEquals(0, m.getDrinks().size);
		m.addDrink(d1);
		assertEquals(1, m.getDrinks().size);
		m.addDrink(d1);
		assertEquals(1, m.getDrinks().size);
		m.addDrink(d2);
		assertEquals(2, m.getDrinks().size);
	}

	@Test
	public void TestRemoveDrink() {		
		Menu m = new Menu();

		m.addDrink(d1);
		m.addDrink(d2);

		assertEquals(2, m.getDrinks().size);
		m.removeDrink(d1);
		assertEquals(1, m.getDrinks().size);
		m.removeDrink(d1);
		assertEquals(1, m.getDrinks().size);
		m.removeDrink(d2);
		assertEquals(0, m.getDrinks().size);
	}
	
	@Test
	public void TestAddFood() {		
		Menu m = new Menu();

		assertEquals(0, m.getFoods().size);
		m.addFood(f1);
		assertEquals(1, m.getFoods().size);
		m.addFood(f1);
		assertEquals(1, m.getFoods().size);
		m.addFood(f2);
		assertEquals(2, m.getFoods().size);
	}
	
	@Test
	public void TestRemoveFood() {		
		Menu m = new Menu();

		m.addFood(f1);
		m.addFood(f2);

		assertEquals(2, m.getFoods().size);
		m.removeFood(f1);
		assertEquals(1, m.getFoods().size);
		m.removeFood(f1);
		assertEquals(1, m.getFoods().size);
		m.removeFood(f2);
		assertEquals(0, m.getFoods().size);
	}
	
	@Test
	public void TestGetMeanDrinkPrice() {		
		Menu m = new Menu();
		
		assertEquals(0.00, m.getMeanDrinkPrice(), 2);
		m.addDrink(d1);
		assertEquals(1.00, m.getMeanDrinkPrice(), 2);
		m.addDrink(d2);
		assertEquals(1.50, m.getMeanDrinkPrice(), 2);
		m.addDrink(d3);
		assertEquals(2.00, m.getMeanDrinkPrice(), 2);
		m.addDrink(d4);
		assertEquals(2.50, m.getMeanDrinkPrice(), 2);
		m.removeDrink(d4);
		assertEquals(2.00, m.getMeanDrinkPrice(), 2);
	}
	
	@Test
	public void TestGetMeanFoodPrice() {		
		Menu m = new Menu();

		assertEquals(0.00, m.getMeanFoodPrice(), 2);
		m.addFood(f1);
		assertEquals(1.00, m.getMeanFoodPrice(), 2);
		m.addFood(f2);
		assertEquals(1.50, m.getMeanFoodPrice(), 2);
		m.addFood(f3);
		assertEquals(2.00, m.getMeanFoodPrice(), 2);
		m.addFood(f4);
		assertEquals(2.50, m.getMeanFoodPrice(), 2);
		m.removeFood(f4);
		assertEquals(2.00, m.getMeanFoodPrice(), 2);
	}
}
