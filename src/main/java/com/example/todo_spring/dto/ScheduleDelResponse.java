package com.example.todo_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class ScheduleDelResponse {
    private String message = "삭제되었습니다.";
}
