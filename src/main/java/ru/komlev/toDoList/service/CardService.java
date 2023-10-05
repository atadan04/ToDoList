package ru.komlev.toDoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.komlev.toDoList.entity.Card;
import ru.komlev.toDoList.repository.CardRepository;
import ru.komlev.toDoList.repository.ExpiredCardRepository;
import ru.komlev.toDoList.transformer.CardTransformer;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    private CardRepository cardRepository;
    private ExpiredCardRepository expiredCardRepository;

    @Autowired
    public CardService(CardRepository cardRepository, ExpiredCardRepository expiredCardRepository) {
        this.cardRepository = cardRepository;
        this.expiredCardRepository = expiredCardRepository;
    }


    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card add(Card card) {
        return cardRepository.save(card);
    }

    public void deleteById(UUID id) {
        cardRepository.deleteById(id);
    }

    public void moveCardToExpiredCard(LocalDate date) {
        List<Card> cards = cardRepository.findByDateEndingLessThan(date);
        cards.forEach(card -> {
            expiredCardRepository.save(CardTransformer.convertToExpiredCard(card));
            cardRepository.delete(card);
        });


    }
}

