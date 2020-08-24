package ua.alevel.phonesdb;

import java.util.Objects;

public class Phone {
    private int ID;
    private String companyName;
    private String model;
    private int storageMemory;
    private double price;
    private double screenDiagonal;
    private String color;

    public Phone() {
    }

    public Phone(String companyName, String model, int storageMemory, double price, double screenDiagonal, String color) {
        this.companyName = companyName;
        this.model = model;
        this.storageMemory = storageMemory;
        this.price = price;
        this.screenDiagonal = screenDiagonal;
        this.color = color;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        if (ID > 0) {
            this.ID = ID;
        } else {
            throw new RuntimeException();
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (companyName != null && !companyName.isEmpty()) {
            this.companyName = companyName;
        } else {
            throw new RuntimeException();
        }

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null && !model.isEmpty()) {
            this.model = model;
        } else {
            throw new RuntimeException();
        }
    }

    public int getStorageMemory() {
        return storageMemory;
    }

    public void setStorageMemory(int storageMemory) {
        if (storageMemory > 0) {
            this.storageMemory = storageMemory;
        } else {
            throw new RuntimeException();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new RuntimeException();
        }
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        if (screenDiagonal > 0) {
            this.screenDiagonal = screenDiagonal;
        } else {
            throw new RuntimeException();
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return ID == phone.ID &&
                storageMemory == phone.storageMemory &&
                Double.compare(phone.price, price) == 0 &&
                Double.compare(phone.screenDiagonal, screenDiagonal) == 0 &&
                Objects.equals(companyName, phone.companyName) &&
                Objects.equals(model, phone.model) &&
                Objects.equals(color, phone.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, companyName, model, storageMemory, price, screenDiagonal, color);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ID=" + ID +
                ", companyName='" + companyName + '\'' +
                ", model='" + model + '\'' +
                ", storageMemory=" + storageMemory +
                ", price=" + price +
                ", screenDiagonal=" + screenDiagonal +
                ", color='" + color + '\'' +
                '}';
    }
}
