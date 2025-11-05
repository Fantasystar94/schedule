package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleCommentRequest {
    private String content;
    private String name;
    private String password;

}
