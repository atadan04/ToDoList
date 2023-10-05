package ru.komlev.toDoList.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.komlev.toDoList.service.CardService;

import java.time.LocalDate;

@Component
public class CardTask {
    @Autowired
    CardService cardService;
    @Scheduled(cron = "3 * * * * *")
    public void setExpiredCard(){
        cardService.moveCardToExpiredCard(LocalDate.now());
    }
}
