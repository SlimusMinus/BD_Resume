package com.aston.krylov.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Resume {

    private long resumeId;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String name_Work;
    private List<Work> work;

}
