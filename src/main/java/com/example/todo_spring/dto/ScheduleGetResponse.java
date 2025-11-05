package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleGetResponse{
    private final int status;
    private final String message;
    private final List<ScheduleGetReponseData> data;
}
