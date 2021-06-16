package ru.netology.manager;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class matchesModelsTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Test 1)' | A Promised Land | Barak Obama         | Land    | true  ",
                    "'(Test 2)' | Green Light     | Matthew McConaughey | Error   | false ",
                    "'(Test 3)' | War and piece   | Lev Tolstoy         | Tolstoy | true ",
            },
            delimiter = '|'
    )
    void bookMatchesTest(String test,
                         String title,
                         String author,
                         String search,
                         boolean expected) {

        Book book = new Book(author);
        book.setTitle(title);
        assertEquals(expected, book.matches(search));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Test 1)' | A Promised Land | Barak Obama         | Land    | true  ",
                    "'(Test 2)' | Green Light     | Matthew McConaughey | Error   | false ",
                    "'(Test 3)' | Mi9Lite         | Xiaomi              | Xiaomi  | true ",
            },
            delimiter = '|'
    )
    void smartphonesMatchesTest(String test,
                         String title,
                         String producer,
                         String search,
                         boolean expected) {

        Smartphone smartphone = new Smartphone(producer);
        smartphone.setTitle(title);
        assertEquals(expected, smartphone.matches(search));
    }
}
