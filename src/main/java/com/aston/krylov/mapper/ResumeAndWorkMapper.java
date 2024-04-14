package com.aston.krylov.mapper;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

import java.util.ArrayList;
import java.util.List;

public class ResumeAndWorkMapper implements ResumeAndWorkMapperInterface {

    @Override
    public ResumeDTO resumeToDTO(Resume resume) {
        if (resume == null) {
            return null;
        } else {
            ResumeDTO dto = new ResumeDTO();
            dto.setName(resume.getName());
            dto.setSurname(resume.getSurname());
            dto.setAge(resume.getAge());
            dto.setEmail(resume.getEmail());
            if (resume.getWork() != null) {
                dto.setWork(workToDTO(resume.getWork()));
            }
            return dto;
        }
    }
    
    @Override
    public List<WorkDTO> workToDTO(List<Work> work) {
        if (work == null) {
            return null;
        } else {
            List<WorkDTO> workDTOList = new ArrayList<>();
            for (Work item : work) {
                WorkDTO dto = new WorkDTO();
                dto.setName(item.getName());
                dto.setStartDate(item.getStartDate());
                dto.setEndDate(item.getEndDate());
                dto.setResponsibilities(item.getResponsibilities());
                workDTOList.add(dto);
            }
            return workDTOList;
        }

    }

}
