package Lection6;

public class TheaterCat extends Cat {
    String trick;

    public TheaterCat(String breed, String name, double age, double weight, boolean isMale, String ownerName, String trick) {
        super(breed, name, age, weight, isMale, ownerName);
        this.trick = trick;
    }

    @Override
    public String toString() {
        return super.toString() + " " + trick;
    }
}
