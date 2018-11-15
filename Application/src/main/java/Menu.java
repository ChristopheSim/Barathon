import java.util.*;

public class Menu {

	private ArrayList<Food> foods;
	private ArrayList<Drink> drinks;
	private int meanDrinkPrice;
	private int meanFoodPrice;

	public Menu () {

		this.foods = new ArrayList<Food> ();
		this.drinks = new ArrayList<Drink> ();

	}

	public void addFood (Food f) {
		this.foods.add(f);
	}

	public void removeFood (Food f) {
		this.foods.remove(f);
	}

	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	public void addDrink (Drink d) {
		this.drinks.add(d);
	}

	public void removeDrink (Drink d) {
		this.drinks.remove(d);
	}

	public ArrayList<Drink> getDrinks() {
		return this.drinkss;
	}

	public void setMeanFoodPrice() {
		this.meanFoodPrice = computeMeanPrice(this.foods);
	}

	public int getMeanFoodPrice() {
		return this.meanFoodPrice;
	}

	public void setMeanDrinkPrice() {
		this.meanDrinkPrice = computeMeanPrice(this.drink);
	}
	public int getMeanDrinkPrice() {
		return this.meanDrinkPrice;
	}

	// Compute the mean price of a list of components - drinks or foods
	private int compiteMeanPrice (ArrayList<Component> components) {
		int sum = 0;

		// Adds the price of each element in the list
		foreach (Component c in components) {
			sum += c.getPrice();
		}
		return sum/components.size();
	}
}
