package org.example.entity;

public class ProjectPrice {
    private String name;
    private int price;

    public ProjectPrice(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "Name='" + name + '\'' +
                ", Price=" + price +
                '}';
    }
}
