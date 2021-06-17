package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class removeByIdTest {
    ProductRepository repository = new ProductRepository();
    private Book one = new Book(1, "A Promised Land", 3400, "Barak Obama");
    private Book two = new Book(2, "Green Light", 580, "Matthew McConaughey");
    private Book three = new Book(3, "War and piece", 10000, "Lev Tolstoy");
    private Book four = new Book(4, "Hangover", 620, "Charles Buckovsky");
    private Book five = new Book(5, "On the bottom", 200, "Maksim Gorky");
    private Smartphone six = new Smartphone(6, "Green Light", 3400, "Lev Tolstoy");
    private Smartphone seven = new Smartphone(7, "Mi9Lite", 10000, "Xiaomi");
    private Smartphone eight = new Smartphone(8, "Eight", 70000, "iPhone");
    private Smartphone nine = new Smartphone(9, "1100", 100000, "Nokia");
    private Smartphone ten = new Smartphone(10, "Chebureck", 1000, "Alcatel");

    @BeforeEach
    public void setUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
        repository.save(six);
        repository.save(seven);
        repository.save(eight);
        repository.save(nine);
        repository.save(ten);
    }


    @Test
    public void shouldRemoveById() {
        Product[] result = new Product[]{one, two, three, four, five, six, eight, nine, ten};

        repository.removeById(7);

        Product[] actual = repository.findAll();
        Product[] expected = result;

        assertArrayEquals(actual, expected);

    }

    @Test
    public void assertThrowUncheckedException() {

        assertThrows(NotFoundException.class, () -> repository.removeById(20));

    }


}
