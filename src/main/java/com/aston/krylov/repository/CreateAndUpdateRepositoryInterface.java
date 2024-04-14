package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

public interface CreateAndUpdateRepositoryInterface {
    public void saveResume(Resume resume);
    public void saveWork(Work work);
    public void updateResume(Resume resume);
}
