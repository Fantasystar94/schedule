package com.example.todo_spring.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleDelResponse {
    private final int status;
    private final String messgae;
}
