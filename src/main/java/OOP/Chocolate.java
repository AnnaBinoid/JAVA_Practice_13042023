package OOP;

public class Chocolate extends Product {
    private String chocColor;
    private String chocType;
    private int chocCalories;

    public Chocolate(String productName, double productPrice, String chocColor, String chocType, int chocCalories) {
        super(productName, productPrice);
        this.chocColor = chocColor;
        this.chocType = chocType;
        this.chocCalories = chocCalories;
    }

    @Override
    public String toString() {
        return String.format("Шоколад: %s, Цвет: %s, Вкус: %s, Калории: %d", super.toString(), chocColor, chocType, chocCalories);
    }
}
