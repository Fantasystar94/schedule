package com.example.todo_spring.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SchedulePutResponse {
    private final int status;
    private final String messgae;
    private final SchedulePutReponseData data;
}
