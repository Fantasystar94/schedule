package com.example.todo_spring.service;

import com.example.todo_spring.dto.GetScheduleResponse;
import com.example.todo_spring.dto.CreateScheduleRequest;
import com.example.todo_spring.dto.CreateScheduleResponse;
import com.example.todo_spring.entity.Schedule;
import com.example.todo_spring.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    //속
    private final ScheduleRepository scheduleRepo;
    //생

    //기
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest req) {

        Schedule schedule = new Schedule(
                req.getTitle(),
                req.getContent(),
                req.getName(),
                req.getPassword()
        );
        String date = LocalDate.now().toString();
        LocalTime time = LocalTime.now();
        schedule.setCreatedAt(date+" "+time);

        Schedule saved = scheduleRepo.save(schedule);

        return new CreateScheduleResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getName(),
                saved.getCreatedAt()
        );

    }

    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAll(String name) {
        // DB에서 모든 데이터 조회
        List<Schedule> schedules = scheduleRepo.findAll();
        schedules.stream().filter(schedule -> schedule.getName().equals(name)).forEach(schedule -> {

        });
        // 엔티티 => DTO
        List<GetScheduleResponse> dtos = new ArrayList<>();
        for (Schedule s : schedules) {
            GetScheduleResponse scheduleGetApi = new GetScheduleResponse(
                    s.getId(),
                    s.getTitle(),
                    s.getContent(),
                    s.getName(),
                    s.getCreatedAt()
            );
            dtos.add(scheduleGetApi);
        }
        return dtos;
    }
}
