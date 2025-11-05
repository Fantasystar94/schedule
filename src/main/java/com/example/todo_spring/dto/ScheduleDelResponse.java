package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class ScheduleDelResponse {
    private final int status;
    private final String messgae;
}
