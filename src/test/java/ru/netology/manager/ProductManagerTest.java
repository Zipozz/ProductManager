package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldSearchNameBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1,"Just Masa",600,"Boris Akunin",448);
        Book book2 = new Book(2,"POST",800,"Dmitry Glukhovsky",310);
        Book book3 = new Book(3,"Inside the Killer",900,"Mike Omer",340);
        Book book4 = new Book(4,"Bad Blood",500,"Robert Galbraith",1100);
        Book book5 = new Book(5,"Anxious People",340,"Fredrik Backman",300);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        Product[] actual=manager.searchBy("Inside the Killer");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthorBook() {
       ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1,"Just Masa",600,"Boris Akunin",448);
        Book book2 = new Book(2,"POST",800,"Dmitry Glukhovsky",310);
        Book book3 = new Book(3,"Inside the Killer",900,"Mike Omer",340);
        Book book4 = new Book(4,"Bad Blood",500,"Robert Galbraith",1100);
        Book book5 = new Book(5,"Anxious People",340,"Fredrik Backman",300);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        Product[] actual=manager.searchBy("Dmitry Glukhovsky");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1,"Just Masa",600,"Boris Akunin",448);
        Book book2 = new Book(2,"POST",800,"Dmitry Glukhovsky",310);
        Book book3 = new Book(3,"Just Masa",600,"Boris Akunin",448);
        Book book4 = new Book(4,"Bad Blood",500,"Robert Galbraith",1100);
        Book book5 = new Book(5,"Anxious People",340,"Fredrik Backman",300);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        Product[] actual=manager.searchBy("Just Masa");
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameSmartphone () {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1,"Galaxy S20", 46000, "Korea");
        Smartphone smartphone2 = new Smartphone(2,"iPhone 12", 74000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFactorySmartphone () {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1,"Galaxy S20", 46000, "Korea");
        Smartphone smartphone2 = new Smartphone(2,"iPhone 12", 74000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("USA");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoSmartphone () {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1,"Galaxy S20", 46000, "Korea");
        Smartphone smartphone2 = new Smartphone(1,"Galaxy S20", 46000, "Korea");
        Smartphone smartphone3 = new Smartphone(3,"iPhone 12", 74000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual=manager.searchBy("Galaxy S20");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookAndSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1,"Just Masa",600,"Boris Akunin",448);
        Book book2 = new Book(2,"POST",800,"Dmitry Glukhovsky",310);
        Book book3 = new Book(3,"Inside the Killer",900,"Mike Omer",340);
        Book book4 = new Book(4,"Galaxy S20",500,"no", 3);
        Book book5 = new Book(5,"Anxious People",340,"Fredrik Backman",300);
        Smartphone smartphone1 = new Smartphone(1,"Galaxy S20", 46000, "Korea");
        Smartphone smartphone2 = new Smartphone(2,"iPhone 12", 74000, "USA");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("Galaxy S20");
        Product[] expected = new Product[]{book4, smartphone1};
        assertArrayEquals(expected, actual);
    }
}