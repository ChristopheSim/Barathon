import java.util.*;

/**
*	This class represents the menu of a place
*/
public class Menu {

	private ArrayList<Food> foods;
	private ArrayList<Drink> drinks;
	private int meanDrinkPrice;
	private int meanFoodPrice;

	/**
	*	Constructor
	*
	*	The menu is empty when created
	*/
	public Menu () {

		this.foods = new ArrayList<Food> ();
		this.drinks = new ArrayList<Drink> ();

	}

	//GETTERS
	public int getMeanFoodPrice() {
		return this.meanFoodPrice;
	}

	public int getMeanDrinkPrice() {
		return this.meanDrinkPrice;
	}

	/**
	*	This method gets all the foods from the menu
	*
	* @return ArrayList<Food> Food from the menu
	*/
	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	/**
	*	This method gets all the drinks from the menu
	*
	* @return ArrayList<Drink> Drink from the menu
	*/
	public ArrayList<Drink> getDrinks() {
		return this.drinkss;
	}

	/**
	*	This method adds a food to the menu
	*
	* @param f Food to be added
	*/
	public void addFood (Food f) {
		this.foods.add(f);
		this.setMeanFoodPrice();
	}

	/**
	*	This method removes a food from the menu
	*
	* @param f Food to be removed
	*/
	public void removeFood (Food f) {
		this.foods.remove(f);
		this.setMeanFoodPrice();
	}


	/**
	*	This method adds a drink to the menu
	*
	* @param d Drink to be added
	*/
	public void addDrink (Drink d) {
		this.drinks.add(d);
		this.setMeanDrinkPrice();
	}

	/**
	*	This method removes a drink from the menu
	*
	* @param d Drink to be removed
	*/
	public void removeDrink (Drink d) {
		this.drinks.remove(d);
		this.setMeanDrinkPrice();
	}
	
	/**
	*	Compute the price of the foods
	*/

	public void setMeanFoodPrice() {
		int sum = 0;

		// Adds the price of each element in the list
		for (Food f : this.foods) {
			sum += f.getPrice();
		}

		this.meanFoodPrice = sum/this.foods.size();
	}
	

	/**
	*	Compute the price of the drinks
	*/
	public void setMeanDrinkPrice() {
		int sum = 0;

		// Adds the price of each element in the list
		for (Drink d : this.drinks) {
			sum += d.getPrice();
		}

		this.meanDrinkPrice = sum/this.drinks.size();;
	}
	
	/**
	* Compute the mean price of a list of components - drinks or foods
	*
	* @param components The full list of the components
	*
	* @return int mean price of the components
	*/
	private int computeMeanPrice (ArrayList<Component> components) {
		int sum = 0;

		// Adds the price of each element in the list
		for (Component c : components) {
			sum += c.getPrice();
		}
		return sum/components.size();
	}
}
