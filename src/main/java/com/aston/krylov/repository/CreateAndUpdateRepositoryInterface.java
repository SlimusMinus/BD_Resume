package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

public interface CreateAndUpdateRepositoryInterface {
    void saveResume(Resume resume);
    void saveWork(Work work);
    void updateResume(Resume resume);
}
