package com.example.todo_spring.dto;

import lombok.Getter;

@Getter
public class SchedulePutRequest {
    private String title;
    private String content;
    private String password;
}
