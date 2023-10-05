package ru.komlev.toDoList.transformer;

import ru.komlev.toDoList.entity.Card;
import ru.komlev.toDoList.entity.ExpiredCard;


public class CardTransformer {
    public static ExpiredCard convertToExpiredCard(Card card) {
        return new ExpiredCard(card.getId(), card.getTitle(), card.getStatus().getValue(), card.getDateAdded(), card.getDateEnding());
    }
}
