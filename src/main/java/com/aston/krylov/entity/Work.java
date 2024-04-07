package com.aston.krylov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    private long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String responsibilities;

    public Work(String name, LocalDate startDate, LocalDate endDate, String responsibilities) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.responsibilities = responsibilities;
    }
}
