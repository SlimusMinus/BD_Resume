package com.aston.krylov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {
    private String name;
    private String surname;
    private int age;
    private String email;
    private String name_Work;
    private List<WorkDTO> work;
}
