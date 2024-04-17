package com.aston.krylov.mapper;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ResumeAndWorkMapper implements ResumeAndWorkMapperInterface {
    private static final Logger log = LoggerFactory.getLogger(ResumeAndWorkMapper.class);

    @Override
    public ResumeDTO resumeToDTO(Resume resume) {
        if (resume == null) {
            log.warn("{} resume not found", resume);
            return null;
        } else {
            ResumeDTO dto = new ResumeDTO();
            dto.setName(resume.getName());
            dto.setSurname(resume.getSurname());
            dto.setAge(resume.getAge());
            dto.setEmail(resume.getEmail());
            if (resume.getWork() != null) {
                dto.setWork(workToDTO(resume.getWork()));
                log.debug("{} work was add in {} resume", resume.getWork(), resume);
            }
            return dto;
        }
    }
    
    @Override
    public List<WorkDTO> workToDTO(List<Work> work) {
        if (work == null) {
            log.warn("{} work not found", work);
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
            log.debug("{} works add in DB", work);
            return workDTOList;
        }

    }

}
