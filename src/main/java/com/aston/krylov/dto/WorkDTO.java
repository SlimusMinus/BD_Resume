package com.aston.krylov.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private String responsibilities;
}
