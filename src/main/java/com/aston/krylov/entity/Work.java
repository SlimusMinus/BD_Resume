package com.aston.krylov.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Work {
    private long workId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String responsibilities;
    private Resume resume;
}
