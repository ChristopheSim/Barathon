public abstract class Component {

	protected String name;
	protected int price;

	public Component (String n, int p) {

		this.name = n;
		this.price = p;

	}

	public boolean isEqual (Component c) {

		return this.name == c.getName();

	}

	public String getName () {
		return this.name;
	}

	public int getPrice () {
		return this.price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
