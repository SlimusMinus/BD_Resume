package com.aston.krylov.mapper;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

import java.util.List;

public interface ResumeAndWorkMapperInterface {
    public List<WorkDTO> workToDTO(List<Work> work);
    public ResumeDTO resumeToDTO(Resume resume);
}
