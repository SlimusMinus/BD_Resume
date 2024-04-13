package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.mapper.ResumeMapper;
import com.aston.krylov.repository.FindAllResumes;

import java.util.ArrayList;
import java.util.List;

public class GetAllResumeService {
    FindAllResumes findAllResumes = new FindAllResumes();
    public List<ResumeDTO> getAllResumes() {
        List<ResumeDTO> resumes = new ArrayList<>();
        for (Resume item : findAllResumes.findAll()) {
            resumes.add(ResumeMapper.toDTO(item));
        }
        return resumes;
    }
}
