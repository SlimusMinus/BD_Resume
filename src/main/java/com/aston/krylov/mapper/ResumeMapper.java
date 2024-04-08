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
        dto.setName_Work(resume.getName_Work());

        // Преобразование объекта Work, если присутствует
        if (resume.getWork() != null) {
            dto.setWork(WorkMapper.toDTO((Work) resume.getWork()));
        }

        return dto;
    }

    public static Resume fromDTO(ResumeDTO resumeDTO) {
        if (resumeDTO == null) {
            return null;
        }

        Resume resume = new Resume();
        resume.setName(resumeDTO.getName());
        resume.setSurname(resumeDTO.getSurname());
        resume.setAge(resumeDTO.getAge());
        resume.setEmail(resumeDTO.getEmail());
        resume.setName_Work(resumeDTO.getName_Work());

        // Преобразование объекта WorkDTO, если присутствует
        if (resumeDTO.getWork() != null) {
            //resume.setWork(WorkMapper.fromDTO(resumeDTO.getWork()));
        }

        return resume;
    }
}
