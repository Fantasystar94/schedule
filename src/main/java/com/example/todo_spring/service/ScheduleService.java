package com.example.todo_spring.service;

import com.example.todo_spring.dto.*;
import com.example.todo_spring.entity.Schedule;
import com.example.todo_spring.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ScheduleCreateResponse save(ScheduleCreateRequest req) {

        Schedule schedule = new Schedule(
                req.getTitle(),
                req.getContent(),
                req.getName(),
                req.getPassword()
        );

        Schedule saved = scheduleRepo.save(schedule);

        return new ScheduleCreateResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getName(),
                saved.getPassword()
        );

    }

    @Transactional(readOnly = true)
    public List<ScheduleGetResponse> getAll(String name) {
        // DB에서 모든 데이터 조회
        List<Schedule> schedules = scheduleRepo.findAll();
        List<ScheduleGetResponse> scheduleGetResponses = new ArrayList<>();


        if (name == null) {
            schedules.stream()
                    .sorted((s1, s2) -> s2.getModifiedAt().compareTo(s1.getModifiedAt()))
                    .forEach(s -> {
                ScheduleGetResponse dto = new ScheduleGetResponse(
                        s.getId(),
                        s.getTitle(),
                        s.getContent(),
                        s.getName(),
                        s.getCreatedAt(),
                        s.getModifiedAt()
                );
                scheduleGetResponses.add(dto);
            });
        } else {
            schedules.stream().filter(schedule -> schedule.getName().equals(name))
                    .sorted((s1, s2) -> s2.getModifiedAt().compareTo(s1.getModifiedAt()))
                    .forEach(s -> {
                ScheduleGetResponse dto = new ScheduleGetResponse(
                        s.getId(),
                        s.getTitle(),
                        s.getContent(),
                        s.getName(),
                        s.getCreatedAt(),
                        s.getModifiedAt()
                );
                scheduleGetResponses.add(dto);
            });
        }
        // 엔티티 => DTO

        return scheduleGetResponses;
    }

    @Transactional(readOnly = true)
    public ScheduleGetDetailResponse getDetail(Long id) {
        Schedule schedule = scheduleRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 값."));

        return new ScheduleGetDetailResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt()
        );
    }

    @Transactional
    public SchedulePutResponse putDetail(Long id, SchedulePutRequest req) {
        SchedulePutResponse schedulePutResponse;

//        private final Long id;
//        private final String title;
//        private final String content;
//        private final String password;
//        private final String modifiedAt;
        Schedule schedule = scheduleRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 아이디"));
        if(schedule.getPassword().equals(req.getPassword())) {
            return new SchedulePutResponse(
                    schedule.getId(),
                    req.getTitle(),
                    req.getContent(),
                    req.getPassword(),
                    schedule.getModifiedAt()
            );
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

}
