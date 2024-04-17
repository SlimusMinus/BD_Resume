package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.CreateAndUpdateRepository;
import com.aston.krylov.repository.CreateAndUpdateRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

@DisplayName("Checking that")
class CreateAndUpdateServiceTest {

    CreateAndUpdateRepositoryInterface repositoryInterface;
    Resume resumeCreate = new Resume("Ivan", "Petrov", 25, "123@rambler.ru");
    Resume resumeUpdate = new Resume("Artem", "Ivanov", 18, "987@rambler.ru");

    Work work = new Work("Apple", LocalDate.of(2012,12,8), LocalDate.now(), "manger", 1);
    @BeforeEach
    void setUp(){
        repositoryInterface = Mockito.mock(CreateAndUpdateRepository.class);
    }

    @Test
    @DisplayName("method create resume called with correct parameter")
    void createResume() {
        Mockito.doNothing().when(repositoryInterface).saveResume(resumeCreate);
        repositoryInterface.saveResume(resumeCreate);
        Mockito.verify(repositoryInterface).saveResume(resumeCreate);
    }

    @Test
    @DisplayName("method create resume called with correct parameter")
    void createWork() {
        Mockito.doNothing().when(repositoryInterface).saveWork(work);
        repositoryInterface.saveWork(work);
        Mockito.verify(repositoryInterface).saveWork(work);
    }

    @Test
    @DisplayName("method update resume called with correct parameter")
    void update() {
        Mockito.doNothing().when(repositoryInterface).updateResume(resumeUpdate);
        repositoryInterface.updateResume(resumeUpdate);
        Mockito.verify(repositoryInterface).updateResume(resumeUpdate);
    }
}