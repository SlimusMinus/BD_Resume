package com.aston.krylov.service;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.repository.GetAndDeleteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DisplayName("Checking that")
class GetAndDeleteServiceTest {
    private final GetAndDeleteRepository repository = Mockito.mock(GetAndDeleteRepository.class);
    private final Resume resume1 = new Resume("Ivan", "Petrov", 25, "123@rambler.ru");
    private final Resume resume2 = new Resume("Petr", "Smirnov", 33, "456@rambler.ru");
    private final Resume resume3 = new Resume(1, "John", "Smith", 44, "789@rambler.ru");

    @Test
    @DisplayName("method delete called with correct parameter")
    void deleteResume() {
       repository.delete(1L);
       Mockito.verify(repository).delete(1L);

    }

    @Test
    @DisplayName("method getAllResumes returned all resumes")
    void getAllResumes() {
        List<Resume> list = Arrays.asList(resume1, resume2, resume3);
        Mockito.when(repository.findAll()).thenReturn(list);
        List<Resume> listTest = repository.findAll();
        assertThat(list).isEqualTo(listTest);
    }

    @Test
    @DisplayName("method getResume returned a specific resume")
    void getResume() {
        Mockito.when(repository.findById(1L)).thenReturn(resume3);
        Resume getResume = repository.findById(1L);
        assertThat(resume3).isEqualTo(getResume);
    }
}