package ru.komlev.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.komlev.toDoList.entity.ExpiredCard;

import java.util.UUID;

@Repository

public interface ExpiredCardRepository extends JpaRepository<ExpiredCard, UUID> {
}
