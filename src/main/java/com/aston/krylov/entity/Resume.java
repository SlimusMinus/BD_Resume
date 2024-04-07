package com.aston.krylov.entity;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Resume {
    private long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String name_Work;
    private Work work;

    public Resume(String name, String surname, int age, String email, String name_Work, Work work) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.name_Work = name_Work;
        this.work = work;
    }
}
