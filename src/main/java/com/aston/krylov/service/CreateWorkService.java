package com.aston.krylov.service;

import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.SaveWork;

public class CreateWorkService {
    SaveWork saveWork = new SaveWork();
    public void createWork(Work work) {
        if (work != null) {
            saveWork.save(work);
        }
    }
}
