package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SchedulePutResponse {
    private final int status;
    private final String messgae;
    private final SchedulePutReponseData data;
}
