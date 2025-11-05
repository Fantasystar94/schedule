package com.example.todo_spring.controller;

import com.example.todo_spring.dto.*;
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

    //기
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleCreateResponse> postApi(@RequestBody ScheduleCreateRequest req){
        ScheduleCreateResponse result = scheduleService.save(HttpStatus.CREATED.value(), req);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetResponse>> getApi(@RequestParam(required = false) String name){
        List<ScheduleGetResponse> result = scheduleService.getAll(HttpStatus.OK.value(), name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleGetDetailResponse> getDetailApi(@PathVariable Long id) {
        ScheduleGetDetailResponse result = scheduleService.getDetail(HttpStatus.OK.value(), id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<SchedulePutResponse> putDetailApi(@PathVariable Long id, @RequestBody SchedulePutRequest req) {
        SchedulePutResponse result = scheduleService.putDetail(id, HttpStatus.OK.value(), req);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<ScheduleDelResponse> deleteApi(@PathVariable Long id, @RequestBody ScheduleDelRequest req) {
        ScheduleDelResponse result = scheduleService.deleteDetail(HttpStatus.OK.value(), id, req);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
