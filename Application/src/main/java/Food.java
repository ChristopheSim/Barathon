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

	public boolean getVegan () {
		return this.vegan;
	}

	public boolean getHalal () {
		return this.halal;
	}

	public boolean getVegetarian () {
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
