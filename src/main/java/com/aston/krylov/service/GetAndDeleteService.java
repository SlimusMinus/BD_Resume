package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.mapper.ResumeAndWorkMapper;
import com.aston.krylov.mapper.ResumeAndWorkMapperInterface;
import com.aston.krylov.repository.GetAndDeleteRepository;
import com.aston.krylov.repository.GetAndDeleteRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class GetAndDeleteService implements GetAndDeleteServiceInterface{
    GetAndDeleteRepositoryInterface repository = new GetAndDeleteRepository();
    ResumeAndWorkMapperInterface mapper = new ResumeAndWorkMapper();
    @Override
    public void deleteResume(Long id) {
        repository.delete(id);
    }

    @Override
    public List<ResumeDTO> getAllResumes() {
        List<ResumeDTO> resumes = new ArrayList<>();
        for (Resume item : repository.findAll()) {
            resumes.add(mapper.resumeToDTO(item));
        }
        return resumes;
    }

    @Override
    public ResumeDTO getResume(Long id) {
        Resume resume = repository.findById(id);

        if (resume != null) {
            return mapper.resumeToDTO(resume);
        }
        return null;
    }
}
