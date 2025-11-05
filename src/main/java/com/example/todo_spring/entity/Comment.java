package com.example.todo_spring.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    //속
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String content;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String password;
    @Column(nullable = false)
    private Long scheduleId;
    //생
    public Comment(String content, String name, String password, Long scheduleId)
    {
        this.content = content;
        this.name = name;
        this.password = password;
        this.scheduleId = scheduleId;
    }

    //기
    public void update(String content, String name, String password) {
        this.content = content;
        this.name = name;
        this.password = password;
    }
}
