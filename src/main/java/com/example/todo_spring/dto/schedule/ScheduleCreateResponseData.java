package com.example.todo_spring.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleCreateResponseData {
    private final Long id;
    private final String title;
    private final String content;
    private final String Name;
}
