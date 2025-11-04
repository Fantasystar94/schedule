package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleCreateResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String name;
    private final String createdAt;
}
