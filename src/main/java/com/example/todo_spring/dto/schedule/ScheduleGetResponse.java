package com.example.todo_spring.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleGetResponse{
    private final int status;
    private final String message;
    private final List<ScheduleGetReponseData> data;
}
