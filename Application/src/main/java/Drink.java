import java.lang.*;

public class Drink extends Component {

	private double alcohol;
	private boolean sparkling;

	public Drink (String n, int p, double a, boolean s) {

		super(n, p);

		this.alcohol = a;
		this.sparkling = s;

	}

	public boolean getSoft () {
		// A drink is soft is it contains no alcohol
		try {
			double zero = 0.0;
			int result = Double.compare(this.alcohol, zero);
			if (result > 0) {
				return true;
			}
			return false;
		}
		catch (Exception e) {
			System.out.println("Alcohol Comparison Error: Double.compare exception");
			return false;
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
