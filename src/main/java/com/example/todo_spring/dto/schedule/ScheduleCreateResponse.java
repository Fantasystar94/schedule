package com.example.todo_spring.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleCreateResponse<T> {
    private final int status;
    private final String message;
    private final T data;
}
