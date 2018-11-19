/**
*	This class represents the components to be added to a menu
*	This is the super class of Food and Drink
*/
public abstract class Component {

	protected String name;
	protected int price;

	/**
	* Constructor
	*
	* @param n The name of the food
	* @param p The price of the food
	*/
	public Component (String n, int p) {

		this.name = n;
		this.price = p;

	}

	/**
	*	This method checks if 2 Components are equals
	*
	* @return boolean TRUE if the 2 Components are equals
	*/
	public boolean isEqual (Component c) {
		//Need further implementation
		return this.name == c.getName();

	}
	
	//GETTERS
	public String getName () {
		return this.name;
	}

	public int getPrice () {
		return this.price;
	}
	
	//SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
