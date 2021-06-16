package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends Product {
    private String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }
    public Book(String author){
        this.author=author
    }

    public boolean matches(String search) {
        if (super.matches(search)) return true;
        return author.contains(search);
    }

}
