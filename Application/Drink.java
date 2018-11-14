import java.lang.*;

public class Drink extends Component {

	private double alcohol;
	private boolean sparkling;

	public Drink (String n, int p, double a, boolean s) {

		super(n, p);

		this.alcohol = a;
		this.sparkling = s;

	}

	public boolean GetSoft () {
		// A drink is soft is it contains no alcohol
		try {
			double zero = 0.0;
			int result = Double.compare(this.alcohol, zero);
			if (result > 0) {
				return false;
			} else if (result < 0) {
				System.out.println("Alcohol Comparison Error: alcohol < 0.0");
			} else {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("Alcohol Comparison Error: Double.compare exception");
		}
	}

	public double GetAlcohol () {
		return this.alcohol;
	}

	public boolean GetSparkling () {
		return this.sparkling;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	public void setSparkling (boolean sparkling) {
		this.sparkling = sparkling;
	}
}
