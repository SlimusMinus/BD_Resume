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
}
