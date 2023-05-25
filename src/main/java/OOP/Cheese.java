package OOP;

public class Cheese extends Product{
    private String cheeseType;
    private double weight;

    public Cheese(String productName, double productPrice, String cheeseType, double weight) {
        super(productName, productPrice);
        this.cheeseType = cheeseType;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Cыр: %s, Тип: %s, Вес: %f", super.toString(), cheeseType, weight);
    }
}
