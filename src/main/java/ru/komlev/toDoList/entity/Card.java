package ru.komlev.toDoList.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "card", indexes = {@Index(name = "idx_title", columnList = "title", unique = true)})

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", unique = true)
    private String title;
    private String status;

    public StatusEnum getStatus() {
        return status == null ? null : StatusEnum.fromValue(status);
    }

    public void setStatus(StatusEnum status) {
        this.status = status == null ? null : status.getValue();
    }
}
