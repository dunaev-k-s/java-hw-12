package ru.netology.domain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, String title, int price, String producer) {
        super(id, title, price);
        this.producer = producer;
    }
}
