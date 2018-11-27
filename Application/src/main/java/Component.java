/**
 *	This class represents the components to be added to a menu.
 *	This is the super class of Food and Drink.
 */
public abstract class Component {

	private  String name;
	private int price;

	/**
	 * Constructor.
	 *
	 * @param n The name of the component.
	 * @param p The price of the component.
	 */
	public Component(String n, int p) {

		this.name = n;
		this.price = p;

	}

	/**
	 *	This method checks if 2 Components are equals.
	 *
	 * @param c Component.
	 * @return boolean TRUE if the 2 Components are equals.
	 */
	public boolean isEqual(Component c) {
		//Need further implementation
		return this.name == c.getName();

	}

	/**
	 * Method to get the component's name.
	 *
	 * @return string representing the component's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method to get the component's price.
	 *
	 * @return int representing the component's price.price
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * Method to set the component's name.
	 *
	 * @param name string representing the component's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to set the component's price.
	 *
	 * @param price int representing the component's price.
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
