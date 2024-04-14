package com.aston.krylov.service;

import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.SaveWork;

public class CreateWorkService {
    SaveWork saveWork = new SaveWork();
    public void createResume(Work work) {
        if (work != null) {
            saveWork.save(work);
        }
    }
}
