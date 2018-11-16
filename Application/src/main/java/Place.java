public class Place {
    private int id;
    private String name;
    private Address address;
    private Menu menu;
    private Caracteristics caracteristics;

    public Place(int id, String name, Address address, Menu menu,
        Caracteristics caracteristics)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.menu = menu;
        this.caracteristics = caracteristics;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
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
