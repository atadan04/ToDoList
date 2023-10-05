package ru.komlev.toDoList.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusEnum {
    NEW("new"),
    COMPLETE("complete");
    private final String value;

    public static StatusEnum fromValue(String value) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }

        }
        return null;
    }

}
