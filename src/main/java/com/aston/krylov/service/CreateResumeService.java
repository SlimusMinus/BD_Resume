package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.repository.SaveResume;

public class CreateResumeService {
    SaveResume saveResume = new SaveResume();
    public void createResume(Resume resume) {
        if (resume != null) {
            saveResume.save(resume);
        }
    }
}