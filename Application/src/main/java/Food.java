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

	public boolean GetVegan () {
		return this.vegan;
	}

	public boolean GetHalal () {
		return this.halal;
	}

	public boolean GetVegetarian () {
		return this.vegetarian;
	}

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
