public class Drink extends Component {

	private double alcohol;
	private boolean sparkling;

	public Drink (String n, int p, double a, boolean s) {
		
		super(n, p);

		this.alcohol = a;
		this.sparkling = s;
		
	}
	
	public boolean IsSoft () {

		// A drink is soft is it contains no alcohol
		if ( this.alcohol == 0 ) {
			return true;
		}
		else {
			return false;
		}
	}

	public double GetAlcohol () {
		return this.alcohol;
	}

	public boolean IsSparkling () {
		return sparkling;
	}
}
