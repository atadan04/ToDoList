package ru.komlev.toDoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.komlev.toDoList.entity.Card;
import ru.komlev.toDoList.repository.CardRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    private CardRepository cardRepository;
    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    public List<Card> getAll(){
        return cardRepository.findAll();
    }
    public Card add(Card card){
        return  cardRepository.save(card);

    }
    public void deleteById(UUID id){
        cardRepository.deleteById(id);
    }
}
