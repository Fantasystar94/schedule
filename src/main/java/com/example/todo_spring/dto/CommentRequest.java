package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequest {
    private String content;
    private String name;
    private String password;

}
