import java.util.*;

public class Menu {

	private ArrayList<Food> foods;
	private ArrayList<Drink> drinks;
	private int meanDrinkPrice;
	private int meanFoodPrice;
	private boolean meanDrinkPriceUTD;
	private boolean meanFoodPriceUTD;

	public Menu () {

		this.foods = new ArrayList<Food> ();
		this.drinks = new ArrayList<Drink> ();
		this.meanDrinkPriceUTD = false;
		this.meanFoodPriceUTD = false;

	}

	public void AddFood (Food f) {
		this.foods.add(f);
		this.meanFoodPriceUTD = false;
	}

	public void RemoveFood (Food f) {
		this.foods.remove(f);
		this.meanFoodPriceUTD = false;
	}

	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	public void AddDrink (Drink d) {
		this.drinks.add(d);
		this.meanDrinkPriceUTD = false;
	}

	public void RemoveDrink (Drink d) {
		this.drinks.remove(d);
		this.meanDrinkPriceUTD = false;
	}

	public ArrayList<Drink> getDrinks() {
		return this.drinkss;
	}

	// Compute the mean price of a list of components - drinks or foods
	private int MeanComponentPrice (HashSet<? extends Component> components) {
		int sum = 0;

		// Adds the price of each element in the list
		for (Iterator<? extends Component> c = components.iterator(); c.hasNext();) {
			sum += c.next().GetPrice();
		}

		return sum/components.size();
	}

	// Compute the mean price
	private int MeanFoodPrice () {
		this.meanFoodPrice = MeanComponentPrice(foods);
		this.meanFoodPriceUTD = true;
		return this.meanFoodPrice;
	}

	// Compute the mean price
	private int MeanDrinkPrice () {
		this.meanDrinkPrice = MeanComponentPrice(drinks);
		this.meanDrinkPriceUTD = true;
		return this.meanDrinkPrice;
	}

	// Get the mean price of foods - Do not compute it if up-to-date
	public int GetMeanFoodPrice () {
		if (this.meanFoodPriceUTD) {
			return this.meanFoodPrice;
		}
		else {
			return this.MeanFoodPrice();
		}
	}

	// Get the mean price of drinks - Do not compute it if up-to-date
	public int GetMeanDrinkPrice () {
		if (this.meanDrinkPriceUTD) {
			return this.meanDrinkPrice;
		}
		else {
			return this.MeanDrinkPrice();
		}
	}
}
