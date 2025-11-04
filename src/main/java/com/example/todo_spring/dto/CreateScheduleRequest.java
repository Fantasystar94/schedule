package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateScheduleRequest {
    private String title;
    private String content;
    private String name;
    private String password;

}
