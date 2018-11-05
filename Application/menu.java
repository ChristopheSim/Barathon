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
}
