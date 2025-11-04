package com.example.todo_spring.controller;

import com.example.todo_spring.dto.ScheduleGetDetailResponse;
import com.example.todo_spring.dto.ScheduleGetResponse;
import com.example.todo_spring.dto.ScheduleCreateRequest;
import com.example.todo_spring.dto.ScheduleCreateResponse;
import com.example.todo_spring.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    //속
    private final ScheduleService scheduleService;

    //생


    @PostMapping("/schedules")
    public ResponseEntity<ScheduleCreateResponse> postApi(@RequestBody ScheduleCreateRequest req){
        ScheduleCreateResponse result = scheduleService.save(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetResponse>> getApi(@RequestParam(required = false) String name){
        List<ScheduleGetResponse> result = scheduleService.getAll(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleGetDetailResponse> getDetailApi(@PathVariable Long id) {
        ScheduleGetDetailResponse result = scheduleService.getDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
