package ru.komlev.toDoList.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseCard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", unique = true)
    private String title;
    private String status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreationTimestamp
    private LocalDate dateAdded;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dateEnding;


    public BaseCard(UUID id, String title, String status, LocalDate dateAdded, LocalDate dateEnding) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.dateAdded = dateAdded;
        this.dateEnding = dateEnding;
    }

    public BaseCard() {
    }

    public StatusEnum getStatus() {
        return status == null ? null : StatusEnum.fromValue(status);
    }

    public void setStatus(StatusEnum status) {
        this.status = status == null ? null : status.getValue();
    }
}
