package com.aston.krylov.entity;

import lombok.*;

import java.time.LocalDate;

@Data
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
