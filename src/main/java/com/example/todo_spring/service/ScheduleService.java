package com.example.todo_spring.service;

import com.example.todo_spring.dto.*;
import com.example.todo_spring.entity.Comment;
import com.example.todo_spring.entity.Schedule;
import com.example.todo_spring.repository.CommentRepository;
import com.example.todo_spring.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    //속
    private final ScheduleRepository scheduleRepo;
    private final CommentRepository commentRepo;
    //생

    //기
    @Transactional
    public ScheduleCreateResponse save(int status, ScheduleCreateRequest req) {

        Schedule schedule = new Schedule(
                req.getTitle(),
                req.getContent(),
                req.getName(),
                req.getPassword()
        );

        Schedule saved = scheduleRepo.save(schedule);

        return new ScheduleCreateResponse(
                status,
                "createResponse",
                new ScheduleCreateResponseData(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getName(),
                        schedule.getPassword()
                )
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleGetResponse> getAll(int status, String name) {
        // DB에서 모든 데이터 조회
        List<Schedule> schedules = scheduleRepo
                .findAll()
                .stream()
                .sorted((s1, s2) -> s2.getModifiedAt().compareTo(s1.getModifiedAt()))
                .collect(Collectors.toList());
        List<ScheduleGetResponse> scheduleGetResponses = new ArrayList<>();
        List<ScheduleGetReponseData> scheduleGetReponsesData = new ArrayList<>();
        if (name == null) {
            schedules.forEach(s -> {
                scheduleGetReponsesData.add(new ScheduleGetReponseData(
                    s.getId(),
                    s.getTitle(),
                    s.getContent(),
                    s.getName(),
                    s.getCreatedAt(),
                    s.getModifiedAt()
                ));
            });
        } else {
            schedules.stream().filter(schedule -> schedule.getName().equals(name))
                    .forEach(s -> {
                        scheduleGetReponsesData.add(new ScheduleGetReponseData(
                            s.getId(),
                            s.getTitle(),
                            s.getContent(),
                            s.getName(),
                            s.getCreatedAt(),
                            s.getModifiedAt()
                        ));
            });
        }
        ScheduleGetResponse result = new ScheduleGetResponse(
                status,
                "getResponse",
                scheduleGetReponsesData
        );
        scheduleGetResponses.add(result);
        return scheduleGetResponses;
    }

    @Transactional(readOnly = true)
    public ScheduleGetDetailResponse getDetail(int status, Long id) {
        Schedule schedule = scheduleRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 값."));
        List<CommentDetailResponseData> commentRes = commentRepo
                .findAll()
                .stream()
                .filter( c -> c.getScheduleId().equals(id))
                .map( c ->
                new CommentDetailResponseData(
                    c.getContent(),
                    c.getName(),
                    c.getScheduleId(),
                    c.getCreatedAt(),
                    c.getModifiedAt()
                )).collect(Collectors.toList());
        return new ScheduleGetDetailResponse(
                status,
                "getDetailResponse",
                new ScheduleGetReponseData(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getName(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ),
                commentRes
        );
    }

    @Transactional
    public SchedulePutResponse putDetail(Long id,int status ,SchedulePutRequest req) {
        Schedule schedule = scheduleRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 아이디"));
        if(schedule.getPassword().equals(req.getPassword())) {

            return new SchedulePutResponse(
                    status,
                    "putResponse",
                    new SchedulePutReponseData(
                            schedule.getId(),
                            req.getTitle(),
                            req.getContent(),
                            req.getPassword(),
                            schedule.getModifiedAt()
                    )
            );
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    @Transactional
    public ScheduleDelResponse deleteDetail(int status, Long id, ScheduleDelRequest req) {

        Schedule schedule = scheduleRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 아이디"));
        if (schedule.getPassword().equals(req.getPassword())) {
            scheduleRepo.delete(schedule);
            return new ScheduleDelResponse(
                    status,
                    "deleteResponse"
            );
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    @Transactional
    public CommentResponse commentSave(int status, Long id, CommentRequest req) {

        //코멘트 저장
        Comment comment = new Comment(
                req.getContent(),
                req.getName(),
                req.getPassword(),
                id
        );
        //한 일정 당 10개의 댓글만 가능.
        //comment의 아이디를 찾아서 몇개인지확인
        //findAll().stream().~~ id 와 schid 를 비교. 이후 ++.
        CommentResponse scheduleCommentResponse;
        long count = commentRepo.findAll()
                .stream()
                .filter( c -> c.getScheduleId().equals(id))
                .count();
        if (count < 10) {
            Comment saved = commentRepo.save(comment);
            CommentCreateResponseData scheduleCreateCommentResponseData = new CommentCreateResponseData(comment);
            scheduleCommentResponse = new CommentResponse(status,"postMessage", scheduleCreateCommentResponseData);
            //비밀번호 제외하고 리턴해주기
        } else {
            throw new IllegalArgumentException("댓글은 한 게시글에 10개씩만 게시 가능합니다.");
        }

        return scheduleCommentResponse;
    }
}
