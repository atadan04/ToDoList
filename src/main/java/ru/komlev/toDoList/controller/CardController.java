package ru.komlev.toDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.komlev.toDoList.entity.Card;
import ru.komlev.toDoList.service.CardService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Card>> getAll() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Card> insert(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.add(card));
    }

    @DeleteMapping("/")
    public ResponseEntity<UUID> delete(@PathVariable("id") UUID id) {
        cardService.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
