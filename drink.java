public class Drink extends Component {

	private double alcohol;
	private boolean sparkling;

	public Drink (String n, int p, double a, boolean s) {
		
		super(n, p);

		this.alcohol = a;
		this.sparkling = s;
		
	}

}
