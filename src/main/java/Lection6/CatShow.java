package Lection6;

public class CatShow extends Cat {
    String colour;
    String motherName;
    String fatherName;
    int countOfMedals;
    int place;
    String category;

    public CatShow(String breed, String name, double age, double weight, boolean isMale, String ownerName,
                   String colour, String motherName, String fatherName, int countOfMedals, int place, String category){
        super(breed, name, age, weight, isMale, ownerName);
        this.colour = colour;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.countOfMedals = countOfMedals;
        this.place = place;
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() + " " + colour + " " + motherName + " " + fatherName + " " +
                countOfMedals + " " + place + " " + category;
    }
}
