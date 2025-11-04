package com.example.todo_spring.controller;

import com.example.todo_spring.dto.GetScheduleResponse;
import com.example.todo_spring.dto.CreateScheduleRequest;
import com.example.todo_spring.dto.CreateScheduleResponse;
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
    public ResponseEntity<CreateScheduleResponse> postApi(@RequestBody CreateScheduleRequest req){
        CreateScheduleResponse result = scheduleService.save(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getApi(@RequestParam(required = false) String name){
        List<GetScheduleResponse> result;
        result = scheduleService.getAll(name);
        if (name == null) {
        }
//        } else {
////            result = scheduleService.findByName()
//        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
