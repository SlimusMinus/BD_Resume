package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.repository.UpdateResume;
import lombok.Data;

@Data
public class UpdateResumeService {
    private UpdateResume updateResume = new UpdateResume();

    public void update(Resume resume) {
        updateResume.updateResume(resume);
    }
}
