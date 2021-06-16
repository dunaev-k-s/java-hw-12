package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class searchByMockitoTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    ProductManager manager = new ProductManager();
    private Book one = new Book(1, "A Promised Land", 3400, "Barak Obama");
    private Book two = new Book(2, "Green Light", 580, "Matthew McConaughey");
    private Book three = new Book(3, "War and piece", 10000, "Lev Tolstoy");
    private Book four = new Book(4, "Hangover", 620, "Charles Buckovsky");
    private Book five = new Book(5, "On the bottom", 200, "Eight");
    private Smartphone six = new Smartphone(6, "Green Light", 3400, "Lev Tolstoy");
    private Smartphone seven = new Smartphone(7, "Mi9Lite", 10000, "Xiaomi");
    private Smartphone eight = new Smartphone(8, "Eight", 70000, "iPhone");
    private Smartphone nine = new Smartphone(9, "1100", 100000, "Nokia");
    private Smartphone ten = new Smartphone(10, "Chebureck", 1000, "Alcatel");

    @Test
    public void shouldBeSearchBy() {
        Product[] returned = new Product[]{one,two,three,four,five,six,seven,eight,nine,ten};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Eight");
        Product[] expected = new Product[]{five,eight};

        assertArrayEquals(actual,expected);

        verify(repository).findAll();

    }

}
