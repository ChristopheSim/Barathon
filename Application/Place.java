public class Place {
    private String name;
    private Address address;
    private Menu menu;
    private Caracteristics caracteristics;

    Place(String name, Address address, Menu menu,
        Caracteristics caracteristics)
    {
        this.name = name;
        this.address = address;
        this.menu = menu;
        this.caracteristics = caracteristics;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Address getAddress(){
        return this.address;
    }

    public void setAddress(Address address) {
  		this.address = address;
  	}

    public Menu getMenu() {
      return this.menu;
    }

    public void setMenu(Menu menu) {
  		this.menu = menu;
  	}

    public Caracteristics getCaracteristics() {
      return this.caracteristics;
    }

    public void setCaracteristics(Caracteristics carac) {
  		this.caracteristics = carac;
  	}
}
