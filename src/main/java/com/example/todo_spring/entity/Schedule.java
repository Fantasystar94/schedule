package com.example.todo_spring.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Schedule extends BaseEntity {
    //속
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50, nullable = false)
    String title;
    @Column(nullable = false)
    String content;
    @Column(length = 20, nullable = false)
    String name;
    @Column(length = 20, nullable = false)
    String password;
    //생
    public Schedule(String title, String content, String name, String password) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    //기
    public void update(String title, String content, String name, String password) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }
}
