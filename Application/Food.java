public class Food extends Component {

	private boolean vegan;
	private boolean halal;
	private boolean vegetarian;

	public Food (String n, int p, boolean vgn, boolean h, boolean vgt) {
		super(n, p);

		this.vegan = vgn;
		this.halal = h;
		this.vegetarian = vgt;

	}

	public boolean IsVegan () {
		return this.vegan;	
	}

	public boolean IsHalal () {
		return this.halal;	
	}

	public boolean IsVegetarian () {
		return this.vegetarian;	
	}
}
