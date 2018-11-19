/**
*	This class represents the foods to be added to the menu of a place
*/
public class Food extends Component {

	private boolean vegan;
	private boolean halal;
	private boolean vegetarian;

	/**
	* Constructor
	*
	* @param n The name of the food
	* @param p The price of the food
	* @param vgn If the food is vegan : true
	* @param h If the food is halal : true
	* @param vgt If the food is vegetarian : true
	*/
	public Food (String n, int p, boolean vgn, boolean h, boolean vgt) {
		super(n, p);

		this.vegan = vgn;
		this.halal = h;
		this.vegetarian = vgt;

	}
	
	//GETTERS
	public boolean getVegan () {
		return this.vegan;
	}

	public boolean getHalal () {
		return this.halal;
	}

	public boolean getVegetarian () {
		return this.vegetarian;
	}
	
	//SETTERS
	public void setVegan (boolean vegan) {
		this.vegan = vegan;
	}

	public void setHalal (boolean halal) {
		this.halal = halal;
	}

	public void setVegetarian (boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
}
