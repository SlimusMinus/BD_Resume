package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.mapper.ResumeMapper;
import com.aston.krylov.repository.FindResumeById;

public class GetResumeByIdService {
    FindResumeById resumes = new FindResumeById();

    public ResumeDTO getResume(Long id) {
        Resume resume = resumes.findById(id);

        if (resume != null) {
            return ResumeMapper.toDTO(resume);
        }
        return null;
    }
}
