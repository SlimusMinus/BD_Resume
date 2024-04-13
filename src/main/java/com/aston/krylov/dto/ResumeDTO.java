package com.aston.krylov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {
    private String name;
    private String surname;
    private int age;
    private String email;
    private List<WorkDTO> work;

    public ResumeDTO(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.work = new ArrayList<>();
    }
}
