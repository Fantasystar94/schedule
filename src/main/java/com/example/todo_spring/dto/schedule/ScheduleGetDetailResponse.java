package com.example.todo_spring.dto.schedule;

import com.example.todo_spring.dto.comment.CommentDetailResponseData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleGetDetailResponse {
    private final int status;
    private final String message;
    private final ScheduleGetReponseData data;
    private final List<CommentDetailResponseData> commnets;
}
