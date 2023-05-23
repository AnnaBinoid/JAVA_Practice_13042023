package HomeWork06;

import java.util.Objects;

public class Notebook {
    String brand;
    String model;
    String countryManufacturer;
    double diagonal;
    int coresCount; //кол-во ядер
    String permission; // разрешение
    String processorType; //Intel,AMD
    String underProcessorType; //
    double processorFrequency; // частота процессора
    int ozu;
    String graphicProcessor;
    int diskSize;
    String operationSystem;
    String keyboard;
    boolean keyboardIllumination;
    String colour;
    int price;



    public Notebook(String brand, String model, String countryManufacturer,
                    double diagonal, int coresCount, String permission,
                    String processorType, String underProcessorType,
                    double processorFrequency, int ozu, String graphicProcessor,
                    int diskSize, String operationSystem, String keyboard,
                    boolean keyboardIllumination, String colour, int price) {
        this.brand = brand;
        this.model = model;
        this.countryManufacturer = countryManufacturer;
        this.diagonal = diagonal;
        this.coresCount = coresCount;
        this.permission = permission;
        this.processorType = processorType;
        this.underProcessorType = underProcessorType;
        this.processorFrequency = processorFrequency;
        this.ozu = ozu;
        this.graphicProcessor = graphicProcessor;
        this.diskSize = diskSize;
        this.operationSystem = operationSystem;
        this.keyboard = keyboard;
        this.keyboardIllumination = keyboardIllumination;
        this.colour = colour;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(brand).append(" ").append(model).append(", ").append(diagonal).append("\"").append(", ").append(processorType).
                append(" ").append(underProcessorType).append(" ").append(processorFrequency).
                append(" Ггц, ").append(coresCount).append("-ядерный, \n").append(ozu).
                append(" ГБ, ").append(diskSize).append(" ГБ SSD, ").append(graphicProcessor).
                append(", ").append(operationSystem).append(", ").append(colour).append(" Цена: ").append(price).append(" руб.");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Double.compare(notebook.diagonal, diagonal) == 0 && coresCount == notebook.coresCount
                && Double.compare(notebook.processorFrequency, processorFrequency) == 0 && ozu == notebook.ozu
                && diskSize == notebook.diskSize && keyboardIllumination == notebook.keyboardIllumination
                && brand.equals(notebook.brand) && model.equals(notebook.model)
                && countryManufacturer.equals(notebook.countryManufacturer) && permission.equals(notebook.permission)
                && processorType.equals(notebook.processorType) && underProcessorType.equals(notebook.underProcessorType)
                && graphicProcessor.equals(notebook.graphicProcessor) && operationSystem.equals(notebook.operationSystem)
                && keyboard.equals(notebook.keyboard) && colour.equals(notebook.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, countryManufacturer, diagonal, coresCount, permission, processorType,
                underProcessorType, processorFrequency, ozu, graphicProcessor, diskSize, operationSystem,
                keyboard, keyboardIllumination, colour, price);
    }

}