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

}