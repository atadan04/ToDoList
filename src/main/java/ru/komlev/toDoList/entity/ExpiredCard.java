package ru.komlev.toDoList.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "expired_card")
public class ExpiredCard extends BaseCard {
    public ExpiredCard(UUID id, String title, String status, LocalDate dateAdded, LocalDate dateEnding) {
        super(id, title, status, dateAdded, dateEnding);
    }

    public ExpiredCard() {
        super();
    }
}
