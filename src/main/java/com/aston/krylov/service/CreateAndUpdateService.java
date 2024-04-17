package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.CreateAndUpdateRepository;
import com.aston.krylov.repository.CreateAndUpdateRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAndUpdateService implements CreateAndUpdateServiceInterface {
    private static final Logger log = LoggerFactory.getLogger(CreateAndUpdateService.class);

    CreateAndUpdateRepositoryInterface repository = new CreateAndUpdateRepository();

    @Override
    public void createResume(Resume resume) {
        if (resume != null) {
            repository.saveResume(resume);
            log.debug("Resume {} save in DB", resume);
        }
    }

    @Override
    public void createWork(Work work) {
        if (work != null) {
            repository.saveWork(work);
            log.debug("Create work {} in DB", work);

        }
    }

    @Override
    public void update(Resume resume) {
        repository.updateResume(resume);
        log.debug("Resume {} update", resume);

    }
}
