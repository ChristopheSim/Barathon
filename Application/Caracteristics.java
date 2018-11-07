public class Caracteristics {
    private boolean cheap;
    private boolean music;
    private boolean famousPlace;
    private boolean food;
    private int foodNb;
    private boolean vegetarian;
    private boolean halal;
    private boolean vegan;
    private boolean alcohol;

    Caracteristics(boolean cheap, boolean music, boolean famousPlace,
        boolean food, int foodNb, boolean vegetarian, boolean halal,
        boolean vegan, boolean alcohol)
        {
            this.cheap = cheap;
            this.music = music;
            this.famousPlace = famousPlace;
            this.food = food;
            this.foodNb = foodNb;
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

    public int getFoodNb() {
        return this.foodNb;
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
}
