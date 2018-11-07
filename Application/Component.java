public abstract class Component {

	protected String name;
	protected int price;

	public Component (String n, int p) {
		
		this.name = n;
		this.price = p;		
		
	}
	
	public boolean IsEqual (Component c) {

		return true;

	}

	public String GetName () {
		return this.name;
	}

	public int GetPrice () {
		return this.price;
	}

}
