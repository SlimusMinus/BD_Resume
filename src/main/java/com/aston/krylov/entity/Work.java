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
    private long resume_id;

    public Work(String name, LocalDate startDate, LocalDate endDate, String responsibilities, long resume_id) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.responsibilities = responsibilities;
        this.resume_id = resume_id;
    }
}
