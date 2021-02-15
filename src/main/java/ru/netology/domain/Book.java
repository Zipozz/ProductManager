package ru.netology.domain;

public class Book extends Product {
    private String author;
    private int volume;

    public Book(int id, String name, int price) {
        super(id, name, price);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author, int volume) {
        super(id, name, price);
        this.author = author;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

