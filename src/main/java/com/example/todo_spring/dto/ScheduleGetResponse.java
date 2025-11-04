package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleGetResponse {
    private Long id;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
