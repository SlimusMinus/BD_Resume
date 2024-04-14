package com.aston.krylov.service;

import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.CreateAndUpdateRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class CreateWorkServiceTest {
    @Mock
    private CreateAndUpdateRepositoryInterface saveWork;

    @InjectMocks
    private CreateAndUpdateService createWorkService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateResumeWithNonNullResume() {
        // Создаем экземпляр Resume
        Work work = new Work();
        // Устанавливаем необходимые значения

        // Вызываем метод createResume
        createWorkService.createWork(work);

        // Проверяем, что метод save был вызван с правильным аргументом
        verify(saveWork).saveWork(work);
    }
}