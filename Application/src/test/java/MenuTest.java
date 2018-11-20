import org.junit.*

public class DrinkTest {

	@Before
	public void InitClasses() {
		
		Drink d1 = new Drink("Drink", 100, 0, false);
		Drink d2 = new Drink("Drink", 200, 0, false);
		Drink d3 = new Drink("Drink", 300, 0, false);
		Drink d4 = new Drink("Drink", 400, 0, false);

		Food f1 = new Food("Food", 100, false, false, false);
		Food f2 = new Food("Food", 200, false, false, false);
		Food f3 = new Food("Food", 300, false, false, false);
		Food f4 = new Food("Food", 400, false, false, false);
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
		
		assertEquals(0, m.getMeanDrinkPrice());
		m.addDrink(d1);
		assertEquals(100, m.getMeanDrinkPrice());
		m.addDrink(d2);
		assertEquals(150, m.getMeanDrinkPrice());
		m.addDrink(d3);
		assertEquals(200, m.getMeanDrinkPrice());
		m.addDrink(d4);
		assertEquals(250, m.getMeanDrinkPrice());
		m.removeDrink(d4);
		assertEquals(200, m.getMeanDrinkPrice());
	}
	
	@Test
	public void TestGetMeanFoodPrice() {		
		Menu m = new Menu();

		assertEquals(0, m.getMeanFoodPrice());
		m.addFood(f1);
		assertEquals(100, m.getMeanFoodPrice());
		m.addFood(f2);
		assertEquals(150, m.getMeanFoodPrice());
		m.addFood(f3);
		assertEquals(200, m.getMeanFoodPrice());
		m.addFood(f4);
		assertEquals(250, m.getMeanFoodPrice());
		m.removeFood(f4);
		assertEquals(200, m.getMeanFoodPrice());
	}
}
