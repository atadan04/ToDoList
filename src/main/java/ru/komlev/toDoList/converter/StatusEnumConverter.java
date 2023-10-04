package ru.komlev.toDoList.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.komlev.toDoList.entity.StatusEnum;

@Component
public class StatusEnumConverter implements Converter<String, StatusEnum> {

    @Override
    public StatusEnum convert(String source) {
        return StatusEnum.valueOf(source);
    }
}
