package com.example.todo_spring.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private final int status;
    private final String message;
    private final CommentCreateResponseData data;
}
