package com.aston.krylov.service;

import com.aston.krylov.repository.DeleteResume;

public class DeleteResumeService {
    DeleteResume deleteResume = new DeleteResume();

    public void deleteResume(Long id) {
        deleteResume.delete(id);
    }
}
