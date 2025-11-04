package com.example.todo_spring.dto;

import lombok.Getter;

//### Lv 4. 일정 삭제  `필수`
//
//        - [ ]  **선택한 일정 삭제**
//        - [ ]  선택한 일정을 삭제할 수 있습니다.
//        - [ ]  서버에 일정 삭제을 요청할 때 `비밀번호`를 함께 전달합니다.
@Getter
public class ScheduleDelRequest {
    private String password;
}
