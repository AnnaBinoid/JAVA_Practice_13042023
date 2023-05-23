package Lection6;

import java.util.Objects;

public class Cat {

    String breed;
    String name;
    double age;
    double weight;
    boolean isMale;
    String ownerName;

    public Cat(String breed, String name, double age, double weight, boolean isMale, String ownerName) {
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isMale = isMale;
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(age).append(" ").append(breed);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (!(o instanceof Cat)){
            return false;
        }

        Cat temp = (Cat) o;

        return temp.breed == this.breed && temp.name == this.name &&
        temp.age == this.age && temp.weight == this.weight &&
        temp.isMale == this.isMale && temp.ownerName == this.ownerName;

    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, age, weight, isMale, ownerName);
    }
}
