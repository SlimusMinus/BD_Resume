package com.aston.krylov.mapper;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

import java.util.List;

public class ResumeMapper {
    public static ResumeDTO toDTO(Resume resume) {
        if (resume == null) {
            return null;
        }

        ResumeDTO dto = new ResumeDTO();
        dto.setName(resume.getName());
        dto.setSurname(resume.getSurname());
        dto.setAge(resume.getAge());
        dto.setEmail(resume.getEmail());

        if (resume.getWork() != null) {
            dto.setWork(WorkMapper.toDTO(resume.getWork()));
        }

        return dto;
    }

}
