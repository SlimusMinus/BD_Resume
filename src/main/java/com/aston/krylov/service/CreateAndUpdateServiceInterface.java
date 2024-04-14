package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

public interface CreateAndUpdateServiceInterface {
    public void createResume(Resume resume);
    public void createWork(Work work);
    public void update(Resume resume);
}
