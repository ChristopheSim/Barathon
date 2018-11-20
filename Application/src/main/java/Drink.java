import java.lang.*;

/**
*	This class represents the drinks to be added to the menu of a place
*/
public class Drink extends Component {

	private double alcohol;
	private boolean sparkling;

	/**
	* Constructor
	*
	* @param n The name of the food
	* @param p The price of the food
	* @param a The alcochol % of the drink
	* @param s If the drink is sparkling : true
	*/
	public Drink (String n, int p, double a, boolean s) {

		super(n, p);

		this.alcohol = a;
		this.sparkling = s;

	}

	//GETTERS
	public double getAlcohol () {
		return this.alcohol;
	}

	public boolean getSparkling () {
		return this.sparkling;
	}

	//SETTERS
	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	public void setSparkling (boolean sparkling) {
		this.sparkling = sparkling;
	}

	/**
	* This method checks if the drink is alcohol-free
	*
	* @return boolean TRUE if there is no alcohol
	*/
	public boolean getSoft () {
		// A drink is soft if it contains no alcohol
		try {
			double zero = 0.0;
			int result = Double.compare(this.alcohol, zero);
			if (result == 0) {
				return true;
			}
			return false;
		}
		catch (Exception e) {
			System.out.println("Alcohol Comparison Error: Double.compare exception");
			return false;
		}
	}
}
