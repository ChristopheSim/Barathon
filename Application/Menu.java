import java.util.HashSet;

public class Menu {

	private HashSet foods;
	private HashSet drinks;

	public Menu () {

		this.foods = new HashSet ();
		this.drinks = new HashSet ();

	}

	public void AddFood (Food f) {
		foods.add(f);
	}

	public void RemoveFood (Food f) {
		food.remove(f);
	}

	public void AddDrink (Drink d) {
		drinks.add(d);
	}

	public void RemoveDrink (Drink d) {
		drinks.remove(d);
	}

	private int MeanComponentPrice (HashSet components) {
		int sum = 0;
		
		// Adds the price of each element in the list
		for (Component c : components ) {
			sum += c.GetPrice();
		}

		return sum/components.size();
	}

	public int MeanFoodPrice () {
		return MeanComponentPrice(foods);	
	}

	public int MeanDrinkPrice () {
		return MeanComponentPrice(drinks);	
	}
}
