package Lection6;

public class VetCat extends Cat {
    String medicalHistory;
    Boolean isSterilized;

    public VetCat(String breed, String name, double age, double weight, boolean isMale, String ownerName,
                  String medicalHistory, Boolean isSterilized) {
        super(breed, name, age, weight, isMale, ownerName);
        this.medicalHistory = medicalHistory;
        this.isSterilized = isSterilized;
    }

    @Override
    public String toString() {
        return super.toString() + " " + medicalHistory + " " + isSterilized;
    }
}
