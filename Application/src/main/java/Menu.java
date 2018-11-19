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
		this.setMeanFoodPrice();
	}

	public void removeFood (Food f) {
		this.foods.remove(f);
		this.setMeanFoodPrice();
	}

	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	public void addDrink (Drink d) {
		this.drinks.add(d);
		this.setMeanDrinkPrice();
	}

	public void removeDrink (Drink d) {
		this.drinks.remove(d);
		this.setMeanDrinkPrice();
	}

	public ArrayList<Drink> getDrinks() {
		return this.drinks;
	}

	public void setMeanFoodPrice() {
		int sum = 0;

		// Adds the price of each element in the list
		for (Food f : this.foods) {
			sum += f.getPrice();
		}

		this.meanFoodPrice = sum/this.foods.size();
	}

	public int getMeanFoodPrice() {
		return this.meanFoodPrice;
	}

	public void setMeanDrinkPrice() {
		int sum = 0;

		// Adds the price of each element in the list
		for (Drink d : this.drinks) {
			sum += d.getPrice();
		}

		this.meanDrinkPrice = sum/this.drinks.size();;
	}

	public int getMeanDrinkPrice() {
		return this.meanDrinkPrice;
	}

	/* Compute the mean price of a list of components - drinks or foods
	private int computeMeanPrice (ArrayList<Component> components) {
		int sum = 0;

		// Adds the price of each element in the list
		for (Component c : components) {
			sum += c.getPrice();
		}
		return sum/components.size();
	}*/
}
