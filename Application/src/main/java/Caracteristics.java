public class Caracteristics {
    private boolean cheap;
    private boolean music;
    private boolean famousPlace;
    private boolean food;
    private boolean vegetarian;
    private boolean halal;
    private boolean vegan;
    private boolean alcohol;

    public Caracteristics(boolean cheap, boolean music, boolean famousPlace,
        boolean food, boolean vegetarian, boolean halal,
        boolean vegan, boolean alcohol)
        {
            this.cheap = cheap;
            this.music = music;
            this.famousPlace = famousPlace;
            this.food = food;
            this.vegetarian = vegetarian;
            this.halal = halal;
            this.vegan = vegan;
            this.alcohol = alcohol;
        }

    public boolean getCheap() {
        return this.cheap;
    }

    public boolean getMusic() {
        return this.music;
    }

    public boolean getFamousPlace() {
        return this.famousPlace;
    }

    public boolean getFood() {
        return this.food;
    }

    public boolean getVegetarian() {
        return this.vegetarian;
    }

    public boolean getHalal() {
        return this.halal;
    }

    public boolean getVegan() {
        return this.vegan;
    }

    public boolean getAlcohol() {
        return this.alcohol;
    }

    public void setCheap(boolean cheap) {
        this.cheap = cheap;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public void setFamousPlace(boolean fp) {
        this.famousPlace = fp;
    }

    public void setFood(boolean food) {
      this.food = food;
    }

    public void setVegetarian(boolean vegetarian) {
      this.vegetarian = vegetarian;
    }

    public void setHalal(boolean halal) {
      this.halal = halal;
    }

    public void setVegan(boolean vegan) {
      this.vegan = vegan;
    }

    public void setAlcohol(boolean alcohol) {
      this.alcohol = alcohol;
    }
}
