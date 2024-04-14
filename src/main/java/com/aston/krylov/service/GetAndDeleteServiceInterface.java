package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;

import java.util.List;

public interface GetAndDeleteServiceInterface {
    public void deleteResume(Long id);
    public List<ResumeDTO> getAllResumes();
    public ResumeDTO getResume(Long id);
}
