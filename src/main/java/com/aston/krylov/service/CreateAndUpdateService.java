package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.CreateAndUpdateRepository;
import com.aston.krylov.repository.CreateAndUpdateRepositoryInterface;

public class CreateAndUpdateService implements CreateAndUpdateServiceInterface {
    CreateAndUpdateRepositoryInterface repository = new CreateAndUpdateRepository();

    @Override
    public void createResume(Resume resume) {
        if (resume != null) {
            repository.saveResume(resume);
        }
    }

    @Override
    public void createWork(Work work) {
        if (work != null) {
            repository.saveWork(work);
        }
    }

    @Override
    public void update(Resume resume) {
        repository.updateResume(resume);
    }
}
