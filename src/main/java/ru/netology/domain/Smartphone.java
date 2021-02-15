package ru.netology.domain;

public class Smartphone extends Product {
    private String Factory;

    public Smartphone(int id, String name, int price) {
        super(id, name, price);
    }

    public Smartphone(int id, String name, int price, String Factory) {
        super(id, name, price);
        this.Factory = Factory;
    }

    public String getFactory() {
        return Factory;
    }

    public void setFactory(String Factory) {
        this.Factory = Factory;
    }
}
