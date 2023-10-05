package ru.komlev.toDoList.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;


@Entity
@Table(name = "card", indexes = {@Index(name = "idx_title", columnList = "title", unique = true)})
public class Card extends BaseCard {
    public Card() {
        super();
    }
}
