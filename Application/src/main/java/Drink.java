import java.lang.*;

public class Drink extends Component {

	private double alcohol;
	private boolean sparkling;

	public Drink (String n, int p, double a, boolean s) {

		super(n, p);
		
		double zero = 0.0;
		int result = Double.compare(a, zero);
		if (result >= 0) {
			this.alcohol = a;
		}
		else {
			this.alcohol = 0.0;
		}

		this.sparkling = s;

	}

	public boolean getSoft () {
		// A drink is soft if it contains no alcohol
		try {
			double zero = 0.0;
			int result = Double.compare(this.alcohol, zero);
			if (result > 0) {
				return false;
			} else if (result < 0) {
				System.out.println("Alcohol Comparison Error: alcohol < 0.0");
				return true;
			} else {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("Alcohol Comparison Error: Double.compare exception");
		}
	}

	public double getAlcohol () {
		return this.alcohol;
	}

	public boolean getSparkling () {
		return this.sparkling;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	public void setSparkling (boolean sparkling) {
		this.sparkling = sparkling;
	}
}
