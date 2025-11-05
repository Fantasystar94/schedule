package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleGetDetailResponse {
    private final int status;
    private final String message;
    private final ScheduleGetReponseData data;
}
