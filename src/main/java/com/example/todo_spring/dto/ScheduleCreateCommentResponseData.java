package com.example.todo_spring.dto;

import com.example.todo_spring.entity.Comment;
import com.example.todo_spring.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleCreateCommentResponseData {
    //속
    private final Long id;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long scheduleId;
    //생
    public ScheduleCreateCommentResponseData(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.name = comment.getName();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.scheduleId = comment.getScheduleId();
    }
    //기
}
