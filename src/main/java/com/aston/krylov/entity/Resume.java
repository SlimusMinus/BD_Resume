package com.aston.krylov.entity;

import lombok.*;

import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Resume {
    private long resumeId;
    private String name;
    private String surname;
    private int age;
    private String email;
    private List<Work> work;

    public Resume(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public Resume(long resumeId, String name, String surname, int age, String email) {
        this.resumeId = resumeId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }
}
